grammar CUSTOM;

program
    : mainBlock funcBlock*
    ;

mainBlock
    : Main LeftParen RightParen LeftBrace declarationList RightBrace
    ;

funcBlock
    : Func (typeSpecifier | arrayTypeSpecifier) IDENTIFIER LeftParen params RightParen statement
    | Func Void IDENTIFIER LeftParen params RightParen statement //think about void statement
    ; 

declarationList
    : declarationList declaration
    | declaration
    ;

declaration
    : arrayDeclaration
    | variableDeclaration 
    ;

arrayDeclaration
    : arrayTypeSpecifier arrayDeclarationList Semi
    ;

arrayDeclarationList
    : arrayDeclarationList Comma arrayDeclarationInitialize
    | arrayDeclarationInitialize
    ;

arrayDeclarationInitialize
    : arrayDeclarationIdentifier
    | arrayDeclarationIdentifier Assign arrayExpression
    ;

arrayDeclarationIdentifier
    : IDENTIFIER
    ;

variableDeclaration
    : ConstantKey? typeSpecifier variableDeclarationList Semi
    ;

    
scopedVariableDeclaration
    : typeSpecifier variableDeclarationList Semi
    ;

variableDeclarationList
    : variableDeclarationList Comma variableDeclarationInitialize
    | variableDeclarationInitialize
    ;

variableDeclarationInitialize
    : variableDeclarationIdentifier
    | variableDeclarationIdentifier Assign simpleExpression
    ;

variableDeclarationIdentifier
    : IDENTIFIER
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
    : paramList 
    | 
    ;

paramList
    : paramList Comma paramTypeList
    | paramTypeList
    ;

paramTypeList
    : typeSpecifier paramDeclarationIdentifer
    ;

paramDeclarationIdentifer
    : IDENTIFIER
    | IDENTIFIER LeftBracket RightBracket
    ;

/* statements */
statement
    : expressionStatement
    | compoundStatement
    | selectionStatement
    | iterationStatement
    | returnStatement
    ;

expressionStatement
    : expression Semi
    | Semi
    ;

compoundStatement
    : LeftBrace localDeclarations statementList RightBrace
    ;

localDeclarations
    : localDeclarations scopedVariableDeclaration
    | 
    ;

selectionStatement
    : If LeftParen expression RightParen Then statement (Else statement)?
    ;

statementList
    : statementList statement
    | 
    ;

iterationStatement
    : whileStatement
    | forStatement
    ;

whileStatement
    : While IDENTIFIER Upto loopExpression compoundStatement
    | While IDENTIFIER Downto loopExpression compoundStatement
    ;

forStatement
    : For loopDeclaration Upto loopExpression compoundStatement
    | For loopDeclaration Downto loopExpression compoundStatement
    ; 

loopDeclaration
    : Int IDENTIFIER Assign simpleExpression
    | IDENTIFIER Assign simpleExpression
    | IDENTIFIER
    ;

loopExpression
    : 
    ;

returnStatement
    : Return Semi
    | Return expression Semi
    ;

/*expressions */
expression
    : mutable Assign expression
    | simpleExpression
    | arrayExpression
    ;

simpleExpression
    : andExpression
    | simpleExpression OrOr andExpression
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
    | mulExpression
    ;

sumop
    : Plus
    | Minus
    ;

mulExpression
    : mulExpression mulop unaryExpression
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
    : argList Comma expression
    | expression
    ;

constant
    : INTEGERCONSTANT
    | FLOATCONSTANT
    | STRINGCONSTANT
    | True
    | False 
    ;

/* keywords */
ConstantKey : 'constant';
Int : 'int';
Float : 'float';
String : 'string';
Boolean : 'bool';

Do : 'do';
Else : 'else';
For : 'for';
If : 'if';
Then: 'then';
Return : 'return';
Void : 'void';
While : 'while';
Create: 'create';
Main: 'main';
Func: 'func';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';

Plus : '+';
Minus : '-';
Star : '*';
Div : '/';
Mod : '%';

AndAnd : '&&';
OrOr : '||';
Not : '!';

Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';

Equal : '==';
NotEqual : '!=';

Dot : '.';
Ellipsis : '...';

Up : 'up';
Down : 'down';
To: 'to';
Upto: Up To;
Downto: Down To;
True: 'T';
False: 'F';
Break: 'break';

DoubleQuotation: '"';

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
    :   ~["\\\r\n]
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