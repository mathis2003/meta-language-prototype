
----- base language -----

expr ::= lambda | string

lambda ::= "\->" body

body ::= "{" statement "}"

statement ::= returnstmt | printstmt

returnstmt ::= "return" expr

printstmt ::= "print" string

string ::= """  [^"]* """

int ::= [0-9]+

----- language extension -----

loop ::= "for" int "to" int body
