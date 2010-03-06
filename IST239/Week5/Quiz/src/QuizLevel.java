public enum QuizLevel {
    //private static final int MAX_NUM = 1000;

    ZERO_FIVE   ( "Numbers from 0 to 5"  , 0     , 5    ), 
    THREE_NINE  ( "Numbers from 3 to 9"  , 3     , 9    ), 
    ZERO_TWENTY ( "Numbers from 0 to 20" , 0     , 20   ), 
    ANY_TWO     ( "Any two digits"       , -1000 , 1000 ); 

    private final String description;   // in kilograms
    private final int min;
    private final int max;
    QuizLevel(String description, int min, int max) {
        this.description = description;
        this.min = min;
        this.max = max;
    }
    public String getDescription() { return description; } 
    public int getMin() { return min; } 
    public int getMax() { return max; } 
}
