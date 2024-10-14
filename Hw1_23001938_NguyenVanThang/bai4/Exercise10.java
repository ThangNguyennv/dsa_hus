package Hw1_23001938_NguyenVanThang.bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (array[i] != 0){
                list.add(array[i]);
            }
        }
        int k = 0;
        Collections.sort(list);
        for (int i = n-1; i >= 0; i--){
            if (array[i] < 0){
                array[i] = list.get(k);
                k = k + 1;
            }
        }
        for (int i = 0; i < n; i++){
            if (array[i] > 0){
                array[i] = list.get(k);
                k++;
            }
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
