public class Backtracking {

    public static void changeArray(int arr[], int i, int val) {
        // base case
        if (i == arr.length) {
            printArray(arr);
            return;
        }

        // recursion - kaam
        arr[i] = val;
        changeArray(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void findSubsets(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // recursion
        // yes choice
        findSubsets(str, ans + str.charAt(i), i + 1);

        // No choice
        findSubsets(str, ans, i + 1);
    }

    public static void findPermutations(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion - kaam
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutations(newStr, ans + curr);
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5]; // empty array
        changeArray(arr, 0, 1);
        printArray(arr);

        String str = "abc";
        findSubsets(str, "", 0);

        findPermutations(str, "");
    }
}
