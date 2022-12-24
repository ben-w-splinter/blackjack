package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import player.Player;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Game game = new Game(null);
        System.out.println("Welcome to Blackjack!");
        System.out.println("Enter the number of players: ");
        int numberOfPlayers = scanner.nextInt();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + (i+1) + " please enter your name: ");
            String name = scanner.next();
            final Player player = new Player(name);
            players.add(player);
            game.setPlayer(player);
            System.out.println("Let's deal the initial hand");
            game.dealInitialHand();
            player.displayHand();
            System.out.println("Sum = " + player.getSum());
            while (true){
                System.out.println("Would you like to 'hit' or 'stand'");
                String choice = scanner.next();
                if (choice.equals("hit")){
                    game.playerHit();
                    player.displayHand();
                    System.out.println("Sum = " + player.getSum());
                }
                else if (choice.equals("stand")){
                    game.playerStand();
                    break;
                }
                if (player.isBust()){
                    System.out.println("Uh oh.... Looks like you are bust!");
                    break;
                }
            }
        }
        scanner.close();

        // Find the highest score
        int highScore = Collections.max(players, (p1, p2) -> p1.getScore() - p2.getScore()).getScore();

        // Find the players with the highest score
        ArrayList<String> winners = new ArrayList<>();
        for (Player player : players) {
            if (player.getScore() == highScore) {
                winners.add(player.getName());
            }
        }

        //Output the winners
        if (winners.size() == 1){
            System.out.println("The winner is " + winners.get(0));
        }
        else{
            System.out.println("It's a draw! The winners are:");
            for (String winner : winners){
                System.out.println(winner);
            }
        }
    }
}
