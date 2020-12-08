grammar CUSTOM;

program
    :declarationList
    ;

declarationList
    : declarationList
    | declarationList declarationList
    ;

declaration
    : variableDeclaration
    | functionDeclaration
    ;

variableDeclaration
    : typeSpecifier variableDeclarationList
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
    | IDENTIFIER LeftBracket INTEGERCONSTANT RightBracket
    ;

typeSpecifier
    : 'int'
    | 'bool'
    | 'String'
    | 'float'
    ;

functionDeclaration
    : typeSpecifier IDENTIFIER LeftParen params RightParen statement
    | Void IDENTIFIER LeftParen params RightParen statement
    ; 

params
    : paramList 
    | Epsilon
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
    | breakStatement
    ;

expressionStatement
    : expression Semi
    | Semi
    ;

compoundStatement
    : LeftBrace localDeclarations statementList RightBrace
    ;

localDeclarations
    : localDeclarations variableDeclaration
    | Epsilon
    ;

statementList
    : statementList statement
    | Epsilon
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
    | Return expression
    ;

/* keywords */
Epsilon : '';
Constant : 'constant';
Int : 'int';
Float : 'float';
String : 'string';

Do : 'do';
Else : 'else';
For : 'for';
If : 'if';
Return : 'return';
Void : 'void';
While : 'while';

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

DoubleQuotation: '\"';

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
    : Letter ( Letter | Digit )*
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