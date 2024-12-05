package degiuaki_so2.bai2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q2 {
    public static long size(File file) {
        if (!file.isDirectory()) {
            return file.length();
        } else {
            long sum = 0;
            File[] fs =  file.listFiles();
            if (fs != null) {
                for (File x : fs) {
                    sum += size(x);
                }
            }
            return sum;
        }
    }

    public static List<String> ls(File file) {
        File[] files = file.listFiles(); // nội dung thư mục
        if (files == null) return new ArrayList<>(); // Kiểm tra null
        List<File> lists = new ArrayList<>();
        for (File x : files) {
            if (x.isFile()) {
                lists.add(x);
            }
        }
        lists.sort((o1, o2) -> Long.compare(o2.length(), o1.length()));
        List<String> result = new ArrayList<>();
        for (File x : lists) {
            result.add(x.getName());
        }
        return result;
    }
}

