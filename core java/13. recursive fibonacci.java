import java.util.Scanner;

public class RecursiveFibonacci {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer n to find the nth Fibonacci number: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a positive integer.");
            input.next();
            System.out.print("Enter a positive integer n: ");
        }
        int n = input.nextInt();
        if (n < 0) {
            System.out.println("Fibonacci is not defined for negative numbers.");
        } else {
            int result = fibonacci(n);
            System.out.println("The " + n + "th Fibonacci number is: " + result);
        }
        input.close();
    }
}
