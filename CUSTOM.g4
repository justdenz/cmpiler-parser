grammar CUSTOM;

program
    : funcBlock* mainBlock
    ;

mainBlock
    : Main LeftParen RightParen LeftBrace (declarationList | statement) * RightBrace
    ;

funcBlock
    : Func (typeSpecifier | arrayTypeSpecifier) IDENTIFIER LeftParen params RightParen statement*
    | Func Void IDENTIFIER LeftParen params RightParen statement* //think about void statement
    ; 

declarationList
    : declarationList declaration
    | declaration
    ;

declaration
    : arrayDeclaration Semi
    | variableDeclaration Semi
    ;

arrayDeclaration
    : arrayTypeSpecifier arrayDeclarationList
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
    : ConstantKey? typeSpecifier variableDeclarationList
    ;

    
scopedVariableDeclaration
    : arrayDeclaration Semi
    | variableDeclaration Semi
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
    : scanStatement
    | printStatement
    | expressionStatement
    | compoundStatement
    | selectionStatement
    | iterationStatement
    | returnStatement
    ;

scanStatement
    : Scan LeftParen STRINGCONSTANT* Comma IDENTIFIER RightParen Semi
    ;

printStatement
    : Print LeftParen printStatementList RightParen Semi
    ;

printStatementList
    : (sumExpression | STRINGCONSTANT)
    | printStatementList Plus (sumExpression | STRINGCONSTANT)
    ;

expressionStatement
    : expression Semi
    | Semi
    ;

compoundStatement
    : LeftBrace (localDeclarations | statementList)* RightBrace
    ;

localDeclarations
    : localDeclarations scopedVariableDeclaration
    | scopedVariableDeclaration
    ;

selectionStatement
    : If LeftParen conditionalExpression RightParen Then LeftBrace statement* RightBrace selectionStatementList?
    ;

selectionStatementList
    : ElseIf LeftParen conditionalExpression RightParen Then LeftBrace statement* RightBrace selectionStatementList?
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
    : For IDENTIFIER (Up | Down) To sumExpression compoundStatement
    | For IDENTIFIER Assign simpleExpression (Up | Down) To sumExpression compoundStatement
    | For Int IDENTIFIER Assign simpleExpression (Up | Down) To sumExpression compoundStatement
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
    | sumExpression
    | mulExpression
    ;

conditionalExpression
    : sumExpression relop sumExpression
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
String : 'String';
Boolean : 'bool';

Do : 'do';
Else : 'else';
For : 'for';
If : 'if';
ElseIf: 'else if';
Then: 'then';
Return : 'return';
Void : 'void';
While : 'while';
Create: 'create';
Main: 'main';
Func: 'func';
Scan: 'scan';
Print: 'print';

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