package card;

public class AceCard extends Card {

    //Value must be 1 or 11
    public AceCard(int value) {
        super(value == 1 || value == 11 ? value : 1);
    }
    
}
