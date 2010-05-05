public enum TrafficLight {
  red ("Please stop"), green ("Please go"), yellow ("Please caution");

  private String description;

  TrafficLight(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
