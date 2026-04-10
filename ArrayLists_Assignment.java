import java.util.*;

public class ArrayLists_Assignment {

    // Q1
    public static boolean isMonotonic(ArrayList<Integer> nums) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                inc = false;
            }
            if (nums.get(i) < nums.get(i + 1)) {
                dec = false;
            }
        }

        return inc || dec;
    }

    // Q2
    public static ArrayList<Integer> lonelyNumbers(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            boolean isLonely = true;

            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (nums.get(j) == curr) {
                    isLonely = false;
                    break;
                }
                if (nums.get(j) == (curr + 1) || nums.get(j) == (curr - 1)) {
                    isLonely = false;
                    break;
                }
            }

            if (isLonely == true) {
                result.add(nums.get(i));
            }
        }

        return result;
    }

    public static ArrayList<Integer> lonelyNumsOptimized(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(nums);

        int n = nums.size();

        for (int i = 0; i < n; i++) {
            boolean isLonely = true;

            if (i > 0 && nums.get(i) == nums.get(i - 1)) {
                isLonely = false;
            }

            if (i < n - 1 && nums.get(i) == nums.get(i + 1)) {
                isLonely = false;
            }

            if (i > 0 && nums.get(i - 1) == nums.get(i) - 1) {
                isLonely = false;
            }

            if (i < n - 1 && nums.get(i + 1) == nums.get(i) + 1) {
                isLonely = false;
            }

            if (isLonely) {
                result.add(nums.get(i));
            }
        }
        return result;
    }

    // Q3
    public static int frequentTarget(ArrayList<Integer> nums, int key) {
        int count = 0;
        int resultTarget = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == key) {
                int target = nums.get(i + 1);
                int currCount = 1;
                for (int j = i + 1; j < nums.size() - 1; j++) {
                    if (nums.get(j) == key && nums.get(j + 1) == target) {
                        currCount++;
                    }
                }
                if (currCount > count) {
                    count = currCount;
                    resultTarget = i + 1;
                }
            }
        }

        return nums.get(resultTarget);
    }

    public static int freqTargetOptApproach(ArrayList<Integer> nums, int key) {
        int result[] = new int[1000];
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }

        return ans;
    }

    // Q4
    public static ArrayList<Integer> beautifulArrayListIterative(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        while (ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int num : ans) {
                if (2 * num <= n)
                    temp.add(2 * num);
            }

            for (int num : ans) {
                if (2 * num - 1 <= n)
                    temp.add(2 * num - 1);
            }

            ans = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        // 1)
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        // nums.add(4);

        // System.out.println(isMonotonic(nums));

        // 2)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(3);

        ArrayList<Integer> result = lonelyNumsOptimized(numbers); // lonelyNumbers(numbers);
        System.out.println(result);

        // 3
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 100, 200, 1, 100));

        // System.out.println(frequentTarget(list, 2));
        System.out.println(freqTargetOptApproach(list, 1));

        // 4
        System.out.println(beautifulArrayListIterative(4));
    }
}
