java -jar lib/antlr-4.9-complete.jar -package model -o model CUSTOM.g4
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar;lib/antlr-4.9-complete.jar"  model/*.java controller/*.java builder/errorcheckers/*.java console/*.java view/*.java components/*.java semantics/analyzers/*.java semantics/representations/*.java semantics/symboltable/scopes/*.java semantics/symboltable/*.java semantics/utils/*.java execution/commands/*.java execution/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  controller/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  builder/errorcheckers/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  console/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar"  view/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar"  components/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/analyzers/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/representations/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/symboltable/scopes/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/symboltable/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  semantics/utils/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  execution/commands/*.java
@REM javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  execution/*.java

javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar;lib/antlr-4.9-complete.jar"  app.java
java --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar;lib/antlr-4.9-complete.jar" app