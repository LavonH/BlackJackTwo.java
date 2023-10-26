import java.util.Scanner;

/**
 * 
 */
public class PlayerBlackJack extends PersonBlackJack {

    Scanner input = new Scanner(System.in);

    public PlayerBlackJack() {
        super.setName("Player");

    }

    public void makeDecision(DeckBlackJack deck, DeckBlackJack discard) {

        int decision = 0;
        boolean getNum = true;

        while (getNum) {

            try {
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = input.nextInt();
                getNum = false;

            } catch (Exception e) {
                System.out.println("Invalid");
                input.next();
            }

        }

        if (decision == 1) {
            this.hit(deck, discard);

            if (this.getHand().calculatedValue() > 20) {
                return;
            } else {
                this.makeDecision(deck, discard);
            }

        } else {
            System.out.println("You stand.");
        }

    }

}
