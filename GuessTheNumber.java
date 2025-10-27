import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to 'Guess the Number'!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have 5 guesses each round. Let's begin!\n");

        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int maxGuesses = 5;
            boolean guessed = false;
            for (int attempt = 1; attempt <= maxGuesses; attempt++) {
                System.out.print("Guess #" + attempt + ": ");
                int userGuess = scanner.nextInt();
                if (userGuess == secretNumber) 
                {
                    System.out.println("Congratulations! You guessed it right!");
                    guessed = true;
                    break;
                } 
                else if (attempt == maxGuesses - 1) 
                {
                    int lowerRange = Math.max(1, secretNumber - 2);
                    int upperRange = Math.min(100, secretNumber + 2);
                    System.out.println("Major Hint! The number is between " + lowerRange + " and " + upperRange + ".");
                } 
                else if (userGuess < secretNumber) 
                {System.out.println("Go higher!");} 
                else 
                {System.out.println("Go lower!");}
            }

            if (!guessed) 
            {System.out.println("\nOut of guesses! The correct number was " + secretNumber + ".");}

            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
            System.out.println();
        }
        System.out.println("Thanks for playing! See you next time!");
        scanner.close();
    }
}

