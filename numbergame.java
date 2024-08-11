import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int number = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7; // Limit the number of attempts
            System.out.println("\nRound " + rounds + ": Guess the number between 1 and 100!");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number!");
                    totalAttempts += attempts;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
                totalAttempts += maxAttempts;
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Consume the newline
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame Over! You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.println("Average attempts per round: " + String.format("%.2f", (double) totalAttempts / rounds));

        scanner.close();
    }
}
