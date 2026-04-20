package Stacks;

import java.util.*;

public class Stacks04 {

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                s.push(ch);
            } else {
                // closing
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // closing
            if (ch == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    // s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate
                }
                // else {
                // s.pop(); // opening bracket found
                // }
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int heights[]) {
        int maxArea = 0;
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];

        // next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                // -1
                nsr[i] = heights.length;
            } else {
                // top
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // next smaller left
        s = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                // -1
                nsl[i] = -1;
            } else {
                // top
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // curr area
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArr = height * width;
            maxArea = Math.max(maxArea, currArr);
        }

        System.out.println("Max area in histogram is: " + maxArea);
    }

    public static void main(String[] args) {
        String str = "({})[]([])"; // true
        System.out.println(isValid(str));

        String str1 = "((a+b) + c)";
        String str2 = "((a+b))";
        System.out.println(isDuplicate(str2));

        int heights[] = { 2, 4 }; // { 2, 1, 5, 6, 2, 3 }; // heights of histogram
        maxArea(heights);
    }
}
