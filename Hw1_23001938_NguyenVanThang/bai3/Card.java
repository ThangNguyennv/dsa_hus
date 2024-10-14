package Hw1_23001938_NguyenVanThang.bai3;

import java.util.*;

public class Card implements Comparable<Card>{
    private int rank; // Hạng: A 2 3 4 5 6 7 8 9 10 J Q K
    private int suit; // Chất: Cơ Rô Tép Bích

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        String[] ranks = {"Ace", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        return ranks[rank] + " " + suits[suit];
    }

    @Override
    public int compareTo(Card o) {
        if (rank > o.rank) {
            return 1;
        } else if (rank == o.rank) {
            if (suit > o.suit) {
                return 1;
            } else if (suit == o.suit) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
