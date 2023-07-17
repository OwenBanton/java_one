// Owen Banton

import Assignment4.Character;

import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {

    public static void main(String[] args) {


        int staticSeed = 123; // Secret number = 2069.

        //int randomSeed = (int) (Math.random() * 1000);     // Random 3 digit seed.

        playBullsAndCows(staticSeed);

    }

    // Method to receive inputs from and print messages to the user based on their guess.

    public static void playBullsAndCows(int seed) {

        int secretDigits[] = generateSecretDigits(seed);

        int guessCount = 1;

        System.out.println("Welcome to Bulls and Cows.");
        System.out.println("Please enter a four-digit number to begin, each digit should be unique.");

        Scanner guessInput = new Scanner(System.in);
        int guess = guessInput.nextInt();

        fourDigits(guess);

        int[] guessArray = guessToArray(guess);

        noDuplicates(guessArray);

        bullCount(secretDigits, guessArray);

        if (bullCount(secretDigits, guessArray) == 4) {
            System.out.println("Congratulations, you guessed the number on your first try!");
        }

        while (bullCount(secretDigits, guessArray) != 4) {
            System.out.println("Results for guess #" + guessCount + ".");
            System.out.println("Bulls: " + (getNumOfBulls(secretDigits, guessArray)));
            System.out.println("Cows: " + (getNumOfCows(secretDigits, guessArray)));
            System.out.println("Please enter your next guess:");
            Scanner guessInputNew = new Scanner(System.in);
            int guessNew = guessInputNew.nextInt();
            fourDigits(guessNew);
            int[] guessArrayNew = guessToArray(guessNew);
            noDuplicates(guessArrayNew);
            guessArray = guessArrayNew;
            guessCount++;
        }
        if (getNumOfBulls(secretDigits, guessArray) == 4) {
            System.out.println("Congratulations! You guessed the secret number");
            System.out.println("on turn number " + guessCount + ".");
        }

    }

    // Method to check if an array contains a specific integer. Required for assignment but not currently in use.

    public static boolean contains(int[] array, int integer) {

        boolean check = (integer == array[0]) || (integer == array[1])
                || (integer == array[2]) || (integer == array[3]);

        return check;
    }

    // Method to generate number for user to guess, with while loops to avoid duplicate numbers in the array.

    public static int[] generateSecretDigits(int seed) {

        int[] secretDigits;
        secretDigits = new int[4];

        Random random = new Random(seed);

        secretDigits[0] = (random.nextInt(10));

        secretDigits[1] = (random.nextInt(10));
        while (secretDigits[1] == secretDigits[0]) {
            secretDigits[1] = random.nextInt(10);
        }

        secretDigits[2] = (random.nextInt(10));
        while (secretDigits[2] == secretDigits[0] || secretDigits[2] == secretDigits[1]) {
            secretDigits[2] = random.nextInt(10);

        }

        secretDigits[3] = (random.nextInt(10));
        while (secretDigits[3] == secretDigits[0] || secretDigits[3] == secretDigits[1] ||
                secretDigits[3] == secretDigits[2]) {
            secretDigits[3] = random.nextInt(10);
        }

        return secretDigits;
    }

    // Straightforward method comparing two arrays to check for bulls.

    public static int getNumOfBulls(int[] secret, int[] guess) {

        int bulls = 0;

        if (secret[0] == guess[0]) {
            bulls++;
        }
        if (secret[1] == guess[1]) {
            bulls++;
        }
        if (secret[2] == guess[2]) {
            bulls++;
        }
        if (secret[3] == guess[3]) {
            bulls++;
        }
        return bulls;
    }

    // Method to iterate through and compare each element of the guess and secret digit arrays.

    public static int getNumOfCows(int[] secret, int[] guess) {

        int cows = 0;

        for (int i = 0; i < secret.length; i++) {
            if (guess[0] == secret[i]) {
                cows++;
            }
        }
        for (int i = 0; i < secret.length; i++) {
            if (guess[1] == secret[i]) {
                cows++;
            }
        }
        for (int i = 0; i < secret.length; i++) {
            if (guess[2] == secret[i]) {
                cows++;
            }
        }
        for (int i = 0; i < secret.length; i++) {
            if (guess[3] == secret[i]) {
                cows++;
            }
        }
        return cows;
    }

    // Method to convert guess input to an array for use in other methods.

    public static int[] guessToArray(int guess) {

        String stringGuess = String.valueOf(guess);

        int firstDigit = Character.getNumericValue(stringGuess.charAt(0));
        int secondDigit = Character.getNumericValue(stringGuess.charAt(1));
        int thirdDigit = Character.getNumericValue(stringGuess.charAt(2));
        int fourthDigit = Character.getNumericValue(stringGuess.charAt(3));

        int guessArray[] = {firstDigit, secondDigit, thirdDigit, fourthDigit};

        return guessArray;

    }

    // Method to return the number of bulls, used to determine if the user has guessed correctly.

    public static int bullCount(int[] secretDigits, int[] guessArray) {

        return getNumOfBulls(secretDigits, guessArray);

    }

    // Method to ensure the user's input is a four-digit number.

    public static void fourDigits(int guess) {

        String guessString = Integer.toString(guess);

        if (guessString.length() != 4) {
            throw new RuntimeException("Guess must be a four-digit number.");
        }
    }

    /* Method to ensure the user's input does not contain any duplicates. Iterates through the array comparing each
    element to the one after it.*/

    public static void noDuplicates(int[] guess) {

        for (int i = 0; i < guess.length; i++) {
            for (int j = i + 1; j < guess.length; j++) {
                if ((i != j) && guess[j] == guess[i]) {
                    throw new RuntimeException("Guess cannot contain duplicate numbers.");
                }
            }
        }
    }
}