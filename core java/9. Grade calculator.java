import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int marks;
        String grade;

        System.out.println("Simple Grade Calculator");
        System.out.print("Enter marks (out of 100): ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number for marks.");
            input.next(); 
            System.out.print("Enter marks (out of 100): ");
        }
        marks = input.nextInt();

        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must be between 0 and 100.");
        } else {
           
            if (marks >= 90) {
                grade = "A";
            } else if (marks >= 80) {
                grade = "B";
            } else if (marks >= 70) {
                grade = "C";
            } else if (marks >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.println("Your grade is: " + grade);
        }

        input.close();
    }
}
