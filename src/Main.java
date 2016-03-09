import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jana.karim.exceptions.LetterNotFoundException;
import jana.karim.gematria.Gematria;

public class Main {

  public static void main(String[] args) throws IOException {

    Gematria gematria = new Gematria();
    String input;
    /*
     * String input ="My name is Karim and I Karim like to \n" +
     * "read books in my domain of interest.";
     */
    File output = new File("output.txt");
    File text = new File("bible.txt");

    BufferedWriter writer = new BufferedWriter(new FileWriter(output));
    try (BufferedReader reader = new BufferedReader(new FileReader(text))) {
      while ((input = reader.readLine()) != null) {

        for (String line : input.split("\n")) {
          try {
            gematria.storeByWords(line);
          } catch (LetterNotFoundException e) {
            e.printStackTrace();
          }
        }

      }
      gematria.display(writer);
      writer.close();

    }

  }

}
