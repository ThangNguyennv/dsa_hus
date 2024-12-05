package degiuaki_so2.bai1;

public class Q1 {
    public static int max(double[] a, int n) {
        if (n == 1) {
            return (int) a[0];
        }
        int left = 0, right = n - 1;
        double max = Double.MIN_VALUE;
        for (double x : a) {
            max = Math.max(max, x);
        }
        if (max == a[right]) {
            return (int) max;
        }
        if (max == a[left]) {
            return (int) max;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return (int) a[mid];
            } else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        double[] a = {12, 5, 4, 3, 2, 1};
        System.out.println(max(a, 6));
    }
}