package Hw2_23001938_NguyenVanThang.bai4;

import Hw2_23001938_NguyenVanThang.bai2.SimpleArrayList;
import Hw2_23001938_NguyenVanThang.bai3.SimpleLinkedList;

import java.util.Scanner;

public class Maintest {
    public static void main(String[] args) {
        SimpleArrayList<WordCount> arrayWordCount = new SimpleArrayList<>(100);
        SimpleLinkedList<WordCount> listWordCount = new SimpleLinkedList<>();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        // bỏ dấu cách
        String[] tokens = text.split(" ");

        // ArrayList
        for (int i = 0; i < tokens.length; i++) {
            WordCount word = new WordCount(tokens[i]);
            int index = arrayWordCount.indexOf(word);
            if (index == -1) { // chưa có trong danh sách
                arrayWordCount.add(word);
            } else {
                arrayWordCount.get(index).upCount();
            }
        }
        System.out.println("Đếm theo ArrayList: ");
        for (WordCount list : arrayWordCount) {
            System.out.println(list);
        }

        // LinkedList
        for (int i = 0; i < tokens.length; i++) {
            WordCount word = new WordCount(tokens[i]);
            int index = listWordCount.indexOf(word);
            if (index == -1) { // chưa có trong danh sách
                listWordCount.add(word);
            } else {
                listWordCount.get(index).upCount();
            }
        }
        System.out.println("Đếm theo LinkedList: ");
        for (int i = 0; i < listWordCount.size(); i++) {
            System.out.println(listWordCount.get(i) + " ");
        }
    }
}
