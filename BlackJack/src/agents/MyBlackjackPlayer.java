package agents;

import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;

public class MyBlackjackPlayer extends BlackjackPlayer {

	@Override
	public int getBet() {

		// Returns the number of chips based on 
		//how much the player has currently
		if (this.getChips() > 750)
			return 5;
		else if (this.getChips() > 500)
			return 10;
		else if (this.getChips() > 250)
			return 12;
		else
			return 15;

	}

	@Override
	public Move getMove() {
		if (this.handScore() >= 17)
				return Move.STAY;
			else if (this.handScore() >= 13 && this.handScore() <= 16) {
				if (this.dealer.getVisibleCard().getRank()<=6 && this.dealer.getVisibleCard().getRank() != 1)
					return Move.STAY;
				else
					return Move.HIT;
			} else if (this.handScore() == 12) {
				if (this.dealer.getVisibleCard().getRank() >= 4 && this.dealer.getVisibleCard().getRank() <= 4)
					return Move.STAY;
				else
					return Move.HIT;
			} else if (this.handScore() == 11) {
				return Move.DOUBLE;
			} else if (this.handScore() == 10) {
				if (this.dealer.getVisibleCard().getRank()<=9 && this.dealer.getVisibleCard().getRank() != 1)
					return Move.DOUBLE;
				else
					return Move.HIT;
			} else if (this.handScore() == 9) {
				if (this.dealer.getVisibleCard().getRank()<=6 && this.dealer.getVisibleCard().getRank() != 1 && this.dealer.getVisibleCard().getRank() != 2)
					return Move.DOUBLE;
				else
					return Move.HIT;
			} else
				return Move.HIT;
			
		/*
		//If the current handscore is less than or equal to twelve, hit
		if (this.handScore() <= 12) {
			return Move.HIT;
		//if the current handscore is between (12,17], then check the dealers card
		} else if (this.handScore() > 12 && this.handScore() <= 17) {
			//if the dealers card is 6 or below and not an ace, stay
			if (this.dealer.getVisibleCard().getRank() <= 6 && this.dealer.getVisibleCard().getRank() != 1) {
				return Move.STAY;
			//else hit
			} else {
				return Move.HIT;
			}
			// if the handscore is over 17, stay
		} else if (this.handScore() > 17) {
			return Move.STAY;
		}
		//stay otherwise
		return Move.STAY;*/
}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once the hand is over, then
		 * you can do it here. This method is called automatically after every hand and
		 * a copy of the dealer's final hand is given to you to process.
		 */

	}

}
