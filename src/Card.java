import java.lang.reflect.Array;
import java.util.*;


public class Card {

    CardFace cardFace;
    CardValue cardValue;
    public static final Card[] DECK_OF_CARDS = generateDeck();

    public Card() {
        cardFace = new CardFace();
        cardValue = new CardValue();
    }

    public Card(int face, int value) {

        this.cardFace = new CardFace(face);
        this.cardValue = new CardValue(value);
    }

    public Card(CardFace cardFace, CardValue cardValue) {
        this.cardFace = cardFace;
        this.cardValue = cardValue;
    }

    public static Card[] generateDeck() {

        Card[] deck = new Card[52];
        int counter = 0;

        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 14; j++) {
                deck[counter++] = new Card(i, j);
            }
        }
        return deck;
    }

    //pull random cards from deck. i is the number
    public static Card[] pullCardsFromDeck(int i) {
        //array that says if card was taken from deck. You can't take the same card from deck twice
        boolean[] picked = new boolean[52];
        Card[] cards = new Card[i];

        Random rand = new Random();
        for (int j = 0; j < i; j++) {
            int temp;
            do {
                temp = rand.nextInt(52);
            } while (picked[temp]);

            cards[j] = DECK_OF_CARDS[temp];
            picked[temp] = true;
        }
        return cards;
    }

    public static PokerHand whatHand(Card[] cards) {
        ArrayList<Card> cards1 = new ArrayList<>();
        for (Card temp : cards) {
            cards1.add(temp);
        }
        Collections.sort(cards1, new SortByCardValue());

        int[] faces = new int[cards1.size()];
        int[] values = new int[cards1.size()];

        //get face and values as int arrays just for convenience
        for (int i = 0; i < cards1.size(); i++) {
            faces[i] = cards1.get(i).getCardFace().getCardFaceNumber();
            values[i] = cards1.get(i).getCardValue().getCardValueNumber();
        }

        //Check if flush
        if (faces[0] == faces[1] && faces[1] == faces[2] && faces[2] == faces[3] && faces[3] == faces[4]) {
            //and also if straight flush
            if (values[0] == values[1] - 1 && values[1] == values[2] - 1 && values[2] == values[3] - 1
                    && values[3] == values[4] - 1) {
                return new PokerHand(9);
            } else if (values[0] == values[1] - 1 && values[1] == values[2] - 1 && values[2] == values[3] - 1
                    && values[3] == values[4] - 1 && values[4] == 14) {
                return new PokerHand(10);
            }
            return new PokerHand(6);
        }
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        //check if four of a kind
        if (values[0] == values[1] && values[1] == values[2] && values[2] == values[3]) {
            return new PokerHand(8);
        }

        //check if full house and three of a kind after
        if (values[0] == values[1] && values[1] == values[2]) {
            if (values[3] == values[4]) {
                return new PokerHand(7);
            } else {
                return new PokerHand(4);
            }
        }

        //check if straight
        if (values[0] == values[1] - 1 && values[1] == values[2] - 1 && values[2] == values[3] - 1
                && values[3] == values[4] - 1) {
            return new PokerHand(5);
        }

        //check if two pairs
        if (values[0] == values[1] && values[2] == values[3]) {
            return new PokerHand(3);
        }

        //check if pair. I decided to check only first fwo cards. I don't think it is risky to confuse with three of a
        //kind of two pairs, because we checked for that previously

        if (values[0] == values[1]) {
            return new PokerHand(2);
        }

        //If we haven't found anything, all that is left is highest card
        return new PokerHand(1);
    }

    public static int whatHandReloaded(Card[] cards) {
        ArrayList<Card> cards1 = new ArrayList<>();
        for (Card temp : cards) {
            cards1.add(temp);
        }
        Collections.sort(cards1, new SortByCardValue());

        int[] faces = new int[cards1.size()];
        int[] values = new int[cards1.size()];

        //get face and values as int arrays just for convenience
        for (int i = 0; i < cards1.size(); i++) {
            faces[i] = cards1.get(i).getCardFace().getCardFaceNumber();
            values[i] = cards1.get(i).getCardValue().getCardValueNumber();
        }

        //Check if flush
        if (faces[0] == faces[1] && faces[1] == faces[2] && faces[2] == faces[3] && faces[3] == faces[4]) {
                //check if royal flush
            if (values[0] == values[1] - 1 && values[1] == values[2] - 1 && values[2] == values[3] - 1
                    && values[3] == values[4] - 1 && values[4] == 14) {
                return 10;
            //if straight flush
            }  else if (values[0] == values[1] - 1 && values[1] == values[2] - 1 && values[2] == values[3] - 1
                    && values[3] == values[4] - 1) {
                return 9;
            }
            return 6;
        }

        //check if four of a kind
        if (values[0] == values[1] && values[1] == values[2] && values[2] == values[3]) {
            return 8;
        }

        //check if full house and three of a kind after
        if (values[0] == values[1] && values[1] == values[2]) {
            if (values[3] == values[4]) {
                return 7;
            } else {
                return 4;
            }
        }

        //check if straight
        if (values[0] == values[1] - 1 && values[1] == values[2] - 1 && values[2] == values[3] - 1
                && values[3] == values[4] - 1) {
            return 5;
        }

        //check if two pairs
        if (values[0] == values[1] && values[2] == values[3]) {
            return 3;
        }

        //check if pair. I decided to check only first fwo cards. I don't think it is risky to confuse with three of a
        //kind of two pairs, because we checked for that previously

        if (values[0] == values[1]) {
            return 2;
        }

        //If we haven't found anything, all that is left is highest card
        return 1;
    }



    public CardFace getCardFace() {
        return cardFace;
    }

    public void setCardFace(CardFace cardFace) {
        this.cardFace = cardFace;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return cardValue.getCardValueName() + " of " + cardFace.getCardFace();
    }
}

