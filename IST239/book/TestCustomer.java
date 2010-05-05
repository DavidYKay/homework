class Customer {
  State goldState = new Gold(this);
  State silverState = new Silver(this);
  State regularState = new Regular(this);
  State state = regularState;

  public void setState(State state) {
    this.state = state;
  }

  public State getState() {
    return state;
  }

  public void addMiles(int miles) {
    state.addMiles(miles);
  }

  public String toString() {
    return state.toString();
  }
}

abstract class State {
  int awardMiles;
  String status;
  final static int SILVER_THRESHOLD = 20000;
  final static int GOLD_THRESHOLD = 60000;

  public abstract void addMiles(int miles);

  public String getStatus() {
    return status;
  }

  public int getAwardMiles() {
    return awardMiles;
  }

  public void setAwardMiles(int awardMiles) {
    this.awardMiles = awardMiles;
  }

  public String toString() {
    return "Status: " + status + " and award miles: " + awardMiles;
  }
}

class Regular extends State {
  Customer customer;

  public Regular(Customer customer) {
    this.customer = customer;
    status = "Regualar";
  }

  public void addMiles(int miles) {
    awardMiles += miles;
    if (awardMiles > State.GOLD_THRESHOLD) {
      customer.goldState.setAwardMiles(awardMiles);
      customer.setState(customer.goldState);
    }
    else if (awardMiles > State.SILVER_THRESHOLD) {
      customer.silverState.setAwardMiles(awardMiles);
      customer.setState(customer.silverState);
    }
  }
}

class Silver extends State {
  Customer customer;

  public Silver(Customer customer) {
    this.customer = customer;
    status = "Silver";
  }

  public void addMiles(int miles) {
    awardMiles += 2 * miles;
    if (awardMiles > State.GOLD_THRESHOLD) {
      customer.goldState.setAwardMiles(awardMiles);
      customer.setState(customer.goldState);
    }
  }
}

class Gold extends State {
  Customer customer;

  public Gold(Customer customer) {
    this.customer = customer;
    status = "Gold";
  }

  public void addMiles(int miles) {
    awardMiles += 3 * miles;
  }
}

public class TestCustomer {
  public static void main(String[] args) {
    Customer customer = new Customer();
    customer.addMiles(20000);
    System.out.println(customer.toString());

    customer.addMiles(100);
    System.out.println(customer.toString());

    customer.addMiles(100);
    System.out.println(customer.toString());

    customer.addMiles(20000);
    System.out.println(customer.toString());
  }
}
