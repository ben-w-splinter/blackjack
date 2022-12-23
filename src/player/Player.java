package player;

import java.util.ArrayList;

import card.Card;

public class Player {
    private int score = 0;
    private int sum = 0;
    private String name;
    private ArrayList<Card> hand = new ArrayList<>();
    
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * Adds a card to the players hand
     * @param card the card to be added
     */
    public void acceptCard(Card card){
        hand.add(card);
        sum += card.getValue();
    }

    /**
     * Checks whether a player has gone bust
     * @return sum is greater than 21
     */
    public boolean isBust(){
        return sum > 21;
    }
    
    public int getScore() {
        return score;
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

    public void displayHand(){
        for (Card card : hand) {
            System.out.println(card.toString());
        }
    }
}
