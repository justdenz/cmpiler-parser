grammar CUSTOM;

program
    : funcBlock* mainBlock
    ;

mainBlock
    : Main LeftParen RightParen LeftBrace (declarationList | statement) * RightBrace EOF
    ;

funcBlock
    : Func (typeSpecifier | arrayTypeSpecifier) IDENTIFIER LeftParen params RightParen LeftBrace (declarationList | statement) * RightBrace
    | Func Void IDENTIFIER LeftParen params RightParen LeftBrace (declarationList | statement) * RightBrace //think about void statement
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
    : (typeSpecifier | arrayTypeSpecifier) paramDeclarationIdentifer
    ;

paramDeclarationIdentifer
    : IDENTIFIER
    | IDENTIFIER LeftBracket RightBracket
    ;

/* statements */
statement
    : scanStatement Semi
    | printStatement Semi
    | expressionStatement
    | compoundStatement
    | selectionStatement
    | iterationStatement
    | returnStatement
    ;

scanStatement
    : Scan LeftParen scanStatementList RightParen
    ;

scanStatementList
    : STRINGCONSTANT Comma IDENTIFIER
    ;

printStatement
    : Print LeftParen printStatementList RightParen
    ;

printStatementList
    : (sumExpression | STRINGCONSTANT)
    | printStatementList Plus (sumExpression | STRINGCONSTANT)
    ;

expressionStatement
    : expression Semi
    //| Semi
    ;

compoundStatement
    : LeftBrace (variableDeclaration | statementList)* RightBrace
    ;

selectionStatement
    : If LeftParen simpleExpression RightParen Then LeftBrace statement* RightBrace selectionStatementList
    ;

selectionStatementList
    : ElseIf LeftParen simpleExpression RightParen Then LeftBrace statement* RightBrace selectionStatementList
    | Else Then LeftBrace statement* RightBrace
    ;

statementList
    : statement
    | statementList statement
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
    //: For IDENTIFIER (Up | Down) To simpleExpression compoundStatement
    // | For IDENTIFIER Assign simpleExpression (Up | Down) To simpleExpression compoundStatement
    // | For Int IDENTIFIER Assign simpleExpression (Up | Down) To simpleExpression compoundStatement
    : For forCondition compoundStatement
    ; 

forCondition
    : forDeclaration forExpression
    ;

forDeclaration
    : IDENTIFIER
    | Int? IDENTIFIER Assign simpleExpression
    ;

forExpression
    : (Up | Down) To sumExpression
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

conditionalExpression
    : relExpression
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