package main;
public class NumberCard extends Card {
    public NumberCard(int value) {
        //If the value is less than 2, set it to 2
        super(value < 2 ? 2 : value);
    }
    
}
