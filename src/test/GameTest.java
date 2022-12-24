package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Game;
import player.Player;

public class GameTest {
    private final Game game = new Game();
    private final Player alice = new Player("Alice");
    private final Player bob = new Player("Bob");

    @Test
    public void playerWithGreatestScoreShouldBeWinner(){
        game.setPlayer(alice);
        game.dealInitialHand();
        //Ensure alice goes bust
        while (alice.getSum() < 22){
            game.playerHit();
        }
        game.completeRound();
        game.setPlayer(bob);
        game.dealInitialHand();
        game.playerStand();
        game.completeRound();
        //Now bob should be winner
        String[] winners = game.getWinners();
        //There should only be 1 winner
        assertEquals(1, winners.length);
        //Bob should be the winner
        assertEquals("Bob", winners[0]);
        
    }

    @Test
    public void playersWithSameGreatestScoreShouldDraw(){
        game.setPlayer(alice);
        game.dealInitialHand();
        //Ensure alice goes bust
        while (alice.getSum() < 22){
            game.playerHit();
        }
        game.completeRound();
        game.setPlayer(bob);
        game.dealInitialHand();
        //Ensure bob goes bust
        while (bob.getSum() < 22){
            game.playerHit();
        }
        game.completeRound();
        //Now both should be winners
        String[] winners = game.getWinners();
        //There should only be 2 winners
        assertEquals(2, winners.length);
    }

}
