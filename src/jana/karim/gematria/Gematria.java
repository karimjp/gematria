
package jana.karim.gematria;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jana.karim.exceptions.LetterNotFoundException;


public class Gematria {

  public Gematria() {
    this.wordsByCount = new HashMap<Integer, List<String>>();
  }

  public int getWordValue(String word) throws LetterNotFoundException {
    int letterValue;
    int totalWordValue = 0;
    for (char letter : word.toCharArray()) {
      letterValue = getLetterValue(letter);
      totalWordValue += letterValue;
    }
    return totalWordValue;
  }

  public void storeByWords(String line) throws LetterNotFoundException {
    int count;
    for (String word : line.split(" ")) {
      count = getWordValue(word);
      setWordsByCount(word, count);
    }
  }

  public void display(BufferedWriter writer) throws IOException {
    Iterator<Entry<Integer, List<String>>> it = getWordsByCount().entrySet().iterator();
    int count = 0;
    while (it.hasNext()) {

      Entry<Integer, List<String>> pair = it.next();
      String wordListString = String.join(" ", pair.getValue());
      System.out.println(pair.getKey() + " = " + wordListString);
      writer.write(pair.getKey() + " = " + wordListString + '\n');
      count += 1;
      System.out.println(count);
    }
  }

  public int getLetterValue(char letter) throws LetterNotFoundException {
    int letterValue = letter;
    // System.out.print(letter +": " + letterValue + System.lineSeparator());
    if (letterValue == -1) {
      throw new LetterNotFoundException();
    }
    return letterValue;
  }

  public Map<Integer, List<String>> getWordsByCount() {
    return wordsByCount;
  }

  public void setWordsByCount(Map<Integer, List<String>> wordsByCount) {
    this.wordsByCount = wordsByCount;
  }


  public void setWordsByCount(String word, int count) {
    List<String> wordList = getWordsByCount().get(count);

    if (wordList == null) {
      wordList = new ArrayList<String>();
      getWordsByCount().put(count, wordList);
    }
    wordList.add(word);
  }

  private Map<Integer, List<String>> wordsByCount;
}
