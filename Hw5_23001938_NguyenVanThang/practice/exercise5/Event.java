package Hw5_23001938_NguyenVanThang.practice.exercise5;

public class Event implements Comparable<Event> {
    private int startTime; // Thời gian bắt đầu
    private int endTime; // Thời gian kết thúc

    public Event(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Event {" + "startTime = " + startTime + ", endTime = " + endTime + '}';
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
