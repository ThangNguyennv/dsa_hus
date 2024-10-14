package Hw3_23001938_NguyenVanThang.practice_two;

class ArrayStack {
    private int[] arr;
    private int top;
    public ArrayStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) { // thêm phần tử vào đỉnh stack
        top++;
        arr[top] = x;
    }

    public int pop() { // lấy phần tử ở đỉnh stack và xóa nó khỏi stack
        if (top == -1) {
            return -1;
        } else {
            int cur = arr[top];
            top--;
            return cur;
        }
    }

    public int top() {
        return arr[top];
    }

    public static void main(String[] args) {
        ArrayStack array = new ArrayStack();
        array.push(1);
        array.push(2);
        array.push(5);
        array.push(100);
        System.out.println(array.top());
        System.out.println(array.pop());
        System.out.println(array.top());
    }
}
