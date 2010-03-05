import java.util.Scanner;

public class AdditionQuiz {
    public static void main(String[] args) {
        int number1 = (int)(System.currentTimeMillis() % 10);
        int number2 = (int)(System.currentTimeMillis() * 7 % 10);

        //Create scanner
        Scanner input = new Scanner(System.in);

        System.out.print(
            "What is " + number1 + " + " + number1 + "? ");

        int answer = input.nextInt();
        boolean truefalse = (number1 + number2 == answer);
        System.out.println(
            String.format("%i + %i = %i is %s",
                number1,
                number2,
                answer,
                truefalse
            )
        );
    }
}
