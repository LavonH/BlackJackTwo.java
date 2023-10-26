public enum SuitBlackJack {
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");

    String suitName;

    SuitBlackJack(String suitName) {
        this.suitName = suitName;
    }

    public String toString() {
        return suitName;
    }
}