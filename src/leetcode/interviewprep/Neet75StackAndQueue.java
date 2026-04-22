package leetcode.interviewprep;

import java.util.ArrayDeque;
import java.util.Arrays;

class MinStack {

    static class StackNode {
        int val;
        int min;
        StackNode(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    ArrayDeque<StackNode> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new StackNode(val, val));
        } else {
            StackNode top = stack.peek();
            stack.push(new StackNode(val, Math.min(top.min, val)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}


public class Neet75StackAndQueue {

    public static String result(String s) {
        int len = s.length();

        if (len <= 1)
            return s;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
               if (sb.length() > 0) {
                   sb.deleteCharAt(sb.length() - 1);
               }
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] solution(int[] temperatures) {
        int len = temperatures.length;
        if (len <= 1) return new int[len];

        int[] res = new int[len];
        ArrayDeque<Pair> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty() && stack.peek().y < temperatures[i]) {
                Pair p = stack.pop();
                res[p.x] = i - p.x;
            }

            stack.push(new Pair(i, temperatures[i]));
        }

        return res;
    }

    static void main() {
       int[] nums = new int[] {22,21,20};
        System.out.println(Arrays.toString(solution(nums)));
    }
}
