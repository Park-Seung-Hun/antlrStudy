grammar JSON;

json: object
    | array
    ;

object
    : '{' pair (',' pair)* '}'
    | '{''}' // 빈 객체
    ;
pair : STRING ':' value;

array
    : '[' value (',' value)* ']'
    | '[' ']' // 빈 배열
    ;
value
    : STRING
    | NUMBER
    | object // recursion
    | array
    | 'true' // keyword
    | 'false'
    | 'null'
    ;


STRING :  '"' (ESC | ~["\\])* '"' ;

// 여러번 반복 정의 보단 fragment를 사용한다.(해당 약칭으로 정의된 룰은 다른 렉서 룰에서만 호출될 수 있다.)

fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

NUMBER
    :   '-'? INT '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP             // 1e10 -3e4
    |   '-'? INT                 // -3, 45
    ;
fragment INT :   '0' | [1-9] [0-9]* ; // no leading zeros
fragment EXP :   [Ee] [+\-]? INT ; // \- since - means "range" inside [...]

WS  :   [ \t\n\r]+ -> skip ;
