import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 
 */
public class DeckBlackJack {

    private ArrayList<CardBlackJack> deck;

    /**
     * 
     */
    public DeckBlackJack() {
        deck = new ArrayList<CardBlackJack>();
    }

    /**
     * 
     * 
     */
    public DeckBlackJack(DeckBlackJack c) {
        Collections.copy(this.deck, c.getCards());
    }

    /**
     * 
     * 
     */
    public DeckBlackJack(boolean makeDeck) {
        deck = new ArrayList<CardBlackJack>();
        if (makeDeck) {

            for (SuitBlackJack suit : SuitBlackJack.values()) {

                for (RankBlackJack rank : RankBlackJack.values()) {

                    deck.add(new CardBlackJack(suit, rank));
                }
            }
        }
    }

    /**
     *
     * 
     */
    public void addCard(CardBlackJack card) {
        deck.add(card);
    }

    /**
     *
     * 
     */
    public void addCards(ArrayList<CardBlackJack> cards) {
        deck.addAll(cards);
    }

    /**
     *
     * 
     */
    public String toString() {

        String output = "";

        for (CardBlackJack card : deck) {
            output += card;
            output += "\n";
        }
        return output;
    }

    /**
     * 
     */
    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    /**
     *
     * 
     */
    public CardBlackJack takeCard() {

        CardBlackJack cardToTake = new CardBlackJack(deck.get(0));

        deck.remove(0);

        return cardToTake;

    }

    /**
     *
     * 
     */
    public boolean hasCards() {
        if (deck.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * 
     */
    public int cardsLeft() {
        return deck.size();
    }

    /**
     *
     * 
     */
    public ArrayList<CardBlackJack> getCards() {
        return deck;
    }

    /**
     * 
     */
    public void emptyDeck() {
        deck.clear();
    }

    /**
     * 
     * 
     * 
     */
    public void reloadDeckFromDiscard(DeckBlackJack discard) {
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }

}
