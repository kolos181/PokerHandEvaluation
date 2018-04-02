import java.util.Comparator;

public class SortByCardValue implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getCardValue().getCardValueNumber() - o2.getCardValue().getCardValueNumber();
    }
}
