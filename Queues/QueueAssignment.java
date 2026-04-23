package Queues;

import java.util.*;

public class QueueAssignment {

    public static void printNBinaryNums(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 1; i <= n; i++) {
            String s = q.remove();
            System.out.print(s + " ");

            q.add(s + "0");
            q.add(s + "1");
        }
    }

    public static void main(String[] args) {
        printNBinaryNums(5);
    }
}
