package Hw5_23001938_NguyenVanThang.exercise.exercise4;

import Hw5_23001938_NguyenVanThang.exercise.exercise1.SortedArrayPriorityQueue;
import Hw5_23001938_NguyenVanThang.exercise.exercise1.SortedLinkedPriorityQueue;
import Hw5_23001938_NguyenVanThang.exercise.exercise1.UnsortedArrayPriorityQueue;
import Hw5_23001938_NguyenVanThang.exercise.exercise1.UnsortedLinkedPriorityQueue;

import java.util.Random;
import java.util.Scanner;

public class Compare {
    /*
    Note: phép đo chỉ mang tính tương đối
          Đơn vị: mili giây
n                                      10^3        10^4        10^5        10^6        10^7         10^8
          | UnsortedArray              4.10^-7     2.10^-6     9,6.10^-6   3,6.10^-5   2,5.10^-4    4.10^-3
insert    | SortedArray(Descending)    3,8.10^-4   7,6.10^-4   1,52.10^-3  3,04.10^-3  6,08.10^-3   12,16.10^-3
          | UnsortedLinked             3,5.10^-6   5.10^-5     9.10^-5     2.10^-4     2,5.10^-4    3.10^-3
          | SortedLinked(Descending)   10^-5       7.10^-5     2.10^-4     2,3.10^-4   2,7.10^-3    3,7.10^-3
---------- ----------------------------------------------------------------------------------------------------
          | UnsortedArray              5,5.10^-9   5,7.10^-9   6,3.10^-9   6,5.10^-9   6,7.10^-9    6,9.10^-9
removeMin | SortedArray(Descending)    3,3.10^-9   3,4.10^-9   3,5.10^-9   3,6.10^-9   3,8.10^-9    4.10^-9
          | UnsortedLinked             5,5.10^-9   5,7.10^-9   6,3.10^-9   6,5.10^-9   6,7.10^-9    6,9.10^-9
          | SortedLinked(Descending)   3,3.10^-9   3,4.10^-9   3,5.10^-9   3,6.10^-9   3,8.10^-9    4.10^-9

    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random random = new Random();
        UnsortedArrayPriorityQueue<Integer, Integer> q1 = new UnsortedArrayPriorityQueue<>(n);
        SortedArrayPriorityQueue<Integer, Integer> q2 = new SortedArrayPriorityQueue<>(n);
        UnsortedLinkedPriorityQueue<Integer, Integer> q3 = new UnsortedLinkedPriorityQueue<>();
        SortedLinkedPriorityQueue<Integer, Integer> q4 = new SortedLinkedPriorityQueue<>();

        System.out.println("UnsortedArrayPriorityQueue: ");
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            q1.insert(1 + random.nextInt(n), 1 + random.nextInt(n));
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Thời gian thực hiện
        System.out.println("Thời gian thực hiện insert (nan giây): " + duration);

        long startTime1 = System.nanoTime();
        q1.removeMin();
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1; // Thời gian thực hiện
        System.out.println("Thời gian thực hiện removeMin (nan giây): " + duration1);

        System.out.println("-------------------------------------");

        System.out.println("SortedArrayPriorityQueue(Descending): ");
        long startTime2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            q2.insert(1 + random.nextInt(n), 1 + random.nextInt(n));
        }
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2; // Thời gian thực hiện
        System.out.println("Thời gian thực hiện insert (nan giây): " + duration2);

        long startTime3 = System.nanoTime();
        q2.removeMin();
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3; // Thời gian thực hiện
        System.out.println("Thời gian thực hiện removeMin (nan giây): " + duration3);

        System.out.println("-------------------------------------");

        System.out.println("UnsortedLinkedPriorityQueue: ");
        long startTime4 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            q3.insert(1 + random.nextInt(n), 1 + random.nextInt(n));
        }
        long endTime4 = System.nanoTime();
        long duration4 = endTime4 - startTime4; // Thời gian thực hiện
        System.out.println("Thời gian thực hiện insert (nan giây): " + duration4);

        long startTime5 = System.nanoTime();
        q3.removeMin();
        long endTime5 = System.nanoTime();
        long duration5 = endTime5 - startTime5; // Thời gian thực hiện
        System.out.println("Thời gian thực hiện removeMin (nan giây): " + duration5);


        System.out.println("-------------------------------------");


        System.out.println("SortedLinkedPriorityQueue(Descending): ");
        long startTime6 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            q4.insert1(1 + random.nextInt(n), 1 + random.nextInt(n));
        }
        long endTime6 = System.nanoTime();
        long duration6 = endTime6 - startTime6; // Thời gian thực hiện
        System.out.println("Thời gian thực hiện removeMin (nan giây): " + duration6);

        long startTime7 = System.nanoTime();
        q4.removeMin1();
        long endTime7 = System.nanoTime();
        long duration7 = endTime7 - startTime7; // Thời gian thực hiện
        System.out.println("Thời gian thực hiện removeMin (nan giây): " + duration7);

    }
}
