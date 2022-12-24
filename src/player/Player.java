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
        score = sum;
        if (isBust()) score = 0;
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
}
