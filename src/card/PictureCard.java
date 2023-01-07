package card;

/**
 * Represents a Picture card in BlackJack
 */
public class PictureCard extends Card {
    private char title;

    /**
     * Initializes a new picture card with a given title
     * @param title a character to represent the card's title
     * (i.e. 'J','K','Q')
     */
    public PictureCard(char title) {
        super(10);
        this.title = title;
    }

    @Override
    public String toString() {
        return "-------------\n" +
               "|           |\n" +
               "|           |\n" +
               "|           |\n" +
               "|     " + title + "     |\n" +
               "|           |\n" +
               "|           |\n" +
               "|           |\n" +
               "-------------\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + title;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PictureCard other = (PictureCard) obj;
        if (title != other.title)
            return false;
        return true;
    }
}
