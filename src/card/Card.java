package card;
/**
 * Represents a card in blackjack. Can have any value between 1 and 11
 */
public class Card {
    protected int value;

    /**
     * Creates a new card
     * @param value a value the card represents, must be between 1 and 10. Value is rounded if not
     */
    public Card(int value){
        if (value < 1) this.value = 1;
        else if (value > 11) this.value = 11;
        else this.value = value;
    }

    /**
     * Gets the value of the card
     * @return the value of the card
     */
    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        String middleLine = value < 10 ? "|     " + String.valueOf(value) + "     |\n" : 
                                         "|    " + String.valueOf(value) + "     |\n";
        return "-------------\n" +
               "|           |\n" +
               "|           |\n" +
               "|           |\n" +
                middleLine       +
               "|           |\n" +
               "|           |\n" +
               "|           |\n" +
               "-------------\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (value != other.value)
            return false;
        return true;
    }
}
