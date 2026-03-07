public class Recursion02 {

    public static int tillingProblem(int n) {

        // base case
        if (n == 0 || n == 1)
            return 1;

        // kaam
        // vertical choice
        int fnm1 = tillingProblem(n - 1);

        // horizontal choice
        int fnm2 = tillingProblem(n - 2);

        int totalWays = fnm1 + fnm2;

        return totalWays;
    }

    public static void removeDup(String str, int idx, StringBuilder newStr, boolean[] map) {

        // base case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDup(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDup(str, idx + 1, newStr.append(currChar), map);
        }

    }

    public static int friendsPairing(int n) {
        // base case
        if (n == 1 || n == 2)
            return n;

        // kaam - choice

        // single
        int fnm1 = friendsPairing(n - 1);

        // pairing
        int fnm2 = friendsPairing(n - 2);
        int pairWays = (n - 1) * fnm2;

        int totWays = fnm1 + pairWays;
        return totWays;
    }

    public static void printBinStr(int n, int lastPlace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // kaam
        printBinStr(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            printBinStr(n - 1, 1, str + "1");
        }
    }

    // Assignment Questions:

    public static void findAllOccurences(int arr[], int idx, int key) {
        // base case
        if (idx == arr.length)
            return;
        // kaam
        if (arr[idx] == key) {
            System.out.print(idx + " ");
        }
        findAllOccurences(arr, idx + 1, key);

    }

    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void covertNoToString(int num) {
        if (num == 0) {
            return;
        }
        int lastDigit = num % 10;
        covertNoToString(num / 10);
        System.out.print(digits[lastDigit] + " ");
    }

    public static int getStringLength(String str) {
        // base case
        if (str.length() == 0) {
            return 0;
        }
        // kaam
        return getStringLength(str.substring(1)) + 1;
    }

    public static int countValidSubStrings(String str, int i, int j, int n) {
        // base case
        if (n == 1)
            return 1;
        if (n == 0)
            return 0;

        // kaam
        int res = countValidSubStrings(str, i + 1, j, n - 1) + countValidSubStrings(str, i, j - 1, n - 1) -
                countValidSubStrings(str, i + 1, j - 1, n - 2);

        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        // base case
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from '" + src + "' to '" + dest + "'");
            return;
        }

        // kaam

        // transfer n-1 disks from source to helper
        towerOfHanoi(n - 1, src, dest, helper);

        // transfer nth disk from source to dest
        System.out.println("Transfer disk " + n + " from '" + src + "' to '" + dest + "'");

        // transfer n-1 disks back from helper to dest
        towerOfHanoi(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        // System.out.println(tillingProblem(5));

        // String str = "aappnaccollegd";
        // removeDup(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendsPairing(4));

        // printBinStr(3, 0, "");

        // Assignment Solutions

        // int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        // findAllOccurences(arr, 0, 2);
        // System.out.println();
        // covertNoToString(1947);
        // System.out.println();
        // System.out.println(getStringLength("abcde"));

        // String str = "abcab";
        // System.out.println(countValidSubStrings(str, 0, str.length() - 1,
        // str.length()));

        towerOfHanoi(3, "A", "B", "C");
    }
}
