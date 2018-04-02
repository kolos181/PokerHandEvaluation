public class CardValue {

    private int cardValueNumber;
    private String cardValueName;

    public CardValue() { }

    public CardValue(int i) {
        setCardValueNumber(i);
    }

    public int getCardValueNumber() {
        return cardValueNumber;
    }

    public void setCardValueNumber(int cardValueNumber)  {
        if (cardValueNumber >= 2 && cardValueNumber <= 14) {
            switch (cardValueNumber) {
                case (2):
                    setCardValueName("Two");
                    this.cardValueNumber = 2;
                    break;
                case (3):
                    setCardValueName("Three");
                    this.cardValueNumber = 3;
                    break;
                case (4):
                    setCardValueName("Four");
                    this.cardValueNumber = 4;
                    break;
                case (5):
                    setCardValueName("Five");
                    this.cardValueNumber = 5;
                    break;
                case (6):
                    setCardValueName("Six");
                    this.cardValueNumber = 6;
                    break;
                case (7):
                    setCardValueName("Seven");
                    this.cardValueNumber = 7;
                    break;
                case (8):
                    setCardValueName("Eight");
                    this.cardValueNumber = 8;
                    break;
                case (9):
                    setCardValueName("Nine");
                    this.cardValueNumber = 9;
                    break;
                case (10):
                    setCardValueName("Ten");
                    this.cardValueNumber = 10;
                    break;
                case (11):
                    setCardValueName("Jack");
                    this.cardValueNumber = 11;
                    break;
                case (12):
                    setCardValueName("Queen");
                    this.cardValueNumber = 12;
                    break;
                case (13):
                    setCardValueName("King");
                    this.cardValueNumber = 13;
                    break;
                case (14):
                    setCardValueName("Ace");
                    this.cardValueNumber = 14;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "CardValue{" +
                "cardValueNumber=" + cardValueNumber +
                ", cardValueName='" + cardValueName + '\'' +
                '}';
    }

    public String getCardValueName() {
        return cardValueName;
    }

    public void setCardValueName(String cardValueName) {
        this.cardValueName = cardValueName;
    }
}
