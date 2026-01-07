package cards;

import java.util.Arrays;

public class Hand {
    private Card[] cards;
    private int size; 
    private final int maxCards;

    
    public Hand(int maxCards) {
        this.maxCards = maxCards;
        this.cards = new Card[maxCards];
        this.size = 0;
    }

    
    public void add(Card card) {
        if (size < maxCards) {
            cards[size] = card;
            size++;
        }
    }

    
    public int length() {
        return size;
    }

    
    public Card get(int index) {
        if (index >= 0 && index < size) {
            return cards[index];
        }
        return null;
    }

   
    public Card remove(int index) {
        if (index >= 0 && index < size) {
            Card removedCard = cards[index];
            for (int i = index; i < size - 1; i++) {
                cards[i] = cards[i + 1];
            }
            cards[size - 1] = null; 
            size--;
            return removedCard;
        }
        return null;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(cards[i].toString());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
