import java.util.*;
import java.text.*;

interface Visitor {
  public void visitInteger(IntegerElement element);
  public void visitDate(DateElement element);
}

class ConcreteVisitor implements Visitor {
  public void visitInteger(IntegerElement element) {
    NumberFormat formatter = NumberFormat.getNumberInstance();
    System.out.println(formatter.format(element.getValue()));
  }

  public void visitDate(DateElement element) {
    DateFormat formatter = DateFormat.getDateTimeInstance();
    System.out.println(formatter.format(element.getValue()));
  }
}

interface Element {
  public abstract void accept(Visitor visitor);
}

class IntegerElement implements Element {
  private Integer value;

  public IntegerElement(Integer value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void accept(Visitor visitor) {
     visitor.visitInteger(this);
  }
}

class DateElement implements Element {
  private Date value;

  public DateElement(Date value) {
    this.value = value;
  }

  public Date getValue() {
    return value;
  }

  public void accept(Visitor visitor) {
     visitor.visitDate(this);
  }
}

public class VisitorDemo {
  public static void main(String[] args) {
    Element[] list = {new IntegerElement(1000),
      new DateElement(new Date())};
    for (int i = 0; i < list.length; i++)
      list[i].accept(new ConcreteVisitor());
  }
}
