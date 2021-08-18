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

