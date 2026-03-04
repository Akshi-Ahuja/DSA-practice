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

    public static boolean isSorted(int arr[], int i) {
        // base case
        if (i == arr.length - 1)
            return true;
        // kaam
        if (arr[i] > arr[i + 1])
            return false;
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int i, int key) {

        // base case
        if (i == arr.length - 1 && arr[i] != key) {
            return -1;
        }

        // kaam
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, i + 1, key);

    }

    public static int lastOccurence(int arr[], int i, int key) {

        // base case
        if (i > arr.length - 1) {
            return -1;
        }

        // kaam
        int isFound = lastOccurence(arr, i + 1, key);
        if (isFound != -1) {
            return isFound;
        }

        if (arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static int powerOfN(int x, int n) {
        // base case
        if (n == 1) {
            return x;
        }
        // kaam
        return x * powerOfN(x, n - 1);
    }

    public static int optimizedPower(int a, int n) {

        // base case
        if (n == 1) {
            return a;
        }

        // kaam
        int halfPower = optimizedPower(a, n / 2);
        int halPowerSq = halfPower * halfPower;
        if (n % 2 != 0) {
            halPowerSq = a * halPowerSq;
        }

        return halPowerSq;
    }

    public static void main(String[] args) {
        // int n = 10;
        // printDec(n);
        // System.out.println();
        // printInc(n);
        // System.out.println();
        // System.out.println(factorial(5));
        // System.out.println(sumOfN(5));

        // System.out.println(fib(25));

        // int arr[] = { 2, 4, 6, 8, 9, 1, 9, 10 };

        // System.out.println(isSorted(arr, 0));

        // System.out.println(firstOccurence(arr, 0, 10));

        // int arr01[] = { 1, 2, 3, 4, 1, 5 };
        // System.out.println(lastOccurence(arr01, 0, 1));

        System.out.println(powerOfN(2, 10));
        System.out.println(optimizedPower(2, 5));
    }
}