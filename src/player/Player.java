package player;

import java.util.ArrayList;
import java.util.Collections;

import card.AceCard;
import card.Card;

public class Player {
    private String name;
    private Hand currentHand = new Hand();
    private int currentHandPosition = 0;
    private ArrayList<Hand> hands = new ArrayList<>();
    private ArrayList<AceCard> aces = new ArrayList<>();
    
    public Player(String name) {
        this.name = name;
        hands.add(currentHandPosition, currentHand);
    }
    
    /**
     * Adds a card to the players hand
     * @param card the card to be added
     */
    public void acceptCard(Card card){
        currentHand.addCard(card);
    }

    /**
     * Adds a new hand to the players deck
     */
    public void addHand(){
        hands.add(new Hand());
    }

    public void resolveHand(){
        //Check if we have no more hands
        if (!hasHands()) return;
        //Get the next hand in the list
        currentHandPosition ++;
        currentHand = hands.get(currentHandPosition);
    }

    /**
     * Splits the players hand and adds the two new cards
     */
    public void splitHand(Card[] cards) {
        //Create two a new hands
        Hand newHand1 = new Hand();
        Hand newHand2 = new Hand();
        //Add the last card of our current hand and one of the new cards to it
        newHand1.addCard(currentHand.getCards().get(0));
        newHand1.addCard(cards[0]);
        //Add the last card of our current hand and one of the new cards to it
        newHand2.addCard(currentHand.getCards().get(1));
        newHand2.addCard(cards[1]);
        //Set these to be our new hands
        hands.set(0, newHand1);
        hands.add(newHand2);
        //Set the current hand
        currentHand = newHand1;
    }

    public boolean hasHands(){
        return (hands()-1) != currentHandPosition;
    }

    /**
     * Checks whether a player has gone bust
     * @return sum is greater than 21
     */
    public boolean isBust(){
        return currentHand.isBust();
    }

    /*
     * Forces player to revaluate their sum if their values have changed
     */
    public void evaluateSum(){
        for (Hand h: hands){
            h.evaluateSum();
        }
    }
    
    public int getScore() {
        return Collections.max(hands, (h1, h2) -> h1.getScore() - h2.getScore()).getScore();
    }

    public int getSum() {
        return currentHand.getSum();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Card> getHands(){
        return currentHand.getCards();
    }

    public int hands(){
        return hands.size();
    }

    public ArrayList<AceCard> getAces(){
        return currentHand.getAces();
    }

    public boolean hasAces(){
        return currentHand.hasAces();
    }

    /**
     * Displays the player's hand to the terminal with cards
     * appearing in a row
     */
    public void displayHands(){
        if (hands() == 1){
            currentHand.displayHand();
            System.out.println("Sum = " + currentHand.getSum());
        }
        else{
            for (int i = 0; i < hands(); i ++){
                System.out.println("Hand " + (i+1));
                hands.get(i).displayHand();
                System.out.println("Sum = " + hands.get(i).getSum());

            }
        }
    }

    /**
     * Returns true if the player has a pair of cards
     * @return true if there is a pair, false if not
     */
    public boolean hasPair(){
        return currentHand.hasPair();
    }

    public void nextHand() {
        if (!hasHands()) return;
        //Get the next hand in the list
        currentHandPosition ++;
        currentHand = hands.get(currentHandPosition);
    }

}