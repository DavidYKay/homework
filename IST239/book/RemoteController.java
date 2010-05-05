class RemoteController {
  private Command onCommand, offCommand;

  public RemoteController(Command onCommand, Command offCommand) {
    this.onCommand = onCommand;
    this.offCommand = offCommand;
  }

  public void clickOn() {
    onCommand.execute();
  }

  public void clickOff() {
    offCommand.execute();
  }

  public void setOnCommand(Command onCommand) {
    this.onCommand = onCommand;
}

  public void setOffCommand(Command offCommand) {
    this.offCommand = offCommand;
  }
}
