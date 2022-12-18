public class Player {
    private int score = 0;
    private int sum = 0;
    private String name;
    
    public Player(String name) {
        this.name = name;
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
}
