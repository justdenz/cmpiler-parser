# Compile g4 file
java -jar lib/antlr-4.9-complete.jar -package model -o model CUSTOM.g4
# Compile All Java Files (Replace * to compile specific file)
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  model/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  controller/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  builder/errorcheckers/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  console/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar"  view/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar"  components/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  semantics/analyzers/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  semantics/representations/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  semantics/symboltable/scopes/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  semantics/symboltable/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  semantics/utils/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  execution/commands/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/antlr-4.9-complete.jar"  execution/*.java
javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib"  app.java
# javac --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib/antlr-4.9-complete.jar" *.java
# Run App
java --module-path lib/mac-javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib/antlr-4.9-complete.jar" app