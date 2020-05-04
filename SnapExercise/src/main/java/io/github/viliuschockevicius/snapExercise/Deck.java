package io.github.viliuschockevicius.snapExercise;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Deck class that sets the standard deck of 52 playing cards.
 * @author Vilius Chockevicius
 */
public class Deck {
    
    private List<Card> deck = new ArrayList<Card>();

	/**
	 * Deck constructor, which creates the deck consisting of 52 standard playing cards
	 */
	public Deck() {
		for (CardSuit cardSuit : CardSuit.values()) {
			for (CardNumber cardNumber: CardNumber.values()) {
				deck.add(new Card(cardSuit, cardNumber));
			}
		}
	}
	
	/**
	 * A method that turns the top card from the deck and then removes it,
	 * or returns null if the deck is empty
	 * @return a created Card if the deck is not empty, returns null if it 
	 */
	public Card turnCard() {
		if (!deck.isEmpty()) {
			return deck.remove(0);
		}
		else {
			return null;
		}
	}
	
	/**
	 * A method that shuffles the deck
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	 * Get method for the cards
	 * @return an ArrayList of Cards
	 */
	public List<Card> getCards() {
		return deck;
	}
}
