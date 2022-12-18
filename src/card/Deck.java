package card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/*
 * Represents a deck of cards in blackjack
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private Random random = new Random();


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

    /**
     * Populates the deck with a list of 52 cards according to the format of a standard deck
     */
    public void populateDeck(){
        //Add picture Cards
        for (int i = 0; i < 12; i++) {
            cards.add(new PictureCard());    
        }

        //Add aces
        for (int i = 0; i < 4; i++) {
            cards.add(new AceCard(1));
        }

        //Add number cards
        //For each suit
        for (int i = 0; i < 4; i++) {
            //For each number
            for (int j = 2; j < 11; j++) {
                cards.add(new Card(j));
            }
        }
    }
    
    public Card dealCard(){
        //Fetch a radom card
        int randomIndex = random.nextInt(cards.size());
        Card randomCard = cards.get(randomIndex);
        //Remove this card from the deck
        cards.remove(randomIndex);
        //Return the card
        return randomCard;
    }
    
    public ArrayList<Card> getCards() {
        return cards;
    }
    
}