package card;

public class PictureCard extends Card {
    private char title;

    public PictureCard(char title) {
        super(10);
        this.title = title;
    }

    @Override
    public String toString() {
        return "-------------\n" +
               "|           |\n" +
               "|           |\n" +
               "|     " + title + "     |\n" +
               "|           |\n" +
               "|           |\n" +
               "-------------\n";
    }
}
