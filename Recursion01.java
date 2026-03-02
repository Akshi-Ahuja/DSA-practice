public class Recursion01 {

    public static void printDec(int n) {
        // base case
        if (n == 1) {
            System.out.print(n);
            return;
        }
        // kaam
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void printInc(int n) {
        // base case
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        // kaam
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        // kaam
        int fnm1 = factorial(n - 1);
        int fn = n * fnm1;
        return fn;
    }

    public static int sumOfN(int n) {
        // base case
        if (n == 1) {
            return 1;
        }
        // kaam
        int sum = n + sumOfN(n - 1);
        return sum;
    }

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    public static void main(String[] args) {
        // int n = 10;
        // printDec(n);
        // System.out.println();
        // printInc(n);
        // System.out.println();
        // System.out.println(factorial(5));
        // System.out.println(sumOfN(5));

        System.out.println(fib(25));
    }
}