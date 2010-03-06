public enum QuizType {
         ADD('+') , 
    SUBTRACT('-') , 
    MULTIPLY('x') , 
      DIVIDE('/') ; 

    private char symbol;
    QuizType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
