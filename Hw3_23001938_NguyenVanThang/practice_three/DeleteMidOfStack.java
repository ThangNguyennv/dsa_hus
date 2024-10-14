package Hw3_23001938_NguyenVanThang.practice_three;

import java.util.Stack;

class DeleteMidOfStack {

    public static void deleteMid(Stack<Integer> s, int sizeOfStack) {
        Stack<Integer> stacks = new Stack<>(); // Stack lưu tạm các thành phần trừ thằng ở giữa
        int middleElement = (int) Math.ceil((sizeOfStack + 1) / 2); // vị trí ở giữa và làm tròn xuống
        for (int i = 1; i < middleElement; i++) { // do đề bài index bắt đầu từ 1
            stacks.push(s.get(i - 1)); // hàm get() lấy ra từ đáy lên đỉnh
        }
        for (int i = middleElement + 1; i <= sizeOfStack; i++) {
            stacks.push(s.get(i - 1));
        }
        for (int i = 0; i < sizeOfStack; i++) { //
            s.pop(); // xóa hết các thành phần trong stack s
        }
        for (int i = 1; i < sizeOfStack; i++) {
            s.push(stacks.get(i - 1)); // khi này stack s đã trống, ta đẩy các giá trị trong stack stacks vào
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(54);
        stack.push(12);
        stack.push(1200);
        deleteMid(stack, 5);
        System.out.println(stack);
    }
}
