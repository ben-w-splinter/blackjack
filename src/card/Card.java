package card;
/**
 * Represents a card in blackjack. Can have any value between 1 and 10
 */
public class Card {
    protected int value;

    /**
     * Creates a new card
     * @param value a value the card represents, must be between 1 and 10. Value is rounded if not
     */
    public Card(int value){
        if (value < 1) this.value = 1;
        else if (value > 10) this.value = 10;
        else this.value = value;
    }

    /**
     * Gets the value of the card
     * @return the value of the card
     */
    public int getValue(){
        return value;
    }
}