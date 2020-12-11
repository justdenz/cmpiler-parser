# Compile g4 file
java -jar lib/antlr-4.9-complete.jar -package parser -o parser CUSTOM.g4
# Compile All Java Files (Replace * to compile specific file)
javac --module-path lib/javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib/antlr-4.9-complete.jar" *.java
# Run Main
java --module-path lib/javafx-sdk-11.0.2/lib --add-modules javafx.controls -cp ".:lib/richtextfx-fat-0.10.5.jar:lib/antlr-4.9-complete.jar" Main