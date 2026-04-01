import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {

    public static void printArrayListReverse(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static int maxElement(ArrayList<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            // if (numbers.get(i) > max) {
            // max = numbers.get(i);
            // }
            max = Math.max(max, numbers.get(i));
        }
        return max;
    }

    public static void swap(ArrayList<Integer> numbers, int idx1, int idx2) {
        int temp = numbers.get(idx1);
        numbers.set(idx1, numbers.get(idx2));
        numbers.set(idx2, temp);
    }

    public static int storedWater(ArrayList<Integer> heights) {
        int maxWater = 0;

        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {
                int height = Math.min(heights.get(i), heights.get(j));
                int width = j - i;
                int currWater = height * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }

        return maxWater;
    }

    // Stored Water - 2 Pointer Approach
    public static int storedWater2PointerApproach(ArrayList<Integer> heights) {
        int maxWater = 0;
        int lp = 0;
        int rp = heights.size() - 1;

        while (lp < rp) {
            // calculate water area
            int height = Math.min(heights.get(lp), heights.get(rp));
            int width = rp - lp;
            int currWater = height * width;
            maxWater = Math.max(maxWater, currWater);

            // update pointers
            if (heights.get(lp) < heights.get(rp))
                lp++;
            else
                rp--;
        }

        return maxWater;
    }

    public static boolean pairSum1(ArrayList<Integer> nums, int target) { // Brute force
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean pairSum12Pointer(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp < rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) > target) {
                rp--;
            } else {
                lp++;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int pivot = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }

        int lp = pivot + 1; // smallest
        int rp = pivot; // largest
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) > target) {
                rp = (list.size() + rp - 1) % list.size();
            } else {
                lp = (lp + 1) % list.size();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list);
        list.add(1, 3);
        list.set(2, 4);
        list.add(2, 2);
        System.out.println(list);
        System.out.println(list.contains(4));

        ArrayList<String> letters = new ArrayList<>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");
        for (int i = 0; i < letters.size(); i++) {
            System.out.print(letters.get(i) + " ");
        }
        System.out.println();

        // Print Arraylist elements in reverse order - O(n)
        printArrayListReverse(letters);

        // Max element in ArrayList - O(n)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(6);
        numbers.add(8);
        numbers.add(7);
        numbers.add(10);
        System.out.println("Max element in the arraylist is: " + maxElement(numbers));

        // Swaping 2 elements - O(1)
        int idx1 = 1, idx2 = 3;
        System.out.println(numbers);
        swap(numbers, idx1, idx2);
        System.out.println(numbers);

        // Sorting
        Collections.sort(numbers);
        System.out.println(numbers);

        // descending sorting
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println(numbers);

        // Multi-Dimensional ArrayList

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // list1
        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1);
        // list1.add(2);
        // list1.add(3);
        // list1.add(4);
        // list1.add(5);
        // mainList.add(list1);

        // // list2
        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(2);
        // list2.add(4);
        // list2.add(6);
        // list2.add(8);
        // list2.add(10);
        // mainList.add(list2);

        // // list2
        // ArrayList<Integer> list3 = new ArrayList<>();
        // list3.add(3);
        // list3.add(6);
        // list3.add(9);
        // list3.add(12);
        // list3.add(15);
        // mainList.add(list3);

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        // print multi-dimensional arraylist - nested loop
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
        System.out.println(mainList);

        // Container with most water - Brute Force
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        // System.out.println(storedWater(heights));
        System.out.println(storedWater2PointerApproach(heights));

        // Pair Sum - 1
        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        System.out.println(pairSum1(lists, 5));

        System.out.println(pairSum12Pointer(lists, 7));

        // Pair Sum - 2
        ArrayList<Integer> sortedRotated = new ArrayList<>();
        sortedRotated.add(11);
        sortedRotated.add(12);
        sortedRotated.add(6);
        sortedRotated.add(8);
        sortedRotated.add(9);
        sortedRotated.add(10);
        int target = 16;
        System.out.println(pairSum2(sortedRotated, target));
    }
}
