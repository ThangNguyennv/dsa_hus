package degiuaki_so1.bai1;

import java.util.HashMap;
import java.util.Map;

public class MinValue {
    public static long getMinValue(int[] v) {
        long min = Long.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int x : v) {
            sum += x;
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        int valueMax = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            valueMax = Math.max(valueMax, entry.getValue() * entry.getKey());
        }
        return sum - valueMax;
    }

    public static void main(String[] args) {
        int[] v = {6, 5, 2, 1, 2, 1, 1, 2, 2};
        System.out.println(getMinValue(v));
    }
}
