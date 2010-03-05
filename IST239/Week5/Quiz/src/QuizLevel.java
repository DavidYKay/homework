public enum QuizLevel {
    ZERO_FIVE("Numbers from 0 to 5"),
    THREE_NINE("Numbers from 3 to 9"),
    ZERO_TWENTY("Numbers from 0 to 20"),
    ANY_TWO("Any two digits");

    private final String description;   // in kilograms
    QuizLevel(String description) {
        this.description = description;
    }
    public String description()   { return description; }
}
