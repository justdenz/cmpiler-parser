package components;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.concurrent.Task;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.reactfx.Subscription;

public class EditorArea {

  private static final String[] KEYWORDS = new String[] {
    "bool",
    "constant",
    "else",
    "then",
    "String",
    "float",
    "for",
    "up",
    "if",
    "down",
    "to",
    "int",
    "return",
    "void",
    "while",
    "T",
    "F",
  };

  private static final String KEYWORD_PATTERN ="\\b(" + String.join("|", KEYWORDS) + ")\\b";
  private static final String PAREN_PATTERN = "\\(|\\)";
  private static final String BRACE_PATTERN = "\\{|\\}";
  private static final String BRACKET_PATTERN = "\\[|\\]";
  private static final String SEMICOLON_PATTERN = "\\;";
  private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
  private static final String COMMENT_PATTERN ="//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

  private static final Pattern PATTERN = Pattern.compile(
    "(?<KEYWORD>" +
    KEYWORD_PATTERN +
    ")" +
    "|(?<PAREN>" +
    PAREN_PATTERN +
    ")" +
    "|(?<BRACE>" +
    BRACE_PATTERN +
    ")" +
    "|(?<BRACKET>" +
    BRACKET_PATTERN +
    ")" +
    "|(?<SEMICOLON>" +
    SEMICOLON_PATTERN +
    ")" +
    "|(?<STRING>" +
    STRING_PATTERN +
    ")" +
    "|(?<COMMENT>" +
    COMMENT_PATTERN +
    ")"
  );

  private static final String test = "test.txt";

  public ExecutorService executor;
  private CodeArea codeArea = new CodeArea();

  public CodeArea addEditorArea() {
    executor = Executors.newSingleThreadExecutor();
    codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
    Subscription cleanupWhenDone = codeArea
      .multiPlainChanges()
      .successionEnds(Duration.ofMillis(500))
      .supplyTask(this::computeHighlightingAsync)
      .awaitLatest(codeArea.multiPlainChanges())
      .filterMap(
        t -> {
          if (t.isSuccess()) {
            return Optional.of(t.get());
          } else {
            t.getFailure().printStackTrace();
            return Optional.empty();
          }
        }
      )
      .subscribe(this::applyHighlighting);

    if(test != ""){
      File file = new File(test);
      Scanner sc;
      try {
        sc = new Scanner(file);
          String s = "";
        while (sc.hasNextLine()) {
          s += sc.nextLine() + "\n";
        }
        codeArea.appendText(s);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return codeArea;
  }

  public String getInput() {
    return codeArea.getText();
  }

  private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
    String text = codeArea.getText();
    Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {

      @Override
      protected StyleSpans<Collection<String>> call() throws Exception {
        return computeHighlighting(text);
      }
    };
    executor.execute(task);
    return task;
  }

  private void applyHighlighting(StyleSpans<Collection<String>> highlighting) {
    codeArea.setStyleSpans(0, highlighting);
  }

  private static StyleSpans<Collection<String>> computeHighlighting(
    String text
  ) {
    Matcher matcher = PATTERN.matcher(text);
    int lastKwEnd = 0;
    StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
    while (matcher.find()) {
      String styleClass = matcher.group("KEYWORD") != null
        ? "keyword"
        : matcher.group("PAREN") != null
          ? "paren"
          : matcher.group("BRACE") != null
            ? "brace"
            : matcher.group("BRACKET") != null
              ? "bracket"
              : matcher.group("SEMICOLON") != null
                ? "semicolon"
                : matcher.group("STRING") != null
                  ? "string"
                  : matcher.group("COMMENT") != null ? "comment" : null;
      /* never happens */assert styleClass != null;
      spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
      spansBuilder.add(
        Collections.singleton(styleClass),
        matcher.end() - matcher.start()
      );
      lastKwEnd = matcher.end();
    }
    spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
    return spansBuilder.create();
  }
}
