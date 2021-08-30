grammar SQL;

parse
 : sql
 ;

sql
: ( insert_stmt | select_stmt | update_stmt | delete_stmt ) ( ';'+ ( insert_stmt | select_stmt | update_stmt | delete_stmt ) )* ';'*
;

/*
    1. * => 0개 or 다수
    2. ? => 0개 or 1개
    3. + => 1개 or 다수
    4. ~ => not
    () => 여러 얼터너티브 룰 정의
    | => 다중 얼터너티브로 룰 정의 (or이라 생각하면 편함)
*/


/*
Create: Insert문
Read: Select문
Update: Update문
Delete: Delete문
*/

// Create , INSERT INTO 테이블 (컬럼1, 컬럼2)? VALUES (값1,값2),(값3,값4);
insert_stmt
 : K_INSERT
    table_name ( '(' column_name ( ',' column_name )* ')' )?
   ( K_VALUES '(' expr ( ',' expr )* ')' ( ',' '(' expr ( ',' expr )* ')' )* )
 ;

// Read ,  SELECT 컬럼1,컬럼2... FROM 테이블, 테이블*
select_stmt
 :   K_SELECT result_column ( ',' result_column )*
       ( K_FROM ( table ( ',' table )*) )? (  K_SELECT result_column ( ',' result_column )*
                                                ( K_FROM ( table ( ',' table )*) )? )*
 ;

// Update ,  UPDATE 테이블 SET 컬럼 = 값 WHERE 조건문
update_stmt
 : K_UPDATE table K_SET column_name '=' expr ( ',' column_name '=' expr )* ( K_WHERE expr )?
 ;

// Delete ,  DELETE FROM 테이블 WHERE 조건문
delete_stmt
: K_DELETE K_FROM table ( K_WHERE expr )?
;


table
 : table_name
 ;

result_column
 : '*'
 | table_name '.' '*'
 | expr
 ;

// Expression rule
expr
 : literal_value
 | BIND_PARAMETER
 | ( table_name '.' )? column_name
 | unary_operator expr
 | expr '||' expr
 | expr ( '*' | '/' | '%' ) expr
 | expr ( '+' | '-' ) expr
 | expr ( '<<' | '>>' | '&' | '|' ) expr
 | expr ( '<' | '<=' | '>' | '>=' ) expr
 | expr ( '=' | '==' | '!=' | '<>' )  expr
 | '(' expr ')'
 | expr K_AND expr
 | expr K_OR expr
 | expr ( K_ISNULL | K_NOTNULL | K_NOT K_NULL )
 ;

literal_value
 : NUMERIC_LITERAL
 | STRING_LITERAL
 | BLOB_LITERAL
 | K_NULL
 ;

unary_operator
 : '-'
 | '+'
 | '~'
 | K_NOT
 ;


 keyword
  : K_FROM
  | K_INSERT
  | K_ISNULL
  | K_NOT
  | K_NOTNULL
  | K_NULL
  | K_SELECT
  | K_TABLE
  | K_VALUES
  ;

table_name
 : any_name
 ;

column_name
 : any_name
 ;


any_name
 : IDENTIFIER
 | keyword
 | STRING_LITERAL
 | NUMERIC_LITERAL
 | '(' any_name ')'
 ;



SCOL : ';';
DOT : '.';
OPEN_PAR : '(';
CLOSE_PAR : ')';
COMMA : ',';
ASSIGN : '=';
STAR : '*';
PLUS : '+';
MINUS : '-';
TILDE : '~';
PIPE2 : '||';
DIV : '/';
MOD : '%';
LT2 : '<<';
GT2 : '>>';
AMP : '&';
PIPE : '|';
LT : '<';
LT_EQ : '<=';
GT : '>';
GT_EQ : '>=';
EQ : '==';
NOT_EQ1 : '!=';
NOT_EQ2 : '<>';

// http://www.sqlite.org/lang_keywords.html
// SQL keyword

K_INSERT : I N S E R T ' ' I N T O;
K_SELECT : S E L E C T;
K_WHERE : W H E R E;
K_FROM : F R O M;
K_VALUES : V A L U E S;
K_UPDATE : U P D A T E;
K_DELETE : D E L E T E;
K_SET : S E T;
K_TABLE : T A B L E;
K_AND : A N D;
K_OR : O R;
K_ISNULL : I S N U L L;
K_NOT : N O T;
K_NOTNULL : N O T N U L L;
K_NULL : N U L L;

IDENTIFIER
 : '"' (~'"' | '""')* '"'
 | '`' (~'`' | '``')* '`'
 | '[' ~']'* ']'
 | [a-zA-Z_] [a-zA-Z_0-9]* // TODO check: needs more chars in set
 ;

NUMERIC_LITERAL
 : DIGIT+ ( '.' DIGIT* )? ( E [-+]? DIGIT+ )?
 | '.' DIGIT+ ( E [-+]? DIGIT+ )?
 ;

BIND_PARAMETER
 : '?' DIGIT*
 | [:@$] IDENTIFIER
 ;

STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;

BLOB_LITERAL
 : X STRING_LITERAL
 ;

// 띄어쓰기, 공백은 없애야한다

WS : [ \t\r\n]+ -> skip ;

fragment DIGIT : [0-9];
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];