package degiuaki_so3.bai2;

public class Test {
    public static void main(String[] args) {
        String text = "sinh viên tự nhiên";
        ViFrequence vi = new ViFrequence();
        vi.analyzeText(text);
        vi.displayFrequencies();
    }
}
