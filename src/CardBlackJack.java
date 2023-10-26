public class CardBlackJack implements Comparable<CardBlackJack> {

    private SuitBlackJack suit;
    private RankBlackJack rank;

    /**
     *
     * 
     * 
     */
    public CardBlackJack(SuitBlackJack suit, RankBlackJack rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * 
     * 
     * 
     */
    public CardBlackJack(CardBlackJack card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    /**
     *
     * 
     */
    public int getValue() {
        return rank.rankValue;
    }

    /**
     *
     * 
     */
    public SuitBlackJack getSuit() {
        return suit;
    }

    public RankBlackJack getRank() {
        return rank;
    }

    /**
     *
     * 
     */
    public String toString() {
        return ("[" + rank + " of " + suit + "] (" + this.getValue() + ")");

    }

    /**
     * 
     * 
     * 
     * 
     * 
     */
    @Override
    public int compareTo(CardBlackJack c) {
        // if this card is greater than the other card
        if (this.getValue() > c.getValue()) {
            return 1;
        } else if (this.getValue() < c.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }

}
