package card;

public class PictureCard extends Card {
    public PictureCard() {
        super(10);
    }

    @Override
    public String toString() {
        return "-------------\n" +
               "|           |\n" +
               "|           |\n" +
               "|     J     |\n" +
               "|           |\n" +
               "|           |\n" +
               "-------------\n";
    }
}
