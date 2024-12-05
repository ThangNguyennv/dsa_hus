package degiuaki_so3.bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringGenerator {
    public static void generator(List<String> result, String[] alphabet, String[] arr, int i, int n) {
        if (i == n) {
            StringBuilder sb = new StringBuilder();
            for (String value : arr) {
                sb.append(value);
            }
            System.out.println(sb.toString());
            return;
        } else {
            for (String value : alphabet) {
                arr[i] = value;
                generator(result, alphabet, arr, i + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] alphabet = input.split(" ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        generator(result, alphabet, arr, 0, n);

    }
}

