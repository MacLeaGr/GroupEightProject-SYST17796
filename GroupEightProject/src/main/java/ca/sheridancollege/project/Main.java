package ca.sheridancollege.project;

import java.util.Scanner;
import ca.sheridancollege.project.Game;
import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main{
    
    public static void main(String[] args) // run game from here
    {
        String jsonNames = null;
        String name = null;
        String input = null;
        HumanPlayer activePlayer = new HumanPlayer(name);
        boolean validName = false;
        
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("Scores.json")) {
            if (is == null) {
                System.out.println("Warning: Could not read Scores.json file.");
                jsonNames = "[]"; // fallback to empty array
            } else {
                jsonNames = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            System.out.println("Error reading Scores.json: " + e.getMessage());
            jsonNames = "[]"; // fallback again
        }
        JSONArray names = new JSONArray(jsonNames);
        
        Scanner scanner = new Scanner(System.in); // scannner for user input
        
        
        System.out.println("Group 8 BlackJack");
        System.out.println("Authors: Graham, Neo, Juan");
        
        // player select, add new player or resume playing as a registered player, or quit
        System.out.println("Select an Option - New Player or Resume as returning player: ");
        System.out.println("Returning Players: " + names);
        System.out.println("Please type: NEW,  RESUME, or QUIT");
        
        input = scanner.nextLine();
        input = input.trim().toLowerCase();
        
        switch(input)
        {
            case "new": // if new, enter name, name is added to JSON with number of wins 0
                while(validName == false)
                {
                    int count = 0;
                    System.out.println("Please enter a new Name:");
                    name = scanner.nextLine();
                    name = name.trim().toLowerCase();
                    
                    for (int i = 0 ; i < names.length() ; i++ )
                    {
                        JSONObject player = names.getJSONObject(i);
                        if (player.getString("name").equals(name))
                        {
                            count++;
                        }
                    }
                    if (count == 0)
                    {
                        validName = true;
                        activePlayer.setName(name);
                        activePlayer.setScore(0);
                    }
                    else
                    {
                        System.out.println("Name already exists, please enter a different name.");
                    }
                }
                
                    break;
            case "resume": // if resume, select name from list, set player's wins to number connected to name in JSON
                while(validName == false)
                {
                    int count = 0;
                    System.out.println("Please enter a new Name:");
                    name = scanner.nextLine();
                    name = name.trim().toLowerCase();
                    
                    for (int i = 0 ; i < names.length() ; i++ )
                    {
                        JSONObject player = names.getJSONObject(i);
                        if (player.getString("name").equals(name))
                        {
                            validName = true;
                            activePlayer.setName(name);
                            activePlayer.setScore(player.getInt("score"));
                            
                        }
                    }
                }
                
                    break;
            case "quit": // if quit, end program
                    break;
            default:
                System.out.println("Please enter a valid input");
        }
        
        // start game decision -- play, view wins, quit
        boolean menu = true;
        while(menu == true)
        {
            System.out.println("Select an Option - Play, view wins, or quit: ");
            System.out.println("Please type: PLAY, VIEW, or QUIT");
        
            input = scanner.nextLine();
            input = input.trim().toLowerCase();
        
            switch(input)
            {
                case "play":
                    boolean playGame = true;
                    // play
                    // import player name and wins, new dealer, new deck, new rounds, start round
                    // round plays out
                    // round added to rounds
                    // ask player play another round -- play again or quit
                    while(playGame == true)
                    {
                        String playAgain = "yes";
                        Game game = new Game(activePlayer);
                        game.startGame();
                    
                    
                        while(playAgain=="yes")
                        {
                            game.playRound();
                            System.out.println("Play Again? Please Enter YES or NO:");
                            input = scanner.nextLine();
                            input = input.trim().toLowerCase();
                            switch(input)
                            {
                                case "yes":
                                    break;
                                case "no":
                                    playAgain = "no";
                                    break;
                                default:
                                    System.out.println("Please enter a valid input");
                            }
                        }
                    }
                    break;
                case "view":
                    // view wins
                    // display win count for selected player
                    System.out.println(activePlayer.getName() + "Has won " + activePlayer.getScore() + "hands!");
                    break;
                case "quit":
                    // quit
                    // update list with name and win count, sort list by win count
                    // end program
                    menu = false;
                    
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }
        }
     scanner.close();    
    }
}
