lexer grammar CommonLexerRules; // note "lexer grammar" => 모든 어휘적 룰을 가진 렉서 그래머.

ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
