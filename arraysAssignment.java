import java.util.HashSet;

public class arraysAssignment {

    public static boolean appearsTwiceOrDistant(int arr[]) { // brute force approach - O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean appearsTwiceOrDistantBySetApproach(int arr[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        // System.out.println(appearsTwiceOrDistant(arr));
        System.out.println(appearsTwiceOrDistantBySetApproach(arr));
    }
}
