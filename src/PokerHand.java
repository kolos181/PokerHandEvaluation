import java.util.Random;

public class PokerHand {

    private int pokerHandId;
    private String pokerHandName;

    //if no params, creates random card
    public PokerHand() {
        Random random = new Random();
        int i = random.nextInt(9) + 1;
        setPokerHandId(i);
    }

    public PokerHand(int i) {
        setPokerHandId(i);
    }

    public void setPokerHandId(int i) {
        if (i >= 1 && i <= 10) {
            switch (i) {
                case (1):
                    setPokerHandName("Highest Card");
                    pokerHandId = 1;
                    break;
                case (2):
                    setPokerHandName("Pair");
                    pokerHandId = 2;
                    break;
                case (3):
                    setPokerHandName("Two Pairs");
                    pokerHandId = 3;
                    break;
                case (4):
                    setPokerHandName("Three of a kind");
                    pokerHandId = 4;
                    break;
                case (5):
                    setPokerHandName("Straight");
                    pokerHandId = 5;
                    break;
                case (6):
                    setPokerHandName("Flush");
                    pokerHandId = 6;
                    break;
                case (7):
                    setPokerHandName("Full house");
                    pokerHandId = 7;
                    break;
                case (8):
                    setPokerHandName("Four of a kind");
                    pokerHandId = 8;
                    break;
                case (9):
                    setPokerHandName("Straight flush");
                    pokerHandId = 9;
                    break;
                case (10):
                    setPokerHandName("Royal flush");
                    pokerHandId = 10;
                    break;
            }

        } else {
            System.err.println("PokerHand value should be between 1 and 10 inclusive");
        }
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "pokerHandId=" + pokerHandId +
                ", pokerHandName='" + pokerHandName + '\'' +
                '}';
    }

    public void setPokerHandName(String pokerHandName) {
        this.pokerHandName = pokerHandName;
    }
}
