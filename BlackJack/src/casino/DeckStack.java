package casino;

/**
 * A stack of more than one deck used in a casino game
 *
 */
public class DeckStack {
	// Create an array of decks
	private Deck[] decks;

	// Constructor for the deckstack
	public DeckStack(int numDecks) {
		// Allocate space for the decks
		decks = new Deck[numDecks];
		// Loop through the array and populate it with deck classes
		for (int i = 0; i < numDecks; i++) {
			decks[i] = new Deck();
		}

	}
	
	// Random picks with deck to deal from and then deals the top card of that deck
	public Card dealTopCard() {
		int deck = (int) (Math.random() * (decks.length));
		return decks[deck].dealTopCard();
	}
	
	// Loops through the decks and restocks each deck
	protected void restoreDecks() {
		for (Deck p : decks) {
			p.restockDeck();
		}
	}

	// Loops through the decks and counts the number of totalCards in each deck
	public int cardsLeft() {
		int totalCards = 0;
		for (Deck p : decks) {
			totalCards += p.cardsLeft();
		}
		return totalCards;
	}

}
