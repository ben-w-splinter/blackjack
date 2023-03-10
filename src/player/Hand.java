package player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import card.AceCard;
import card.Card;

/**
 * Class to represent a hand of Cards in BlackJack
 */
public class Hand {
    private int sum = 0;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<AceCard> aces = new ArrayList<>();
    
    /**
     * Adds a card to the hands hand
     * @param card the card to be added
     */
    public void addCard(Card card){
        cards.add(card);
        if (card instanceof AceCard) aces.add((AceCard) card);
        sum += card.getValue();
    }

    /**
     * Checks whether a hand has gone bust
     * @return sum is greater than 21
     */
    public boolean isBust(){
        return sum > 21;
    }

    /*
     * Forces hand to revaluate their sum if their values have changed
     */
    public void evaluateSum(){
        sum = 0;
        for (Card card: cards){
            sum += card.getValue();
        }
    }
    
    /**
     * Gets the score of the hand
     * @return the sum of the hand or 0 if the hand is bust
     */
    public int getScore() {
        return isBust() ? 0 : sum;
    }

    /**
     * @return sum of the value's of the cards in the hand
     */
    public int getSum() {
        return sum;
    }

    /**
     * @return all cards in the hand
     */
    public ArrayList<Card> getCards(){
        return cards;
    }

    /**
     * @return All aces in the hand
     */
    public ArrayList<AceCard> getAces(){
        return aces;
    }

    /**
     * @return true if the hand contains aces, false if not
     */
    public boolean hasAces(){
        return aces.size() > 0;
    }

    /**
     * Displays the hand to the terminal with cards
     * appearing in a row
     */
    public void displayHand(){
        String[][] cardStrings = new String[cards.size()][];
        for (int i = 0; i < cards.size(); i++) {
            cardStrings[i] = cards.get(i).toString().split("\\r?\\n");
        }
        int cardHeight = cardStrings[0].length;
        //For each row
        for (int i = 0; i < cardHeight; i++) {
            //For each card, print this row
            for (String[] card: cardStrings){
                System.out.print(card[i] + "   ");
            }
            System.out.println();
        }
    }

    /**
     * Returns true if the hand has a pair of cards
     * @return true if there is a pair, false if not
     */
    public boolean hasPair(){
        Set<Card> seenCards = new HashSet<Card>();
        for (Card c: cards){
            if (seenCards.contains(c)){
                return true;
            }
            seenCards.add(c);
        }
        return false;
    }
}
