package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;


import org.junit.Test;

import main.Game;
import card.AceCard;
import card.Card;
import card.PictureCard;
import player.Player;

public class PlayerTest {
    private final Player player = new Player("Alice");
    private final Game game = new Game(player);
    
    @Test
    public void initialDealGivesTwoCards(){
        game.dealInitialHand();
        //Fetch their hand
        ArrayList<Card> cards = player.getHand();
        //Should have two cards
        assertEquals(2, cards.size());
    }

    @Test
    public void whenHitThenReceiveCard(){
        game.dealInitialHand();
        int beforeLength = player.getHand().size();
        //Player chooses hit
        game.playerHit();
        int afterLength = player.getHand().size();
        //Player should have received one card
        assertEquals(beforeLength + 1, afterLength);
    }

    @Test
    public void whenHitThenUpdateSum(){
        game.dealInitialHand();
        int beforeSum = player.getSum();
        //Player chooses hit
        game.playerHit();
        //New sum should be greater than old sum
        int afterSum = player.getSum();
        assertTrue(afterSum > beforeSum);

    }

    @Test
    public void whenStandThenDontReceiveCard(){
        game.dealInitialHand();
        int beforeSum = player.getSum();
        // Player chooses to 'stand'
        game.playerStand();
        int afterSum = player.getSum();
        assertEquals(beforeSum, afterSum);
    }

    @Test
    public void validHandBelow21(){
        game.dealInitialHand();
        int playerSum = player.getSum();
        if (playerSum <= 21) assertFalse(player.isBust());
        else assertTrue(player.isBust());
    }

    @Test
    public void bustHandAbove21(){
        game.dealInitialHand();
        int playerSum = player.getSum();
        //Keep looping until we have an invalid hand
        while (playerSum <= 21){
            game.playerHit();
            playerSum = player.getSum();
        }
        assertTrue(player.isBust());
    }

    @Test
    public void kingAndAceThen21(){
        game.dealInitialHand(new Card[]{
            new PictureCard(),
            new AceCard(11)
        });
        int playerSum = player.getSum();
        assertEquals(21, playerSum);
    }

    @Test
    public void kingQueenAndAceThen21(){
        game.dealInitialHand(new Card[]{
            new PictureCard(),
            new PictureCard(),
            new AceCard(1)
        });
        int playerSum = player.getSum();
        assertEquals(21, playerSum);
    }
}
