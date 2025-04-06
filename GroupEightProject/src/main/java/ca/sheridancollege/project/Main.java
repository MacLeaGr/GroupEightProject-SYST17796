package ca.sheridancollege.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String name = null;
        String input = null;
        HumanPlayer activePlayer = new HumanPlayer(name);
        boolean validName = false;
        boolean menu = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Group 8 BlackJack");
        System.out.println("Authors: Graham, Neo, Juan");
        System.out.println(""); // Line break

        // Player selection: new player, resume, or quit
        System.out.println("Select an Option - New Player or Resume as returning player: ");
        System.out.println("Please type: NEW, RESUME, or QUIT");
        System.out.print(":");

        input = scanner.nextLine();
        input = input.trim().toLowerCase();

        switch (input) {
            case "new": // If new, enter name
                while (!validName) {
                    System.out.println("Please enter a new Name:");
                    System.out.print(":");
                    name = scanner.nextLine();
                    name = name.trim().toLowerCase();
                    validName = true;
                    activePlayer.setName(name);
                    activePlayer.setScore(0);  // Starting score for a new player
                }
                break;
            case "resume": // If resume, choose from existing players (simplified for now)
                System.out.println("Please enter your name to resume:");
                System.out.print(":");
                name = scanner.nextLine();
                name = name.trim().toLowerCase();
                activePlayer.setName(name); // Resume with the player's name
                // Add logic to retrieve score if needed
                break;
            case "quit": // If quit, exit the program
                menu = false;
                break;
            default:
                System.out.println("Invalid input. Please enter NEW, RESUME, or QUIT.");
        }

        // Main menu loop
        while (menu) {
            System.out.println("Select an Option - Play, view wins, or quit: ");
            System.out.println("Please type: PLAY, VIEW, or QUIT");
            System.out.print(":");
            input = scanner.nextLine();
            input = input.trim().toLowerCase();

            switch (input) {
                case "play":
                    // **Fix #1: Create the dealer object here**
                    Dealer dealer = new Dealer(); // Define the dealer object

                    // **Fix #2: Start the game**
                    Game game = new Game(activePlayer, dealer);
                    game.startGame();

                    String playAgain = "yes"; // Start the game loop
                    while (playAgain.equals("yes")) {
                        game.playRound();

                        // Decision to play again or quit
                        System.out.println("Play Again? Please Enter YES or NO:");
                        System.out.print(":");
                        playAgain = scanner.nextLine().trim().toLowerCase();

                        switch (playAgain) {
                            case "yes":
                                break;
                            case "no":
                                playAgain = "no";
                                break;
                            default:
                                System.out.println("Please enter a valid input");
                        }
                    }
                    break;
                case "view":
                    // View wins
                    System.out.println(activePlayer.getName() + " Has won " + activePlayer.getScore() + " hands!");
                    break;
                case "quit":
                    menu = false;
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }
        }

        scanner.close(); // Close the scanner
    }
}

