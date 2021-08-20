/*
    트리 리스너로 응용 프로그램 구현하기
    1. *.g4 및 테스트 파일 생성
    2. *Listener 인터페이스 = parser rule의 개수 * 2 만큼 (enter / exit) 메소드 생성
    3. *BaseListener 클래스 = @members 영역에서 수동으로 작성한 공백 메소드와 유사하게 default 구현으로 클래스 생성(메소드만 오바리이드하고 구현)
    4.TestPropertyFile 생성 후 컴파일 및 실행.

    -> 리스너 기법은 모든 트리 탐색 및 메소드 트리거가 자동으로 수행되기 때문에 우수하다.
        > 탐색 자체를 제어하지 못하기 때문에 약점이 될 수 있다.
*/

grammar PropertyFile;

file : prop+ ;
prop : ID '=' STRING '\n' ;
ID   : [a-z]+ ;
STRING : '"' .*? '"' ;
