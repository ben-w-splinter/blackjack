package main;
import java.util.Scanner;

import card.AceCard;
import player.Player;

/**
 * Class to run a player based simulation of the blackjack game
 */
public class Main {
    /**
     * Runs a player based simulation of the blackjack game
     * @param args no arguments used
     */
    public static void main(String[] args) {
        //Create a scanner to read user input
        final Scanner scanner = new Scanner(System.in);
        //Create a game to manage game logic and keep track of players
        final Game game = new Game();
        //Print welcome message
        System.out.println("Welcome to Blackjack!"); 

        //Ask the user for number of players
        int numberOfPlayers = getIntValue(scanner, "Enter the number of players");

        //For each player
        for (int i = 0; i < numberOfPlayers; i++) {
            //Ask for name
            System.out.println("Player " + (i+1) + " please enter your name: ");
            String name = scanner.next();
            //Create new player
            final Player player = new Player(name);
            //Set the current player
            game.setPlayer(player);
            //Deal initial hand and display it
            System.out.println("Let's deal the initial hand");
            game.dealInitialHand();
            player.displayHands();
            //Continue until player busts or stands
            while (true){
                //If the player has aces, set their values                
                if (player.hasAces()){
                    int j = 1;
                    for (AceCard card: player.getAces()){
                        //Continually ask user for input until a valid ace value is provided
                        int aceValue;
                        while (true){
                            aceValue = getIntValue(scanner, "Please enter the value for the ace " + j + " (1 or 11)");
                            if (aceValue == 1 || aceValue == 11) break;
                        }
                        card.setValue(aceValue);
                        j++;
                    }
                    //Re-evaluate the sum and display it
                    player.evaluateSum();
                    System.out.println("Sum = " + player.getSum());
                }
                //If they player has a pair, could split
                if (player.getCards().size() == 2 && player.hasPair()){
                    System.out.println("Looks like you have a pair. Would you like to split [y/n]");
                    String choice = scanner.next();
                    if (choice.equals("y")){
                        //Split the players hand and display it
                        game.playerSplit();
                        player.displayHands();
                        continue;
                    }
                }
                //Check if the player is bust
                if (player.isBust()){
                    System.out.println("Uh oh.... Looks like you are bust!");
                    //If the player still has hands to play we can continue 
                    if (player.hasHands()){
                        player.resolveHand();
                    }
                    //Otherwise end the round
                    else{
                        game.completeRound();
                        break;
                    }
                }
                //Ask the player if they would like to hit or stand
                System.out.println("Would you like to 'hit' or 'stand'" + (player.hands() == 1 ? "" : " on Hand " + (player.getCurrentHandPosition() + 1)));
                String choice = scanner.next();                

                //If they choose hit, deal another card and continue
                if (choice.equals("hit")){
                    game.playerHit();
                    player.displayHands();   
                }
                //Otherwise move to next hand or end round
                else if (choice.equals("stand")){
                    if (player.hasHands()){
                        player.resolveHand();
                    }
                    else{
                        game.completeRound();
                        break;
                    };
                }
            }
        }
        //When round is finished, ensure to close the scanner, prevent memory leak
        scanner.close();
        //Fetch the list of winners
        String[] winners = game.getWinners();

        //Output the winners
        if (winners.length == 1){
            System.out.println("The winner is " + winners[0]);
        }
        else{
            System.out.println("It's a draw! The winners are:");
            for (String winner : winners){
                System.out.println(winner);
            }
        }
    }


    /**
     * Continually asks user for integer until a valid integer is inputted
     * @param scanner an open scanner to read the int
     * @param prompt a prompt to ask the user
     * @return a valid integer inputted by the user
     */
    public static int getIntValue(Scanner scanner, String prompt){
        System.out.println(prompt); 
        int number;
        //Continue to ask for number of players until a valid number is inputted
        while (true){    
            try{
                number = Integer.parseInt(scanner.next());
                break;
            } catch(NumberFormatException e){
                System.out.println("Please enter a valid number");
                continue;
            }
        }
        return number;
    }
}
