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

variableDeclarationIdentifer
    : IDENTIFIER
    | IDENTIFIER '[' INTEGERCONSTANT ']'
    ;

typeSpecifier
    : 'int'
    | 'bool'
    | 'String'
    | 'float'
    ;

functionDeclaration
    : typeSpecifier IDENTIFIER '(' params ')' statement
    | 'void' IDENTIFIER '(' params ')' statement
    ; 

/* keywords */

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
True: 'true';
False: 'false';

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

IDENTIFIER
    : Letter ( Letter | Digit )*
    ;