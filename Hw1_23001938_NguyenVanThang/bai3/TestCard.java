package Hw1_23001938_NguyenVanThang.bai3;

import Hw1_23001938_NguyenVanThang.bai3.Sort;

import java.util.*;

public class TestCard {

    public static void createCards(Card[] array) {
        // Tạo 1 bộ bài 52 lá đã được sắp xếp
        int index = 0;
        for (int rank = 0; rank < 13; rank++) {
            for (int suit = 0; suit < 4; suit++) {
                array[index++] = new Card(rank, suit);
            }
        }
        // Trộn ngẫu nhiên bộ bài 52 lá đó
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            Card temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Card[] card1 = new Card[52];
        createCards(card1); // Tạo bộ bài thứ 1
        System.out.println("---------------------------------");
        System.out.println("Using Comparator, Before sorting: ");
        System.out.println("---------------------------------");
        for (int i = 0; i < card1.length; i++) {
            System.out.println(card1[i]);
        }
        Arrays.sort(card1, new CompareCard());
        System.out.println("---------------------------------");
        System.out.println("Using Comparator, After sorting: ");
        System.out.println("---------------------------------");
        for (int i = 0; i < card1.length; i++) {
            System.out.println(card1[i]);
        }

        System.out.println();

        Card[] card2 = new Card[52];
        createCards(card2); // Tạo bộ bài thứ 2
        Sort<Card> card = new Sort<>(card2);
        System.out.println("---------------------------------");
        System.out.println("Using Comparable, Before sorting: ");
        System.out.println("---------------------------------");
        card.printArray();
        // Tương tự với selectionSort(), insertionSort(), bubbleSort(), mergeSort().
        card.quickSort(card2, 0, card2.length - 1);
        System.out.println("---------------------------------");
        System.out.println("Using Comparable, After sorting: ");
        System.out.println("---------------------------------");
        card.printArray();
    }
}
