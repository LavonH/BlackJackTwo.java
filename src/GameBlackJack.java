public class GameBlackJack {

    private DeckBlackJack deck, discarded;

    private DealerBlackJack dealer;
    private PlayerBlackJack player;
    private int wins, losses, pushes;

    /**
     * constructor
     */
    public GameBlackJack() {

        deck = new DeckBlackJack(true);

        discarded = new DeckBlackJack();

        dealer = new DealerBlackJack();
        player = new PlayerBlackJack();

        deck.shuffle();
        startRound();
    }

    /**
     * 
     */
    private void startRound() {

        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round... Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        if (deck.cardsLeft() < 4) {
            deck.reloadDeckFromDiscard(discarded);
        }

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();

        player.printHand();

        if (dealer.hasBlackjack()) {

            dealer.printHand();

            if (player.hasBlackjack()) {

                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            } else {
                System.out.println("Dealer has BlackJack. You lose.");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        if (player.hasBlackjack()) {
            System.out.println("You have Blackjack! You win!");
            wins++;
            startRound();
        }

        player.makeDecision(deck, discarded);

        if (player.getHand().calculatedValue() > 21) {
            System.out.println("You have gone over 21.");
            losses++;
            startRound();
        }

        dealer.printHand();
        while (dealer.getHand().calculatedValue() < 17) {
            dealer.hit(deck, discarded);
        }

        if (dealer.getHand().calculatedValue() > 21) {
            System.out.println("Dealer busts");
            wins++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println("You lose.");
            losses++;
        } else if (player.getHand().calculatedValue() > dealer.getHand().calculatedValue()) {
            System.out.println("You win.");
            wins++;
        } else {
            System.out.println("Push.");
            pushes++;

        }

        startRound();
    }

    public static void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}