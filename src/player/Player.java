package player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import card.AceCard;
import card.Card;

public class Player {
    private int sum = 0;
    private String name;
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<AceCard> aces = new ArrayList<>();
    
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * Adds a card to the players hand
     * @param card the card to be added
     */
    public void acceptCard(Card card){
        hand.add(card);
        if (card instanceof AceCard) aces.add((AceCard) card);
        sum += card.getValue();
    }

    /**
     * Checks whether a player has gone bust
     * @return sum is greater than 21
     */
    public boolean isBust(){
        return sum > 21;
    }

    /*
     * Forces player to revaluate their sum if their values have changed
     */
    public void evaluateSum(){
        sum = 0;
        for (Card card: hand){
            sum += card.getValue();
        }
    }
    
    public int getScore() {
        return isBust() ? 0 : sum;
    }

    public int getSum() {
        return sum;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public ArrayList<AceCard> getAces(){
        return aces;
    }

    public boolean hasAces(){
        return aces.size() > 0;
    }

    /**
     * Displays the player's hand to the terminal with cards
     * appearing in a row
     */
    public void displayHand(){
        String[][] cardStrings = new String[hand.size()][];
        for (int i = 0; i < hand.size(); i++) {
            cardStrings[i] = hand.get(i).toString().split("\\r?\\n");
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
     * Returns true if the player has a pair of cards
     * @return true if there is a pair, false if not
     */
    public boolean hasPair(){
        Set<Card> seenCards = new HashSet<Card>();
        for (Card c: hand){
            if (seenCards.contains(c)){
                return true;
            }
            seenCards.add(c);
        }
        return false;
    }
}
