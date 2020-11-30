java -jar lib/antlr-4.9-complete.jar -package parser -o parser C.g4
javac -cp ".;lib/antlr-4.9-complete.jar" *.java
java -cp ".;lib/antlr-4.9-complete.jar" Main