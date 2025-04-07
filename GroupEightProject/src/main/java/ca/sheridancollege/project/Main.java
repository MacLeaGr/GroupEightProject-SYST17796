package ca.sheridancollege.project;

import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    
    public static void main(String[] args) { // run game from here
        String jsonNames = null;
        String name = null;
        String input = null;
        HumanPlayer activePlayer = new HumanPlayer(name);
        boolean validName = false;
        boolean menu = true;
        
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("Scores.json")) {
            if (is == null) {
                System.out.println("Warning: Could not read Scores.json file.");
                jsonNames = "[]"; // fallback to empty array to remove error
            } else {
                jsonNames = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            System.out.println("Error reading Scores.json: " + e.getMessage());
            jsonNames = "[]"; // fallback again to remove error
        }
        JSONArray names = new JSONArray(jsonNames);
        
        Scanner scanner = new Scanner(System.in); // scanner for user input
        
        System.out.println("Group 8 BlackJack");
        System.out.println("Authors: Graham, Neo, Juan");
        
        // player select, add new player or resume playing as a registered player, or quit
        System.out.println("Select an Option - New Player or Resume as returning player: ");
        System.out.println("Returning Players: " + names);
        System.out.println("Please type: NEW,  RESUME, or QUIT");
        System.out.print(":"); // "Type here" indicator
        
        input = scanner.nextLine();
        input = input.trim().toLowerCase();
        
        switch (input) {
            case "new" -> { // if new, enter name, name is added to JSON with number of wins 0
                while (!validName) {
                    int count = 0;
                    System.out.println("Please enter a new Name:");
                    System.out.print(":"); // "Type here" indicator
                    name = scanner.nextLine();
                    name = name.trim().toLowerCase();
                    
                    for (int i = 0; i < names.length(); i++) {
                        JSONObject player = names.getJSONObject(i);
                        if (player.getString("name").equals(name)) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        validName = true;
                        activePlayer.setName(name);
                        activePlayer.setScore(0);
                    } else {
                        System.out.println("Name already exists, please enter a different name.");
                        System.out.print(":"); // "Type here" indicator
                    }
                }
                break;
            }
            case "resume" -> { // if resume, select name from list, set player's wins to number connected to name in JSON
                while (!validName) {
                    System.out.println("Please enter an existing Name:");
                    System.out.print(":"); // "Type here" indicator
                    name = scanner.nextLine();
                    name = name.trim().toLowerCase();
                    
                    for (int i = 0; i < names.length(); i++) {
                        JSONObject player = names.getJSONObject(i);
                        if (player.getString("name").equals(name)) {
                            validName = true;
                            activePlayer.setName(name);
                            activePlayer.setScore(player.getInt("score"));
                        }
                    }
                }
                break;
            }
            case "quit" -> { // if quit, end program
                menu = false;
                break;
            }
            default -> System.out.println("Please enter a valid input");
        }

        // Dealer rule selection
        Dealer dealer = new Dealer();
        System.out.println("Select the dealer's rules:");
        System.out.println("1 - Nuclear Rules (Dealer hits on soft 17)");
        System.out.println("2 - Dynamite Rules (Dealer hits on 15, stands on 16)");
        System.out.println("3 - Hologram Rules (Dealer draws on 16, stands on 17)");
        System.out.print("Please enter 1, 2, or 3: ");
        int ruleChoice = scanner.nextInt(); // Read the rule choice
        scanner.nextLine(); // Consume the newline character left by nextInt()

        dealer.setHouseRules(ruleChoice); // Apply the selected rules

        // start game decision -- play, view wins, quit
        while (menu) {
            System.out.println("Select an Option - Play, view wins, or quit: ");
            System.out.println("Please type: PLAY, VIEW, or QUIT");
            input = scanner.nextLine();
            input = input.trim().toLowerCase();
        
            switch (input) {
                case "play" -> {
                    boolean playGame = true;
                    // play
                    // import player name and wins, new dealer, new deck, new rounds, start round
                    // round plays out
                    // round added to rounds
                    // ask player play another round -- play again or quit
                    while (playGame) {
                        boolean playAgain = true;
                        Game game = new Game(activePlayer, dealer);
                        game.startGame();
                        
                        while (playAgain) { // game process within this while loop
                            game.playRound();
                            
                            System.out.println("Play Again? Please Enter YES or NO:"); // after round ends, loop to play again, break loop to return to menu
                            input = scanner.nextLine();
                            input = input.trim().toLowerCase();
                            switch (input) {
                                case "yes":
                                    break;
                                case "no":
                                    playAgain = false; // End the round and stop the play game loop
                                    break;
                                default:
                                    System.out.println("Please enter a valid input");
                            }
                        }
                        if (!playAgain) { // Exit the loop after the game ends when "NO" is pressed
                            playGame = false;
                        }
                    }
                    break;
                }
                case "view" -> {    // view wins
                    // display win count for selected player
                    System.out.println(activePlayer.getName() + " Has won " + activePlayer.getScore() + " hands!");
                    break;
                }
                case "quit" -> { // quit
                    // update list with name and win count, sort list by win count
                    // end program
                    menu = false;
                    break;
                }
                default -> System.out.println("Please enter a valid input");
            }
        }
        scanner.close();    
    }
}
