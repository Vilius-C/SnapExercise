package io.github.viliuschockevicius.snapExercise;

/**
 * The class of a card, which represents a standard playing card, which makes up a deck of 52 of these cards. It has it's suit and number
 * @author Vilius Chockevicius
 */
public class Card {
    
        private CardSuit cardSuit;
	private CardNumber cardNumber;
	
	/**
	 * Card constructor, taking a suit and the number as values
	 * @param cardSuit - The card's suit
	 * @param cardNumber - The card's number
	 */
	public Card(CardSuit cardSuit, CardNumber cardNumber) {
		this.cardSuit = cardSuit;
		this.cardNumber = cardNumber;
	}

	/**
	 * Getter for the card's suit
	 * @return The suit of the card
	 */
	public CardSuit getCardSuit() {
		return cardSuit;
	}

	/**
	 * Getter for the card's number
	 * @return The number of the card
	 */
	public CardNumber getCardNumber() {
		return cardNumber;
	}

	@Override
	public String toString() {
		return cardNumber + " of " + cardSuit;
	}
    
}
