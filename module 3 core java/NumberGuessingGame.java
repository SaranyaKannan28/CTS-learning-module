import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int randomNumber = random.nextInt(100) + 1;
        int userGuess;
        int numberOfAttempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have generated a random number between 1 and 100.");
        System.out.println("Can you guess what it is?");
        System.out.println("--------------------------------------------------");

        while (!hasGuessedCorrectly) {
            numberOfAttempts++;

            System.out.print("Enter your guess (Attempt " + numberOfAttempts + "): ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a whole number.");
                input.next();
                System.out.print("Enter your guess (Attempt " + numberOfAttempts + "): ");
            }
            userGuess = input.nextInt();

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Your guess is out of range. Please guess a number between 1 and 100.");
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("\nCongratulations! You've guessed the number " + randomNumber + " correctly!");
                System.out.println("It took you " + numberOfAttempts + " attempts.");
            }
        }

        input.close();
    }
}
