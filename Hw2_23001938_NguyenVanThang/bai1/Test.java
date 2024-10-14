package Hw2_23001938_NguyenVanThang.bai1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test {
    public static void normalize(Fraction c) {
        float minIndex = Math.min(Math.abs(c.getNumerator()), Math.abs(c.getDenominator()));
        int temp = 1;
        for (int i = 2; i <= minIndex; i++) {
            if ( (c.getNumerator() % i == 0) && (c.getDenominator() % i == 0)) {
                temp = i;
            }
        }
        c.setNumerator(c.getNumerator() / temp);
        c.setDenominator(c.getDenominator() / temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời nhập số phân số: ");
        int n = sc.nextInt();

        Fraction[] arr = new Fraction[n];
        Float[] sortedFraction = new Float[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Phân số thứ " + (i + 1) + ": ");
            System.out.print("Tử số: ");
            float tuSo = sc.nextFloat();
            System.out.print("Mẫu số: ");
            float mauSo = sc.nextFloat();
            Fraction fraction = new Fraction(tuSo, mauSo);
            normalize(fraction); // Rút gọn phân số nhập vào!!!
            arr[i] = fraction;
            sortedFraction[i] = tuSo / mauSo;
        }

        System.out.println("-----------------------------");

        for (int i = 0; i < n; i++) {
            System.out.println("Phân số thứ " + (i + 1) + ": " + arr[i]);
        }
        System.out.print("In ra phân số thứ: " );
        int v = sc.nextInt();
        System.out.println("Phân số ở vị trí thứ " + v + ": " + arr[v - 1]);

        Fraction sumResult = arr[0];
        for (int i = 1; i < n; i++) {
            sumResult = sumResult.add(arr[i]);
        }
        System.out.println("Tổng của " + n + " phân số: " + sumResult);

        Fraction minusResult = arr[0];
        for (int i = 1; i < n; i++) {
            minusResult = minusResult.minus(arr[i]);
        }
        System.out.println("Hiệu của " + n + " phân số: " + minusResult);

        Fraction multiResult = arr[0];
        for (int i = 1; i < n; i++) {
            multiResult = multiResult.multi(arr[i]);
        }
        System.out.println("Tích của " + n + " phân số: " + multiResult);

        Fraction diviResult = arr[0];
        for (int i = 1; i < n; i++) {
            diviResult = diviResult.divi(arr[i]);
        }
        System.out.println("Thương của " + n + " phân số: " + diviResult);

        Arrays.sort(arr, new Comparator<Fraction>() {
            @Override
            public int compare(Fraction o1, Fraction o2) {
                long tich1 = (long) (o1.getNumerator() * o2.getDenominator());
                long tich2 = (long) (o2.getNumerator() * o1.getDenominator());
                if (tich1 > tich2) {
                    return 1; // o1 > o2
                } else if (tich1 < tich2) {
                    return -1; // o1 < o2
                } else {
                    return 0; // o1 = o2
                }
            }
        });
        System.out.println("Dãy phân số sau khi sắp xếp là: ");
        for (Fraction x : arr) {
            System.out.print(x + " ");
        }
    }
}
