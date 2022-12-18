package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import main.Deck;

public class DeckTest {

    private final Deck deck = new Deck();

    @Test
    public void fiftyTwoCardsInDeck(){
        deck.populateDeck();
        assertEquals(52, deck.getCards().size());
    }
}
