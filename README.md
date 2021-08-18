# antlrStudy
- 실습 환경 : Shell

### Ch.1 Install ANTLR

[설치 URL](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md)

- ANTLR 설치 : .jar를 다운로드하고 적절한 위치에 이동 시키는 것이 전부
  - jar은 ANTLR가 생성한 인식기(Parser/Lexer)를 컴파일 하고 실행하는데 필요한 Tool과 라이브러리를 실행하는 필수 모듈을 포함
    - Tool : 그래머가 서술한 언어의 문장을 인식하는 프로그램으로 그래머를 변환
    - 라이브러리 : -> 트리 레이아웃 라이브러리, StringTemplate(자바 템플릿 엔진)
    
- ANTLR 실행 (Intelli J)
  1.	*.g4 인 파일을 만든다.
  2.	그래머 작성
  3.	*.g4 파일로 ANTLR Recognizer를 만든 후(*Parser.java *Lexer.java가 삽입된 실행 가능한 인식기를 생성) rule을 테스트.(컴파일된 인식기를 호출하기 위해 자바 Reflection을 사용한다.)
  
- ANTLR 실행 (Shell)
  1.	*.g4 인 파일을 만든다.
  2.	그래머 작성
  3. TestRig 생성(테스팅 툴) => grun command를 alias로 만든다. 
    - grun {테스팅 파일(g4)} {rule} [Option]



### Ch.2 Big Picture

