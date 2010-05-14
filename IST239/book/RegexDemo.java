import java.util.regex.*;

public class RegexDemo {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("[\\d]{3}-[\\d]{2}-[\\d]{4}");
    String string = "George's social is 223-34-34343" +
      "Peter's social is 111-35-2222";

    Matcher matcher = pattern.matcher(string);

    while (matcher.find())
      System.out.println(matcher.group());
  }
}
