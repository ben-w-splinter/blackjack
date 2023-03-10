package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import player.Player;
import card.*;
import main.Game;

public class AceTest {
    private final Player player = new Player("Alice");
    private final Game game = new Game();

    @Before
    public void setUp(){
        game.setPlayer(player);
    }
    

    @Test
    public void kingAndAceThen21(){
        game.dealInitialHand(new Card[]{
            new PictureCard('K'),
            new AceCard(11)
        });
        int playerSum = player.getSum();
        assertEquals(21, playerSum);
    }

    @Test
    public void kingQueenAndAceThen21(){
        game.dealInitialHand(new Card[]{
            new PictureCard('K'),
            new PictureCard('Q'),
            new AceCard(1)
        });
        int playerSum = player.getSum();
        assertEquals(21, playerSum);
    }

    @Test
    public void givenNineAceAndAceThen21(){
        game.dealInitialHand(new Card[]{
            new NumberCard(9),
            new AceCard(11),
            new AceCard(1),
        });
        int playerSum = player.getSum();
        assertEquals(21, playerSum);
    }
}
