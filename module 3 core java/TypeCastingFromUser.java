import java.util.Scanner;

public class TypeCastingFromUser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a double value: ");
        while (!input.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid double.");
            input.next();
            System.out.print("Enter a double value: ");
        }
        double userDouble = input.nextDouble();
        int castedInt = (int) userDouble;

        System.out.print("Enter an int value: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            input.next();
            System.out.print("Enter an int value: ");
        }
        int userInt = input.nextInt();
        double castedDouble = userInt;

        System.out.println("Double entered: " + userDouble);
        System.out.println("After casting to int: " + castedInt);
        System.out.println("Int entered: " + userInt);
        System.out.println("After casting to double: " + castedDouble);

        input.close();
    }
}
