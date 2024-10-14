package Hw3_23001938_NguyenVanThang.exercise_three;

import java.util.Stack;

public class ValidBracket {
    public static double isValid(String strings) {
        String[] array = strings.split("");
        String res = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(") || array[i].equals(")") || array[i].equals("∗") || array[i].equals("/")) {
                res += ' ';
                res += array[i];
                res += ' ';
            } else {
                res += array[i];
            }
        }
        String[] arrays = res.split(" ");
        Stack<String> stack1 = new Stack<>();
        Stack<Double> stack2 = new Stack<>();

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals("+") || arrays[i].equals("−") || arrays[i].equals("∗") || arrays[i].equals("/")) {
                stack1.push(arrays[i]);
            } else if (isNumber(arrays[i])) {
                stack2.push(Double.parseDouble(arrays[i]));
            } else if (arrays[i].equals(")")) {
                double result = 0;
                double number1 = stack2.pop(); // thằng trên cùng
                double number2 = stack2.pop(); // thằng ở dưới thường sẽ lớn hơn thằng ở trên
                String operator = stack1.pop();
                if (operator.equals("+")) {
                    result = number1 + number2;
                } else if (operator.equals("−")) {
                    result = number2 - number1;
                } else if (operator.equals("∗")) {
                    result = number1 * number2;
                } else if (operator.equals("/")) {
                    result = number2 / number1;
                }
                stack2.push(result);
            }
        }
        return stack2.pop();
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "(1 + ((2 + 3) ∗ (8 ∗ 5)))";
        System.out.println(isValid(s));
    }
}
