package io.github.viliuschockevicius.snapExercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Game class that sets the game
 * @author Vilius Chockevicius
 */
public class Game 
{
    private Deck deck;	
    private String player1;
    private String player2;
	
    /**
     * Game constructor, using the names of the players as parameters
     * @param player1 - First player's name
     * @param player2 - Second player's name
     */
    public Game(String player1, String player2) 
    {
        this.player1 = player1;
        this.player2 = player2;
    }
	
    /**
     * Plays the game of Snap between two players controlled by the computer
     */
    public void play() 
    {
	deck = new Deck();
	deck.shuffle();
	int turn = 0;
	Random rand = new Random();
	CardNumber previousCardNumber = null;
	boolean time = false;
		
	// the turn loop, which ends when two cards with the same card number are turned
	while (!time) 
        {
            String currentPlayer = (turn % 2 == 0) ? player1 : player2;
			
            int timeout = 1000 + rand.nextInt(1000);
			
		try 
                {
			TimeUnit.MILLISECONDS.sleep((long) timeout);
		} 
                catch (InterruptedException e) 
                {
                        e.printStackTrace();
		}
			
		Card nextCard = deck.turnCard();
			
		// checks for a draw if no more cards remain
		if (nextCard == null) 
                {
                        System.out.println("There are no more cards remaining, game ends in a draw!");
			return;
		}
			
                System.out.println(currentPlayer + " turns card \'" + nextCard + "\'");
			
		turn++;
			
		// ends the loop for turning cards
		if (nextCard.getCardNumber() == previousCardNumber) 
                {
                    time = true;
		}
                
		previousCardNumber = nextCard.getCardNumber();
	}
		
	// Thinking time for saying SNAP!
	int snapTimeoutP1 = 500 + rand.nextInt(1000);
	int snapTimeoutP2 = 500 + rand.nextInt(1000);
		
	// In a rare occasion that both players say SNAP! at the same time
	if (snapTimeoutP1 == snapTimeoutP2) 
        {
            try 
            {
                TimeUnit.MILLISECONDS.sleep((long) snapTimeoutP1);	
            }
            catch (InterruptedException e) 
            {
                e.printStackTrace();
			
            }
			
            System.out.println("SNAP! Both players say it and it ends in a draw!");
	}
	// usually one of the players will say it first and end up a winner
	else 
        {
            String result = String.format("SNAP! %s wins!", (snapTimeoutP1 < snapTimeoutP2) ? player1 : player2);
			
            try 
            {
                TimeUnit.MILLISECONDS.sleep((long) Math.min(snapTimeoutP1, snapTimeoutP2));
			
            } 
            catch (InterruptedException e) 
            {
		e.printStackTrace();
			
            }
            System.out.println(result);
	}
    }
}
