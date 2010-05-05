import java.util.*;

public class CountOccurrenceOfWords {
  public static void main(String[] args) {
    // Text in a string
    String text = "Have a good day. Have a good class. " +
      "Have a good visit. Have fun!";

    // Create a hash map to hold words as key and count as value
    Map<String, Integer> hashMap = new HashMap<String, Integer>();

    String[] words = text.split("[ .!?]");
    for (int i = 0; i < words.length; i++) {
      if (words[i].length() > 1) {
        if (hashMap.get(words[i]) != null) {
          int value = hashMap.get(words[i]).intValue();
          value++;
          hashMap.put(words[i], value);
        }
        else
          hashMap.put(words[i], 1);
      }
    }

    // Create a tree map from the hash map
    Map<String, Integer> treeMap =
      new TreeMap<String, Integer>(hashMap);

    // Display mappings
    System.out.println("Display words and their count in " +
      "ascending order of the words");
    System.out.print(treeMap);
  }
}
