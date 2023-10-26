import java.util.ArrayList;

/**
 * 
 */
public class HandBlackJack {

    private ArrayList<CardBlackJack> hand;

    public HandBlackJack() {
        hand = new ArrayList<CardBlackJack>();
    }

    /**
     * 
     * 
     */
    public void takeCardFromDeck(DeckBlackJack deck) {
        hand.add(deck.takeCard());
    }

    /**
     * 
     * 
     */
    /**
     *
     * 
     */
    public void discardHandToDeck(DeckBlackJack discardDeck) {

        discardDeck.addCards(hand);

        hand.clear();

    }

    /**
     *
     * 
     */
    public String toString() {
        String output = "";
        for (CardBlackJack card : hand) {
            output += card + " - ";
        }
        return output;
    }

    /**
     *
     * 
     */
    public int calculatedValue() {

        int value = 0;
        int aceCount = 0;

        for (CardBlackJack card : hand) {

            value += card.getValue();

            if (card.getValue() == 11) {
                aceCount++;
            }
        }

        if (value > 21 && aceCount > 0) {
            while (aceCount > 0 && value > 21) {
                aceCount--;
                value -= 10;
            }
        }
        return value;

    }

    /**
     *
     * 
     * 
     */
    public CardBlackJack getCard(int idx) {
        return hand.get(idx);
    }

}
