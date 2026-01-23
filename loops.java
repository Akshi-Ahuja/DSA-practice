import java.util.*;

public class loops {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Question 1... How many times hello is printed?");
        System.out.println("My answer is 2");
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            i += 2;
        }

        System.out.println();

        System.out.println("Question 2....");
        int[] set = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int even = 0, odd = 0;
        for (int i = 0; i < set.length; i++) {
            if (set[i] % 2 == 0) {
                even += set[i];
            } else {
                odd += set[i];
            }
        }
        System.out.println("Even Sum: " + even);
        System.out.println("Odd Sum: " + odd);

        System.out.println();
        System.out.println("Question 3......");

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        int fact = 1;
        for (int i = num; i >= 1; i--) {
            fact *= i;
        }
        System.out.println("Factorial of " + num + " is: " + fact);

        System.out.println();

        System.out.println("Question 4......");

        System.out.println("Enter number: ");
        int x = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(x + " X " + i + " = " + (x * i));
        }
    }
}
