# antlrStudy

- 실습 환경 : Shell, intellij

## Ch.1 Install ANTLR

[설치 URL](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md)

- ANTLR 설치 : .jar를 다운로드하고 적절한 위치에 이동 시키는 것이 전부
  - jar은 ANTLR가 생성한 인식기(Parser/Lexer)를 컴파일 하고 실행하는데 필요한 Tool과 라이브러리를 실행하는 필수 모듈을 포함
    - Tool : 그래머가 서술한 언어의 문장을 인식하는 프로그램으로 그래머를 변환
    - 라이브러리 : -> 트리 레이아웃 라이브러리, StringTemplate(자바 템플릿 엔진)
- ANTLR 실행 (Intelli J)
  1. \*.g4 인 파일을 만든다.
  2. 그래머 작성
  3. *.g4 파일로 ANTLR Recognizer를 만든 후 (*Parser.java \*Lexer.java가 삽입된 실행 가능한 인식기를 생성) rule을 테스트.(컴파일된 인식기를 호출하기 위해 자바 Reflection을 사용한다.)
- ANTLR 실행 (Shell)
  1. \*.g4 인 파일을 만든다.
  2. 그래머 작성
  3. TestRig 생성(테스팅 툴) => grun command를 alias로 만든다.
  - grun {테스팅 파일(g4)} {rule} [Option]

## Ch.2 Big Picture

