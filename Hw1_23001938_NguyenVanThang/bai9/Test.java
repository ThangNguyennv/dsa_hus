package Hw1_23001938_NguyenVanThang.bai9;

import java.util.*;

public class Test {
    public static class Student {
        int height;
        int index;

        public Student(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int heights[] = new int[n];
        int T = sc.nextInt();
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student(heights[i], i));
        }
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.height == o2.height) {
                    return o1.index - o2.index;
                }
                return o1.height - o2.height;
            }
        });
        for (int j = 0; j < n; j++) {
            if (students.get(j).index == T - 1) {
                System.out.println(j + 1);
                break;
            }
        }
    }
}