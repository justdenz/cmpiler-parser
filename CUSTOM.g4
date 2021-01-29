grammar CUSTOM;

program
    : funcBlock* mainBlock
    ;

mainBlock
    : Main LeftParen RightParen compoundStatement EOF
    ;

funcBlock
    : Func funcTypeSpecifier IDENTIFIER LeftParen params RightParen compoundStatement
    ; 

funcTypeSpecifier
    : typeSpecifier
    | arrayTypeSpecifier
    | Void
    ;

declaration
    : arrayDeclaration
    | variableDeclaration
    ;

arrayDeclaration
    : arrayTypeSpecifier arrayDeclarationInitialize (Comma arrayDeclarationInitialize)* Semi
    ;

arrayDeclarationInitialize
    : IDENTIFIER
    | IDENTIFIER Assign arrayExpression
    ;

variableDeclaration
    : ConstantKey? typeSpecifier variableDeclarationInitialize (Comma variableDeclarationInitialize)* Semi
    | ConstantKey? typeSpecifier g=typeSpecifier+ {notifyErrorListeners("Excess " + $g.text + " found in declaration. Consider removing it.");} variableDeclarationInitialize (Comma variableDeclarationInitialize)* Semi
    ;

variableDeclarationInitialize
    : IDENTIFIER
    | IDENTIFIER Assign simpleExpression
    ;

typeSpecifier
    : Int
    | Boolean
    | String
    | Float
    ;

arrayTypeSpecifier
    : typeSpecifier LeftBracket RightBracket
    ;

params
    : paramList (Comma paramList)*
    | 
    ;

paramList
    : (typeSpecifier | arrayTypeSpecifier) IDENTIFIER
    ;

/* statements */
statement
    : scanStatement
    | printStatement
    | expressionStatement
    | compoundStatement
    | selectionStatement
    | iterationStatement
    | returnStatement
    ;

scanStatement
    : Scan LeftParen scanStatementList RightParen Semi
    ;

scanStatementList
    : STRINGCONSTANT Comma IDENTIFIER
    ;

printStatement
    : Print LeftParen printStatementList RightParen Semi
    ;

printStatementList
    : (IDENTIFIER | INTEGERCONSTANT | illegalSymbols) (IDENTIFIER | INTEGERCONSTANT | illegalSymbols)+ {notifyErrorListeners("Missing double quotes in print statement. Consider wrapping it with double quotes.");}
    | (simpleExpression | STRINGCONSTANT)
    | printStatementList Plus (simpleExpression | STRINGCONSTANT)
    | printStatementList Plus {notifyErrorListeners("Excess '+' found in print statement. Consider removing it or concatenate with a variable.");}
    ;

illegalSymbols
    : '!' | ',' | ':' | '-' | ';' | '*' | '{' | '}' | '[' | ']' | '?' | '%' | '^' | '@' | '#' | '`' | '~'
    ;

expressionStatement
    : (experssionStandAlone | call) Semi
    ;

compoundStatement
    : LeftBrace (compoundStatementList)* RightBrace
    ;

compoundStatementList
    : declaration
    | statement
    ;

selectionStatement
    : If LeftParen simpleExpression RightParen Then compoundStatement elseStatement
    ;

elseStatement
    : Else selectionStatement
    | Else Then compoundStatement
    ;

iterationStatement
    : whileStatement
    | forStatement
    ;

whileStatement
    : While IDENTIFIER Up To relExpression compoundStatement
    | While IDENTIFIER Down To relExpression compoundStatement
    ;

forStatement
    : For forCondition compoundStatement
    ; 

forCondition
    : forDeclaration forExpression
    | forDeclaration {notifyErrorListeners("Expecting 'up to' or 'down to' then expression");}
    ;

forDeclaration
    : IDENTIFIER
    | Int? IDENTIFIER Assign simpleExpression
    ;

forExpression
    : (Up | Down) To sumExpression
    | {notifyErrorListeners("Expecting the word 'up' or 'down'");} To sumExpression		
    | (Up | Down) {notifyErrorListeners("Expecting the word 'to'");} sumExpression
    ;

returnStatement
    : Return returnStatementList Semi
    ;

returnStatementList
    : simpleExpression
    ;

/*expressions */
expression
    : mutable Assign expression
    | simpleExpression
    | arrayExpression
    | sumExpression
    | mulExpression
    ;

experssionStandAlone
    : mutable Assign (simpleExpression | arrayExpression)
    ;

conditionalExpression
    : relExpression
    ;

simpleExpression
    : andExpression
    | simpleExpression OrOr andExpression
    | simpleExpression simpleExpression+ {notifyErrorListeners("missing valid operators");}
    ;

