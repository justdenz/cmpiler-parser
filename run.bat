java -jar lib/antlr-4.9-complete.jar -package model -o model CUSTOM.g4
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  model/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/antlr-4.9-complete.jar"  controller/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar"  view/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar"  components/*.java
javac --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar;lib"  app.java
java --module-path lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls -cp ";lib/richtextfx-fat-0.10.5.jar;lib/antlr-4.9-complete.jar" app