- 인터프리터 : 응용 프로그램이 문장을 계산하거나 실행하는 경우 (계산기, 구성파일 리더, 파이썬 인터프리터)
- 트랜스레이터 : 문장을 한 언어로부터 다른 언어로 변환하는 경우 (Java to C# 변환기와 컴파일러)
- ```Parser(구문 분석기)``` : 언어를 인식하는 프로그램 (구문은 룰을 참조한다.)
  - grammar : 룰의 집합
  - Rule : 구문의 구조

- Lexer : 입력을 토큰화하는 프로그램 (토큰화: 단어나 심볼(토큰)로 문자를 그룹핑하는 프로세스)
  - INT, ID, Float등과 같이 관련된 토큰을 토큰 클래스나 토큰 타입으로 그룹핑 한다.
  - 토큰은 "토큰 타입(어휘 구조 식별)"과 "렉서에 의해 토큰에 매치된 텍스트"등 최소 2가지 정보를 가진다.

- Parser : 입력 문장의 구조와 컴포넌트 구문을 인식하는지 기록한 Parse Tree(파스 트리)나 Syntax Tree(구문 트리)라 부르는 데이터 구조를 빌드한다.
  - parse tree 구조(직렬 순차)
    - 루트 노드 : 가장 상위의 추상 구문 이름
    - 말단 노드 : 입력 토큰
    
- Parser 구현
  - 회귀적 하향 파서를 생성한다 by ANTLR Tool (Tree root -> Leave)
```java
// example parser
// assign : ID '=' expr ';'; -> 일반적 파서 생성
void assign(){
  match(ID);
  match('=');
  expr();
  match(';');
}

// stat : assign | ifstat | whilestat --- ; -> assign을 호출하는 stat
void stat(){
  switch({현재 입력 토큰}){
    CASE ID :assing(); break;
    CASE IF : ifstat(); break;
    CASE WHILE : whilestat(); break;
    ...
    default
  }
}
```

- 모호한 구문과 문장은 여러 해석을 유발하기 때문에 주의해야한다.
- parse tree를 이용한 랭귀지 응용 프로그램
  - parse tree Listener : ???
  - parse tree Visitor : ???
  
### Ch.3 ANTLR 프로젝트 스타터
  - 실습(/starter)

### Ch.4 퀵 투어
  - ANTLR의 기능을 표현하는 여러가지 예제들을 4단계를 통해 학습
   
1. Simple 산술연산 랭귀지의 그래머 작업
  - 표현식 그래머를 위한 중요한 파스 트리(파서가 입력 구문을 매치하는 방식을 기록)
  - import를 사용하여 관리가능한 Chunk로 그래머를 분리하는 방법
  - ANTLR이 생성한 구문이 유효하지 않은 입력에 어떻게 반응하는가?

2. 산술연산을 위한 Parser를 살펴본 다음에 표현식 그래머 parse tree를 탐색하는 계산기를 빌드하기 위해 visitor Pattern을 사용.
3. 자바 클래스 정의를 읽고 그 클래스의 메소드로부터 도출된 자바 인터페이스를 분할하는 Translator를 빌드
4. Action(임의 코드)를 그래머에 직접적으로 삽입하는 방법. (보통의 경우 랭귀지 응용 프로그램 -> visitor or listener로 빌드) (flexible한 특성을 위해 응용 프로그램에 특화된 코드를 생성된 파서에 삽입하는 것을 허용)

#### 산술식 언어 매칭
  - 간단한 계산기 빌드. 기본적신 산술연산자 + 괄호 + 정수 및 변수만 허용 (부동소수점 x)

1. 샘플 입력 t.expr
```txt
193
a=5
b=6
a+b*2
(1+2)*3
```


2. grammar 생성 Expr.g4
```g4
grammar Expr; // grammar의 파일명과 같아야 한다.

/** The start rule; begin parsing here. */
/*구문을 설명하는 룰 세트로 구성. stat과 expr 같은 구문구조를 위한 룰 and 식별자나 정수같은 어휘 심볼을 위한 룰 존재. */
prog:   stat+ ; 


/*stat과 expr을 위한 rule -> 소문자로 시작하는 룰(parser룰) */
/*대체 룰은 '|'연산자로 구분하며, 심볼을 괄호로 묶어 서브롤로 그룹핑 할 수 있다. ex) ('*'|'/')은 곱셈 심볼과 나눗셈 심볼로 매치.*/
stat:   expr NEWLINE                
    |   ID '=' expr NEWLINE        
    |   NEWLINE                   
    ;

expr:   expr ('*'|'/') expr   
    |   expr ('+'|'-') expr   
    |   INT                    
    |   ID                    
    |   '(' expr ')'         
    ;


/*식별자나 정수 등 어휘 심볼을 위한 rule -> 대문자로 시작하는 룰(lexer룰,어휘&토큰)*/
ID  :   [a-zA-Z]+ ;      // match identifiers <label id="code.tour.expr.3"/>
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace

```

3. ExprJoyRide.java 파일 생성 (TestRig으로도 그래머를 개발하고 테스트하지만, ANTLR이 생성한 파서를 응용 프로그램에 통합하기 위한 코드) 


#### grammar import
- 매우 큰 grammar는 논리적 chunks로 분할하는 것이 유리. (grammar = parser + lexer grammar로 분리하는 것)

1. CommonLexerRules.g4 : 모든 어휘적 룰을 가진 렉서 그래머
```g4
lexer grammar CommonLexerRules; // note "lexer grammar" => 모든 어휘적 룰을 가진 렉서 그래머.

ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace

```

2. 원래 grammar로 부터 어휘적 룰을 import로 대체. LibExpr.g4

```g4
grammar LibExpr;         // Rename to distinguish from original
import CommonLexerRules; // includes all rules from CommonLexerRules.g4
/** The start rule; begin parsing here. */
prog:   stat+ ; 

stat:   expr NEWLINE                
    |   ID '=' expr NEWLINE        
    |   NEWLINE                   
    ;

expr:   expr ('*'|'/') expr   
    |   expr ('+'|'-') expr  
    |   INT                    
    |   ID                    
    |   '(' expr ')'    
    ;
```

#### 에러 입력 처리
- ANTRL 파서는 구문 에러를 자동으로 리포트하고 복구한다.
- 자세한 사항은 9장
