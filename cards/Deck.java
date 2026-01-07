package cards;

import java.util.Random;

public class Deck {

  private Card[] cards; 
    private int index;

    public Deck() {
        cards = new Card[52];
        index = 0;

        int c = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                cards[c++] = new Card();
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < cards.length; i++) {
            int j = rand.nextInt(52);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        index = 0;
    }

    public void cut(int pos) {
        if (pos < 0 || pos > 51) return;

        Card[] newDeck = new Card[52];
        int p = 0;

        for (int i = pos; i < 52; i++) {
            newDeck[p++] = cards[i];
        }
        for (int i = 0; i < pos; i++) {
            newDeck[p++] = cards[i];
        }

        cards = newDeck;
        index = 0;
    }

    public Card draw() {
        if (index >= 52)
            return null;
        return cards[index++];
    }

    public void print(int n) {
        for (int i = 0; i <= n && i < 52; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println();
    }
}