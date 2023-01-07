package card;

/**
 * Represents a numeric card in BlackJack
 */
public class NumberCard extends Card {
    /**
     * Initializes the number card with a given value
     * @param value a value for the card between 2 and 10
     */
    public NumberCard(int value) {
        //If the value is less than 2, set it to 2
        super(value < 2 ? 2 : value);
    }
    
}