arrayExpression
    : Create typeSpecifier LeftBracket sumExpression RightBracket
    ;

andExpression
    : unaryRelExpression
    | andExpression AndAnd unaryRelExpression
    ;

unaryRelExpression
    : Not unaryRelExpression
    | relExpression
    ;

relExpression
    : sumExpression relop sumExpression
    | sumExpression
    ;

relop
    : LessEqual
    | Less
    | Greater
    | GreaterEqual
    | Equal
    | NotEqual
    ;

sumExpression
    : sumExpression sumop mulExpression
    | sumExpression sumop g=sumop+ mulExpression {notifyErrorListeners("Mismatched input " + $g.text + ". Expecting '+', '-', '*', or '/' as operator only.");}
    | mulExpression
    ;

sumop
    : Plus
    | Minus
    ;

mulExpression
    : mulExpression mulop unaryExpression
    | mulExpression mulop g=mulop+ unaryExpression {notifyErrorListeners("Mismatched input " + $g.text + ". Expecting '+', '-', '*', or '/' as operator only.");}
    | unaryExpression
    ;

mulop
    : Star
    | Div
    | Mod
    ;

unaryExpression
    : unaryop unaryExpression
    | factor
    ;

unaryop
    : Minus
    ;

factor
    : immutable
    | mutable
    ;

mutable
    : IDENTIFIER
    | IDENTIFIER LeftBracket expression RightBracket
    ;

immutable
    : LeftParen expression RightParen
    | call
    | constant
    ;

call
    : IDENTIFIER LeftParen args RightParen
    ;

args
    : argList
    | 
    ;

argList
    : expression (Comma expression)*
    | 
    ;

constant
    : INTEGERCONSTANT
    | FLOATCONSTANT
    | STRINGCONSTANT
    | BOOLCONSTANT
    ;

/* keywords */
AndAnd : '&&';
Assign : '=';
Boolean : 'bool';
Break: 'break';
Colon : ':';
Comma : ',';
ConstantKey : 'constant';
Create: 'create';
Div : '/';
Do : 'do';
Dot : '.';
DoubleQuotation: '"';
Down : 'down';
Ellipsis : '...';
Else : 'else';
ElseIf: 'else if';
Equal : '==';
False: 'F';
Float : 'float';
For : 'for';
Func: 'func';
Greater : '>';
GreaterEqual : '>=';
If : 'if';
Int : 'int';
LeftBrace : '{';
LeftBracket : '[';
LeftParen : '(';
Less : '<';
LessEqual : '<=';
Main: 'main';
Minus : '-';
Mod : '%';
Not : '!';
NotEqual : '!=';
OrOr : '||';
Plus : '+';
Print: 'print';
Return : 'return';
RightBrace : '}';
RightBracket : ']';
RightParen : ')';
Scan: 'scan';
Semi : ';';
Star : '*';
String : 'String';
Then: 'then';
To: 'to';
True: 'T';
Up : 'up';
Void : 'void';
While : 'while';

/* primitives */
fragment
Letter
    : [a-zA-Z_]
    ;

fragment
Digit
    : [0-9]
    ;

fragment
DigitSequence
    : Digit+
    ;

fragment
FloatSuffix
    : 'f'
    ; 

fragment
FractionalConstant
    : DigitSequence? '.' DigitSequence
    | DigitSequence '.'
    ;

fragment
DecimalFloatingConstant
    : FractionalConstant FloatSuffix
    ;

fragment
EscapeSequence
    :   SimpleEscapeSequence
    ;

fragment
SimpleEscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;

fragment
SChar
    :   ~["\\\r\n] //everything that is not a \r, \n, and \ is included here as character
    |   EscapeSequence
    |   '\\\n'   // Added line
    |   '\\\r\n' // Added line
    ;

fragment
SCharSequence
    :   SChar+
    ;

fragment
StringLiteral
    : DoubleQuotation SCharSequence? DoubleQuotation
    ;

/* tokens */
INTEGERCONSTANT
    : DigitSequence
    ;

FLOATCONSTANT
    : DecimalFloatingConstant
    ;

BOOLCONSTANT
    : True
    | False
    ;

STRINGCONSTANT
    : StringLiteral
    ;

IDENTIFIER
    : Letter ( Digit | Letter )*
    ;

WHITSPACE
    :   [ \t]+
        -> skip
    ;

NEWLINE
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BLOCKCOMMENT
    :   '/*' .*? '*/'
        -> skip
    ;

LINECOMMENT
    :   '//' ~[\r\n]*
        -> skip
    ;