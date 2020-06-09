package org.macross.entity;

public class StudentBusiness extends Student{
    private int cardId;
    private int cardInfo;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(int cardInfo) {
        this.cardInfo = cardInfo;
    }

    @Override
    public String toString() {
        return "StudentBusiness{" +
                super.toString()+
                "cardId=" + cardId +
                ", cardInfo=" + cardInfo +
                '}';
    }
}
