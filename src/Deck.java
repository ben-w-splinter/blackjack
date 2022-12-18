import java.util.ArrayList;
import java.util.Collection;

/*
 * Represents a deck of cards in blackjack
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * Initializes a deck with an existing set of cards
     * @param cards collection of cards
     */
    public Deck(Collection<Card> cards) {
        this.cards.addAll(cards);
    }

    /**
     * Initializes an empty deck
     */
    public Deck(){}
    
}
