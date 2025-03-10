package Hw1_23001938_NguyenVanThang.bai3;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getRank() > o2.getRank()) {
            return 1;
        } else if (o1.getRank() == o2.getRank()) {
            if (o1.getSuit() > o2.getSuit()) {
                return 1;
            } else if (o1.getSuit() < o2.getSuit()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
}
