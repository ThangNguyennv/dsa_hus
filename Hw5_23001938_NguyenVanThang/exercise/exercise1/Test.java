package Hw5_23001938_NguyenVanThang.exercise.exercise1;

public class Test {
    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, Character> q1 = new UnsortedArrayPriorityQueue<>();
        q1.insert(20, 'G');
        q1.insert(16, 'D');
        q1.insert(7, 'B');
        q1.insert(90, 'C');
        System.out.println("PriorityQueue before deleting: ");
        q1.print();
        System.out.println("min now is: " + q1.min());
        System.out.println("min now is deleted: " + q1.removeMin());

        System.out.println();

        System.out.println("PriorityQueue after deleting: ");
        q1.print();
        System.out.print("Entry min now is: ");
        q1.printEntry(q1.min());
        System.out.println("size now is: " + q1.size());

        System.out.println("------------------------");

        SortedArrayPriorityQueue<Integer, Character> q2 = new SortedArrayPriorityQueue<>();
        q2.insert(20, 'G');
        q2.insert(16, 'D');
        q2.insert(7, 'B');
        q2.insert(90, 'C');
        System.out.println("Descending PriorityQueue before deleting is: ");
        q2.print();
        System.out.println("min now is: " + q2.min());
        System.out.println("min now is deleted: " + q2.removeMin());

        System.out.println();

        System.out.println("Descending PriorityQueue after deleting is: ");
        q2.print();
        System.out.print("Entry min now is: ");
        q2.printEntry(q2.min());
        System.out.println("size now is: " + q2.size());

        System.out.println("------------------------");

        UnsortedLinkedPriorityQueue<Integer, Character> q3 = new UnsortedLinkedPriorityQueue<>();
        q3.insert(20, 'G');
        q3.insert(16, 'D');
        q3.insert(7, 'B');
        q3.insert(90, 'C');
        System.out.println("PriorityQueue before deleting: ");
        q3.print();
        System.out.println("min now is: " + q3.min());
        System.out.println("min now is deleted: " + q3.removeMin());

        System.out.println();

        System.out.println("PriorityQueue after deleting: ");
        q3.print();
        System.out.print("Entry min now is: ");
        q3.printEntry(q3.min());
        System.out.println("size now is: " + q3.size());

        System.out.println("------------------------");

        SortedLinkedPriorityQueue<Integer, Character> q4 = new SortedLinkedPriorityQueue<>();
        q4.insert(20, 'G');
        q4.insert(16, 'D');
        q4.insert(7, 'B');
        q4.insert(90, 'C');
        System.out.println("ascending PriorityQueue before deleting: ");
        q4.print();
        System.out.println("min now is: " + q4.min());
        System.out.println("min now is deleted: " + q4.removeMin());

        System.out.println();

        System.out.println("ascending PriorityQueue after deleting: ");
        q4.print();
        System.out.print("Entry min now is: ");
        q4.printEntry(q4.min());
        System.out.println("size now is: " + q4.size());
    }
}
