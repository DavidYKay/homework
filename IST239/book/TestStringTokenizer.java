import java.util.StringTokenizer;

class TestStringTokenizer {
  public static void main(String[] args) {
    String s = "Java is cool.";
    StringTokenizer tokenizer = new StringTokenizer(s, "v.", true);

    System.out.println("The total number of tokens is " +
      tokenizer.countTokens());

    while (tokenizer.hasMoreTokens())
      System.out.println(tokenizer.nextToken());

    System.out.println("Any tokens left? " + tokenizer.countTokens());
  }
}
