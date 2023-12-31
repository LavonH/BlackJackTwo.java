public abstract class PersonBlackJack {

    private HandBlackJack hand;
    private String name;

    /**
     * 
     */
    public PersonBlackJack() {
        this.hand = new HandBlackJack();
        this.name = "";
    }

    // Getters and Setters//
    public HandBlackJack getHand() {
        return this.hand;
    }

    public void setHand(HandBlackJack hand) {
        this.hand = hand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public void printHand() {
        System.out.println(this.name + "'s hand looks like this:");
        System.out.println(this.hand + " Valued at: " + this.hand.calculatedValue());
    }

    /**
     * 
     * 
     */
    public void hit(DeckBlackJack deck, DeckBlackJack discard) {

        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();
        GameBlackJack.pause();

    }

    public boolean hasBlackjack() {
        if (this.getHand().calculatedValue() == 21) {
            return true;
        } else {
            return false;
        }
    }

}
