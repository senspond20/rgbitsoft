grammar Calculator;
@header {
    package com.rgbitsoft.core.parser.calculator;
}
expression :
    expression op=(MUL | DIV) expression #mulDiv
    | expression op=(ADD | SUB) expression #addSub
    | number #num
    | '(' expression ')' #parens
;

number : NUMBER;

MUL : '*';

DIV : '/';

ADD : '+';

SUB : '-';

NUMBER : ('0'..'9')+ ('.' ('0'..'9')+)?;

WS : [ \t\r\n]+ -> skip;