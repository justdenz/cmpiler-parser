# Compile g4 file
java -jar lib/antlr-4.9-complete.jar -package model -o model CUSTOM.g4
# Compile All Java Files (Replace * to compile specific file)
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib/antlr-4.9-complete.jar"  model/*.java controller/*.java builder/errorcheckers/*.java console/*.java view/*.java components/*.java semantics/analyzers/*.java semantics/representations/*.java semantics/symboltable/scopes/*.java semantics/symboltable/*.java semantics/utils/*.java execution/commands/*.java execution/*.java

javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib/antlr-4.9-complete.jar"  app.java
# javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib/antlr-4.9-complete.jar" *.java
# Run App
java --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib/antlr-4.9-complete.jar" app