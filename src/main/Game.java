package main;

import card.Card;
import card.Deck;
import player.Player;


public class Game {
    private final Deck deck = new Deck();
    private Player player;

    public Game(Player p){
        this.player = p;
        deck.populateDeck();
    }

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

    public void playerHit(){
        //Give player another card
        Card c = deck.dealCard();
        player.acceptCard(c);
    }

    public void playerStand(){}
}
