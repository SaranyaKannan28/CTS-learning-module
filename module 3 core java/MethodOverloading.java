import java.util.Scanner;

public class MethodOverloading {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MethodOverloading calculator = new MethodOverloading();
        Scanner input = new Scanner(System.in);

        System.out.println("Java Method Overloading Demonstration");
        System.out.println("-------------------------------------");

        System.out.print("Enter first integer for sum: ");
        int int1_1 = input.nextInt();
        System.out.print("Enter second integer for sum: ");
        int int1_2 = input.nextInt();
        int sumInt1 = calculator.add(int1_1, int1_2);
        System.out.println("Sum of two integers (" + int1_1 + ", " + int1_2 + "): " + sumInt1);
        System.out.println();

        System.out.print("Enter first double for sum: ");
        double double1_1 = input.nextDouble();
        System.out.print("Enter second double for sum: ");
        double double1_2 = input.nextDouble();
        double sumDouble1 = calculator.add(double1_1, double1_2);
        System.out.println("Sum of two doubles (" + double1_1 + ", " + double1_2 + "): " + sumDouble1);
        System.out.println();

        System.out.print("Enter first integer for sum (three integers): ");
        int int2_1 = input.nextInt();
        System.out.print("Enter second integer for sum (three integers): ");
        int int2_2 = input.nextInt();
        System.out.print("Enter third integer for sum (three integers): ");
        int int2_3 = input.nextInt();
        int sumInt2 = calculator.add(int2_1, int2_2, int2_3);
        System.out.println("Sum of three integers (" + int2_1 + ", " + int2_2 + ", " + int2_3 + "): " + sumInt2);
        System.out.println();
        
        input.close();
    }
