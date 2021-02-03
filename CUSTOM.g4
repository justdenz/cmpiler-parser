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
    : ConstantKey? arrayTypeSpecifier arrayDeclarationInitialize Semi
    ;

arrayDeclarationInitialize
    : IDENTIFIER (Assign arrayExpression)?
    | IDENTIFIER (Assign mutable)?
    ;

variableDeclaration
    : ConstantKey? typeSpecifier variableDeclarationInitialize Semi
    // | ConstantKey? typeSpecifier g=typeSpecifier+ {notifyErrorListeners("Excess " + $g.text + " found in declaration. Consider removing it.");} variableDeclarationInitialize (Comma variableDeclarationInitialize)* Semi
    ;

variableDeclarationInitialize
    : IDENTIFIER (Assign simpleExpression)?
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
    : Scan LeftParen StringLiteral Comma IDENTIFIER RightParen Semi
    ;

printStatement
    : Print LeftParen printStatementList RightParen Semi
    ;

printStatementList
    : (IDENTIFIER | INTEGERCONSTANT | illegalSymbols) (IDENTIFIER | INTEGERCONSTANT | illegalSymbols)+ {notifyErrorListeners("Missing double quotes in print statement. Consider wrapping it with double quotes.");}
    | printParameters (Plus printParameters)*
    | printStatementList Plus {notifyErrorListeners("Excess '+' found in print statement. Consider removing it or concatenate with a variable.");}
    ;

printParameters
    : StringLiteral
    | call
    | IDENTIFIER
    | simpleExpression
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
    : If LeftParen simpleExpression RightParen Then compoundStatement elseStatement?
    ;
    
elseStatement
    : Else Then compoundStatement
    | Else selectionStatement
    ;

iterationStatement
    : whileStatement
    | forStatement
    ;

whileStatement
    : While IDENTIFIER upDownToStatement simpleExpression compoundStatement
    ;

forStatement
    : For forCondition upDownToStatement simpleExpression compoundStatement
    ; 

upDownToStatement
    : Upto
    | Downto
    | Up {notifyErrorListeners("Missing 'to' after the word 'up'");}
    | Down {notifyErrorListeners("Missing 'to' after the word 'down'");}
    | To {notifyErrorListeners("Missing 'up' or 'down' before the word 'to'");}
    ;

forCondition
    : Int IDENTIFIER Assign simpleExpression
    | Int IDENTIFIER {notifyErrorListeners("Newly declared variables in loops needs to be assigned to a value immediately.");}
    | IDENTIFIER Assign simpleExpression
    | IDENTIFIER
    ;

returnStatement
    : Return simpleExpression Semi
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

BOOLCONSTANT
    : True
    | False
    ;
    
simpleExpression
    : andExpression
    | simpleExpression OrOr andExpression
    | simpleExpression simpleExpression+ {notifyErrorListeners("missing valid operators");}
    ;

arrayExpression
    : Create typeSpecifier LeftBracket simpleExpression RightBracket
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
    | IDENTIFIER LeftBracket simpleExpression RightBracket
    ;

immutable
    : constant
    | call
    | LeftParen simpleExpression RightParen
    ;

call
    : IDENTIFIER LeftParen args RightParen
    ;

args
    : simpleExpression (Comma simpleExpression)*
    | 
    ;

constant
    : INTEGERCONSTANT
    | BOOLCONSTANT
    | StringLiteral
    | FLOATCONSTANT
    ;

/* keywords */
True: 'T';
False: 'F';
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
Equal : '==';
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
Space
    : [ ]
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

Upto
    : Up Space+ To
    ;

Downto
    : Down Space+ To
    ;

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