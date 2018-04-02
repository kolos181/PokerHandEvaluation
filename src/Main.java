import Exceptions.OutsideOfCardFaceValueException;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Card[] customHand = {new Card(1, 10), new Card(1, 11), new Card(1, 12),
                new Card(1, 13), new Card(1, 14)};

        int[] handCounters = new int[11];

        for (int i = 0; i < 10; i++) {
            System.out.println(Card.whatHand(Card.pullCardsFromDeck(5)));
        }
        for (int temp :handCounters) {
            System.out.println(temp);
        }


    }

}
