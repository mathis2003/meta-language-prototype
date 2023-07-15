expr ::= <lambda> | <unary>

lambda ::= "\->" <body>

body ::= "{" <statement> "}"

statement ::= <returnstmt> | <printstmt>

returnstmt ::= "return" <expr>

printstmt ::= "print" <string>

unary ::= <string> | <int>

string ::= """  [^"]* """

int ::= [0-9]+
