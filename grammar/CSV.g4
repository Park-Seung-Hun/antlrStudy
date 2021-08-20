grammar CSV;

file : hdr row+ ;
hdr : row ; // grammar ������ �ܼ� row���� ��Ȱ�� �� ��Ȯ�ϰ� ���.

row : field (',' field)* '\r'? '\n' ;

field
    :   TEXT
    |   STRING
    |
    ;

TEXT : ~[,\n\r"]+ ;
STRING : '"' ('""'|~'"')* '"' ; // quote-quote is an escaped quote
/*
    �࿡ 2���� ū ����ǥ�� ����ϴ� CSV ���˿� ����
    ('""'|~'"')* ������� Ȱ���Ѵ�.
*/