- 인터프리터 : 응용 프로그램이 문장을 계산하거나 실행하는 경우 (계산기, 구성파일 리더, 파이썬 인터프리터)
- 트랜스레이터 : 문장을 한 언어로부터 다른 언어로 변환하는 경우 (Java to C# 변환기와 컴파일러)
- `Parser(구문 분석기)` : 언어를 인식하는 프로그램 (구문은 룰을 참조한다.)

  - grammar : 룰의 집합
  - Rule : 구문의 구조

- Lexer : 입력을 토큰화하는 프로그램 (토큰화: 단어나 심볼(토큰)로 문자를 그룹핑하는 프로세스) -> parser에 전달

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

  1. 가장 쉬운 방법 : parser가 자동 생성한 parse Tree 로 작업 하는 것. -> 자바를 이용해 빌드 가능

- 트리 탐색 메커니즘

  1. parse tree Listener -> 깊이 우선 탐색 :

     - 트리를 탐색하고 리스너에 호출을 트리거하기 위해 ParseTreeWalker클래스를 제공. (랭귀지 응용 프로그램을 만들기 위해, 주변의 더 큰 응용 프로그램을 호출하는 프로그램에 특화된 코드를 가진 ParseTreeListener를 구현.)
     - enter/exit 메소드로 각 그래머에 특정적인 서브클래스를 생성한다. (parser Rule에 따라)

  2. parse tree Visitor :


      - child를 방문하여 명시적으로 메소드를 호출하기 위해, 탐색 자체를 제어할 필요가 있다

- **Listener**
  <img src="https://saumitra.me/images/posts/antlr3.png">

- **Visotor**
  <img src="https://saumitra.me/images/posts/antlr4.png">

## Ch.3 ANTLR 프로젝트 스타터

- 실습(/starter)

## Ch.4 퀵 투어

- ANTLR의 기능을 표현하는 여러가지 예제들을 4단계를 통해 학습

1. Simple 산술연산 랭귀지의 그래머 작업

- 표현식 그래머를 위한 중요한 파스 트리(파서가 입력 구문을 매치하는 방식을 기록)
- import를 사용하여 관리가능한 Chunk로 그래머를 분리하는 방법
- ANTLR이 생성한 구문이 유효하지 않은 입력에 어떻게 반응하는가?

2. 산술연산을 위한 Parser를 살펴본 다음에 표현식 그래머 parse tree를 탐색하는 계산기를 빌드하기 위해 visitor Pattern을 사용.
3. 자바 클래스 정의를 읽고 그 클래스의 메소드로부터 도출된 자바 인터페이스를 분할하는 Translator를 빌드
4. Action(임의 코드)를 그래머에 직접적으로 삽입하는 방법. (보통의 경우 랭귀지 응용 프로그램 -> visitor or listener로 빌드) (flexible한 특성을 위해 응용 프로그램에 특화된 코드를 생성된 파서에 삽입하는 것을 허용)

### 4.1 산술식 언어 매칭

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

##### grammar import

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

##### 에러 입력 처리

- ANTRL 파서는 구문 에러를 자동으로 리포트하고 복구한다.
- 자세한 사항은 9장

### 4.2 visitor로 계산기 구현하기

- grammar를 정제된 상태로 유지하고 랭귀지 응용 프로그램을 구현하기 위해 parse tree visitor와 기타 탐색기를 사용.
- 작은 계산기를 구현하기 위해 visitor pattern을 사용
- visitor를 생성하기 전 rule alternative를 레이블 해야한다.
  - 레이블이란? rule 이름과 충돌하지 않는 어떤 식별자라도 무관함

LabeledExpr.g4

```g4
grammar LabeledExpr; // rename to distinguish from Expr.g4

prog:   stat+ ;

// rule 이름과 다른 # 레이블
stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   NEWLINE                     # blank
    ;

expr:   expr op=('*'|'/') expr      # MulDiv
    |   expr op=('+'|'-') expr      # AddSub
    |   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

// 연산자 리터럴을 위한 token 이름을 정의하고, 이후에 visitor에서 자바 상수로 token 이름을 참조 할 수 있다.
MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;

//
ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace

```

### 4.3 Listener로 번역기 구현하기

- Listener vs Visitor
  - Listener : ANTRL이 제공하는 Walker 오브젝트에 의해 리스너 오브젝트가 호출되는 것.
  - Visitor : 명확한 visit 콜로 차일드를 탐색해야 한다.

### 4.4 Parsing 동안에 조작하기

#### 임의 코드를 그래머에 삽입하기

- 임의 코드를 grammar에 삽입하여 parsing 동안에 값을 계산하고 출력 할 수 있다.
  - 해당 실습은 3tour/Rows에서 실시.
- 결과적으로 `java Col 1 < t.rows` 처럼 parser에게 트리를 빌드하지 말라고 요청하면서 Column 번호를 주어 액션을 실행한다.

####

## Ch 5. grammar 설계하기.

- 내부 데이터 구조 구축, 정보 추출 및 입력 변환 생성 등
  - grammar Build 단계 -> 어휘와 구문 언어 구조 살펴보기 -> ANTRL 표기로 표현
- 4가지 추상적 프로그래밍 언어 패턴
  1. 순차 : 배열의 초기값처럼 엘리먼트의 연속된 순서
  2. 선택 : 여러 얼터너티브 구문 간의 선택
  3. 토큰 의존성 : 한 토큰의 존재는 좌/우 괄호 일치 같은 구문 어딘가에 대응 관계를 가진 대상이 존재해야한다.
  4. 중첩된 구문 : 프로그래밍 언어의 중첩된 서술문 블록이나 중첩된 산술 표현식 같은 자체 유사 언어 구성체.
     - 얼터너티브, 토큰 레퍼런스 및 룰 레퍼런스로 구성된 그래머 룰을 이용해 패턴을 구현한다.

### 5.1 언어 샘플로 부터 그래머 도출하기

```g4
grammar MyG;
rule1 : <<stuff>>
rule2 : <<more stuff>>
```

- Rule 내용 설계
  - 하향식 설계로 룰 오른쪽에 식별된 엘리멘트에서 단계적으로 한 수준 내려간 Rule을 작성한다.

```g4
file : <<줄 바꿈으로 끝나는 일련의 행>>;
row : <<쉼표로 구분된 필드 시퀀스>>
field : <<숫자 or 문자>>
```

### 5.2 지침으로 기존 grammar 사용하기

- 의사코드를 가진 다음에 실제 그래머를 얻기 위해 ANTLR 표기로 번역할 필요가 있다.

### 5.3 ANTLR 그래머로 일반 언어 패턴 인식하기

- 일반적 하향식 전략으로 순차,선택,토큰 의존성, 중첩된 구문 패턴에 집중.

#### 패턴 : 순차

- ch. 5.1 에서의 의사코드 그래머를 어떻게 표현하는가??

```g4
file : (row '\n')*; // \n로 끝나는 행
row : field (',' field)*; // ,로 구분된 필드
field : INT; // 단순 정수
```

#### 패턴 : 선택 (얼터너티브)

- `|` 이나 `or`와 같은 오퍼레이터를 사용하여 그래머적 선택을 분리한다.

```g4
filed : INT | STIRNG;
```

```g4
stmt:node_stmt
    | edge_stmt
    | attr_stmt
    | id '=' id
    | subgraph
    ;
// 언어 구조 stmt를 선택하는 패턴.
```

### 패턴 : 토큰 의존성

- grammar를 표현하기 위한 다양한 의존성 표현을 살펴본다.

```g4
// 벡터 명세
vector : '[' INT+ ']' // [1],[1 2],[1 2 3]....

// 배열의 인덱스(대괄호) , 메소드 호출 (소괄호)
expr: expr '(' exprList? ')' // func call f(), f(x) , f(1,2)....
    | expr '[' expr ']' // array Index a[i], a[i][j]
    ;

// 메소드 선언에서 좌/우 괄호 간의 토큰 의존성
functionDecl
  : type ID '(' formalParameters? ')' block // "void f(int x) {}"
  ;
formalParameters
  : formalparameter (',' formalParameter)*
  ;
formalparameter
  : type ID
  ;

// Object 정의 ["name":"parr"]
object
  : '{' pair (',' pair)*'}'
  | '{''}' // 빈 객체
  ;
pair : STRING ':' value;
```

### 패턴: 중첩된 구문

### ANTLR 핵심표기

- 책 P.86 참고

### 5.6 Lexer 와 Parser 구분 짓기

1. parser가 전혀 볼 필요가 없는 것은 lexer에서 매치하고 폐기한다.
2. 공통 토큰(식별자, 키워드, 스트림 및 숫자)은 lexer에 매치
3. parser가 구분할 필요가 없는 어휘 구조는 단일 토큰으로 묶는다.(ex 부동소수점과 정수를 구분하지 않으면 NUMBER로 정의)

## 5장은 공통 어휘 및 문법 구조이므로 g4 작성시 참고 바람

---

## ch.6 실제 그래머 탐구

1. CSV 포맷(스프레드시트 or 데이터베이스)
2. JSON 포맷 (중첩된 데이터 엘리먼트)
3. DOT (선언형 언어로 그래프를 서술한다.)
4. Cymbol 비객체 지향 프로그래밍 언어
5. R 함수형 프로그래밍 언어
