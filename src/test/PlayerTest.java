package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import card.Deck;
import card.Card;
import player.Player;

public class PlayerTest {
    private final Deck deck = new Deck();
    private final Player player = new Player("Alice");
    
    @Test
    public void initialDealGivesTwoCards(){
        deck.populateDeck();
        for (int i = 0; i < 2; i++){
            Card c = deck.dealCard();
            player.acceptCard(c);
        }
        ArrayList<Card> cards = player.getHand();
        assertEquals(2, cards.size());
    }
}
