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

}
