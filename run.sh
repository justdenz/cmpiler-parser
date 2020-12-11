# Compile g4 file
java -jar lib/antlr-4.9-complete.jar -package parser -o parser CUSTOM.g4
# Compile All Java Files (Replace * to compile specific file)
javac -cp ".:lib/antlr-4.9-complete.jar" *.java
# Run Main
java -cp ".:lib/antlr-4.9-complete.jar" Main