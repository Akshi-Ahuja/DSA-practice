package Stacks;

import java.util.*;

public class Stack03 {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        // kaam
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        // base case
        if (s.isEmpty()) {
            return;
        }
        // kaam
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        String result = reverseString("abc");
        System.out.println(result);

        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);

        reverseStack(s2);
        printStack(s2);

    }
}
