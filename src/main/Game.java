package main;

import java.util.ArrayList;
import java.util.Collections;

import card.Card;
import card.Deck;
import player.Player;


public class Game {
    private final Deck deck = new Deck();
    private final ArrayList<Player> players = new ArrayList<>();
    private Player player;

    public Game(){
        deck.populateDeck();
    }

    /**
     * Deals two cards to the current player
     */
    public void dealInitialHand(){
        //Give player two cards
        for (int i = 0; i < 2; i++){
            Card c = deck.dealCard();
            player.acceptCard(c);
        }
    }

    /**
     * Test Method - allows players to be given specific cards
     */
    public void dealInitialHand(Card[] cards){
        for (Card card : cards) {
            player.acceptCard(card);
        }
    }

    /**
     * Gives another card to the current player
     */
    public void playerHit(){
        //Give player another card
        Card c = deck.dealCard();
        player.acceptCard(c);
    }

    /**
     * Resolves the current players hand
     */
    public void playerStand(){
        player.resolveHand();
    }

    /**
     * Adds an additional hand to the player's
     * deck
     */
    public void playerSplit() {
        //Split the players hand, adding
        //two more cards
        player.splitHand(new Card[]{
            deck.dealCard(),
            deck.dealCard()
        });
    }

    /**
     * Adds the current player to the list of players
     */
    public void completeRound(){
        players.add(player);
    }

    /**
     * Sets the current player
     * @param p the player to be set
     */
    public void setPlayer(Player p){
        this.player = p;
    }

    /**
     * Calculates the player with the highest score 
     * @return the name(s) of the players(s) with the highest score
     */
    public String[] getWinners(){
        // Find the highest score
        int highScore = Collections.max(players, (p1, p2) -> p1.getScore() - p2.getScore()).getScore();

        // Find the players with the highest score
        ArrayList<String> winners = new ArrayList<>();
        for (Player player : players) {
            if (player.getScore() == highScore) {
                winners.add(player.getName());
            }
        }
        return (String[]) winners.toArray(new String[winners.size()]);
    }

}
