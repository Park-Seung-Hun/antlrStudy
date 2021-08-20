grammar CSV;

file : hdr row+ ;
hdr : row ; // grammar 적으로 단순 row지만 역활을 더 정확하게 명시.

row : field (',' field)* '\r'? '\n' ;

field
    :   TEXT
    |   STRING
    |
    ;

TEXT : ~[,\n\r"]+ ;
STRING : '"' ('""'|~'"')* '"' ; // quote-quote is an escaped quote
/*
    행에 2개의 큰 따옴표를 사용하는 CSV 포맷에 의해
    ('""'|~'"')* 서브룰을 활용한다.
*/
