import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.next();
            System.out.print("Enter a number: ");
        }

        int number = input.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        input.close();
    }
}
