package org.macross.entity;

import java.io.Serializable;

public class StudentCard implements Serializable {
    private int cardId;
    private int cardInfo;

    public StudentCard(int cardId, int cardInfo) {
        this.cardId = cardId;
        this.cardInfo = cardInfo;
    }
    public StudentCard() {
    }

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
        return "StudentCard{" +
                "cardId=" + cardId +
                ", cardInfo=" + cardInfo +
                '}';
    }
}
