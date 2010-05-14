public class TestDecorator {
  public static void main(String[] args) {
    Book book = new CustomCore();
    book = new CustomBookDecorator(19, book);
    book = new CustomBookDecorator(24, book);
    book = new CustomBookDecorator(25, book);

    System.out.println("contents are " + book.toString());
    System.out.println("cost is " + book.cost());
  }
}

interface Book {
  public double cost();
}

class CustomCore implements Book {
  public double cost() {
    return 50;
  }

  public String toString() {
    return "Custom Core";
  }
}

class CustomBookDecorator implements Book {
  private Book book;
  int chapterNo;

  public CustomBookDecorator(int chapterNo, Book book) {
    this.book = book;
    this.chapterNo = chapterNo;
  }

  public double cost() {
    return book.cost() + 2;
  }

  public String toString() {
    return book.toString() + ", Chapter " + chapterNo;
  }
}
