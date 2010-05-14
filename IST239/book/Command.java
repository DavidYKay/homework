interface Command {
  public void execute();
}

class TVOnCommand implements Command {
  private TV tv;

  public TVOnCommand(TV tv) {
    this.tv = tv;
  }

  public void execute() {
    tv.turnOn();
  }
}

class TVOffCommand implements Command {
  private TV tv;

  public TVOffCommand(TV tv) {
    this.tv = tv;
  }

  public void execute() {
    tv.turnOff();
  }
}

class VCROnCommand implements Command {
  private VCR vcr;

  public VCROnCommand(VCR vcr) {
    this.vcr = vcr;
  }

  public void execute() {
    vcr.start();
  }
}

class VCROffCommand implements Command {
  private VCR vcr;

  public VCROffCommand(VCR vcr) {
    this.vcr = vcr;
  }

  public void execute() {
    vcr.stop();
  }
}
