grammar JSON;

json: object
    | array
    ;

object
    : '{' pair (',' pair)* '}'
    | '{''}' // �� ��ü
    ;
pair : STRING ':' value;

array
    : '[' value (',' value)* ']'
    | '[' ']' // �� �迭
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

// ������ �ݺ� ���� ���� fragment�� ����Ѵ�.(�ش� ��Ī���� ���ǵ� ���� �ٸ� ���� �꿡���� ȣ��� �� �ִ�.)

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
