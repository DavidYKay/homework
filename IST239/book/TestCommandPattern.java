public class TestCommandPattern {
  public static void main(String[] args) {
    TV tv = new TV();
    Command tvOnCommand = new TVOnCommand(tv);
    Command tvOffCommand = new TVOffCommand(tv);
    RemoteController controller =
      new RemoteController(tvOnCommand, tvOffCommand);
    controller.clickOn();
    controller.clickOff();

    VCR vcr = new VCR();
    Command vcrOnCommand = new VCROnCommand(vcr);
    Command vcrOffCommand = new VCROffCommand(vcr);
    controller.setOnCommand(vcrOnCommand);
    controller.setOffCommand(vcrOffCommand);
    controller.clickOn();
    controller.clickOff();
  }
}
