package Hw5_23001938_NguyenVanThang.practice.exercise5;

import Hw5_23001938_NguyenVanThang.exercise.exercise1.UnsortedArrayPriorityQueue;
import java.util.*;

public class AirTrafficControlSystem {

    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, Event> eventQueue = new UnsortedArrayPriorityQueue<>();
        Random random = new Random();

        System.out.println("Thêm các sự kiện vào hàng đợi:");
        for (int i = 0; i < 10; i++) {
            int eventTime = random.nextInt(23); // Tạo thời gian ngẫu nhiên từ 0 đến 23
            int endTime = random.nextInt(23 - eventTime) + eventTime + 1; // endTime luôn > startTime
            Event event = new Event(eventTime, endTime);
            eventQueue.insert(eventQueue.createEntry(eventTime, event));
            System.out.println("Thêm sự kiện: " + event);
        }

        System.out.println("Xử lý các sự kiện theo thứ tự thời gian:");
        int soThuTu = 0;
        while (!eventQueue.isEmpty()) {
            soThuTu++;
            System.out.println("Chuyến bay số: " + soThuTu + " | " + eventQueue.removeMin());
        }
    }
}
