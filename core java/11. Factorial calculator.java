import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorialCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.next();
            System.out.print("Enter a non-negative integer: ");
        }

        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 1; i <= number; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println("Factorial of " + number + " is: " + factorial);
        }

        input.close();
    }
}
