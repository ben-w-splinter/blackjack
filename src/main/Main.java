package main;
import java.util.Scanner;

import card.AceCard;
import card.Card;
import card.NumberCard;
import player.Player;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Game game = new Game();
        System.out.println("Welcome to Blackjack!"); 

        int numberOfPlayers = getIntValue(scanner, "Enter the number of players");

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + (i+1) + " please enter your name: ");
            String name = scanner.next();
            final Player player = new Player(name);
            game.setPlayer(player);
            System.out.println("Let's deal the initial hand");
            game.dealInitialHand();
            player.displayHands();
            while (true){                
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
                    player.evaluateSum();
                    System.out.println("Sum = " + player.getSum());
                }
                if (player.getHands().size() == 2 && player.hasPair()){
                    System.out.println("Looks like you have a pair. Would you like to split [y/n]");
                    String choice = scanner.next();
                    if (choice.equals("y")){
                        game.playerSplit();
                        player.displayHands();
                        continue;
                    }
                }
                if (player.isBust()){
                    System.out.println("Uh oh.... Looks like you are bust!");
                    if (player.hasHands()){
                        player.nextHand();
                    }
                    else{
                        game.completeRound();
                        break;
                    }
                }
                System.out.println("Would you like to 'hit' or 'stand'" + (player.hands() == 1 ? "" : " on Hand " + (player.getCurrentHandPosition() + 1)));
                String choice = scanner.next();                

                if (choice.equals("hit")){
                    game.playerHit();
                    player.displayHands();   
                }
                else if (choice.equals("stand")){
                    if (player.hasHands()){
                        player.nextHand();
                    }
                    else{
                        game.completeRound();
                        break;
                    };
                }
            }
        }
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
