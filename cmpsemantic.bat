javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  builder/errorcheckers/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  builder/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/analyzers/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/representations/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/symboltable/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/utils/*.java
java --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar;lib/antlr-4.9-complete.jar" app