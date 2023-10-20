package CodSoft;
import java.util.Random;
import java.util.Scanner;
public class GuessTheNumber {
    int Number;
    int maximum = 100;
    Scanner sc = new Scanner(System.in);
    int attempt;
    int maxAttempts = 5;
    int wins = 0;
    public GuessTheNumber() {
        Random ran = new Random();
        Number = Math.abs(ran.nextInt()) % (maximum + 1);
    }
    public void play() {
        boolean playAgain = true;
        while (playAgain) {
            Random ran = new Random();
            Number= Math.abs(ran.nextInt()) % (maximum + 1);
            attempt= 0;
            System.out.println("New game started");
            System.out.println("You have total 5 attempts ");
            while (attempt < maxAttempts) {
                System.out.print("Enter your Number: ");
                int guess = sc.nextInt();
                attempt++;
                if (guess > Number) {
                    System.out.println("Your Guess is too high");
                } else if (guess < Number) {
                    System.out.println("Your Guess is too low");
                } else if (guess == Number) {
                    wins++;
                    System.out.println("Congratulations, you guessed it right, your current score is " + wins);
                    break;
                }
                if (attempt < maxAttempts) {
                    System.out.println("Attempts left: " + (maxAttempts - attempt));
                } else {
                    System.out.println("Your Attempts are over, the number was: " + Number + " & your score was:" + wins);
                }
            }
            System.out.println("Do you want to restart the game(yes/no):");
            String playAgainInput = sc.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
            if (!playAgain) {
                System.out.println("Game is ended.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Game");
        GuessTheNumber gues = new GuessTheNumber();
        gues.play();
    }
}
