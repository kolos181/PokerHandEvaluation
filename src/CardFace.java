public class CardFace {
    //Spades 1, Clubs 2, Diamonds 3, Hearts 4
    private int cardFaceNumber;
    private String cardFace;

    public CardFace()  { }

    public CardFace(int i) {
        setCardFace(i);
    }

    public void setCardFace(int i)  {

        if (i >= 1 && i <= 4) {
            switch (i) {
                case (1):
                    setCardFace("Spades");
                    this.cardFaceNumber = 1;
                    break;
                case (2):
                    setCardFace("Clubs");
                    this.cardFaceNumber = 2;
                    break;
                case (3):
                    setCardFace("Diamonds");
                    this.cardFaceNumber = 3;
                    break;
                case (4):
                    setCardFace("Hearts");
                    this.cardFaceNumber = 4;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "CardFace{" +
                "cardFaceNumber=" + cardFaceNumber +
                ", cardFace='" + cardFace + '\'' +
                '}';
    }

    public void setCardFace(String cardFace) {
        this.cardFace = cardFace;
    }

    public int getCardFaceNumber() {
        return cardFaceNumber;
    }

    public String getCardFace() {
        return cardFace;
    }
}
