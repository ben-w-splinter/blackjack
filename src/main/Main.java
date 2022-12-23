package main;

import java.util.Scanner;
import player.Player;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        final Player player = new Player(name);
        final Game game = new Game(player);
        System.out.println("Let's deal the initial hand");
        game.dealInitialHand();
        player.displayHand();
        System.out.println("Sum = " + player.getSum());
        while (true){
            System.out.println("Would you like to 'hit' or 'stand'");
            String choice = scanner.nextLine();
            System.out.println("You chose " + choice);
            if (choice.equals("hit")){
                game.playerHit();
                player.displayHand();
                System.out.println("Sum = " + player.getSum());
            }
            else if (choice.equals("stand")){
                game.playerStand();
            }
            if (player.isBust()){
                System.out.println("Uh oh.... Looks like you are bust!");
                break;
            }
        }
        scanner.close();
    }
}
