import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double num1, num2;
        char operator;

        System.out.println("Simple Calculator");

        System.out.print("Enter first number: ");
        while (!input.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            input.next();
            System.out.print("Enter first number: ");
        }
        num1 = input.nextDouble();

        System.out.print("Enter second number: ");
        while (!input.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            input.next();
            System.out.print("Enter second number: ");
        }
        num2 = input.nextDouble();

        System.out.println("Choose an operation (+, -, *, /): ");
        operator = input.next().charAt(0);

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Error: Invalid operation. Please choose from +, -, *, or /.");
                break;
        }

        input.close();
    }
}
