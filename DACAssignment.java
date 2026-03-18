public class DACAssignment {

    public static void printArray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSortStringArray(String arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        mergeSortStringArray(arr, si, mid); // left
        mergeSortStringArray(arr, mid + 1, ei); // right
        mergeStringArrays(arr, si, mid, ei);
    }

    public static void mergeStringArrays(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if ((arr[i].compareTo(arr[j])) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to main array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // 2
    public static int majorityElementBruteForce(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int candidate = nums[i];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == candidate) {
                    count++;
                }
            }
            if (count > (nums.length / 2)) {
                return candidate;
            }
        }
        return -1;
    }

    public static int countInRange(int nums[], int candidate, int si, int ei) {
        int count = 0;
        while (si <= ei) {
            if (nums[si] == candidate) {
                count++;
            }
            si++;
        }
        return count;
    }

    public static int majorityElementRec(int nums[], int si, int ei) {
        // base case
        if (si == ei) {
            return nums[si];
        }

        // kaam
        int mid = si + (ei - si) / 2;

        int left = majorityElementRec(nums, si, mid);
        int right = majorityElementRec(nums, mid + 1, ei);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, si, ei);
        int rightCount = countInRange(nums, right, si, ei);

        return leftCount > rightCount ? left : right;
    }

    public static int majorityElementDVCApproach(int nums[]) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public static int inversionCountBruteForceApp(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j] && i < j) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int merge(int arr[], int si, int mid, int ei) {
        int count = 0;
        int temp[] = new int[ei - si + 1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (i = si, k = 0; i <= ei; i++, k++) {
            arr[i] = temp[k];
        }

        return count;

    }

    public static int mergeSort(int arr[], int si, int ei) {
        int invCount = 0;
        while (si < ei) {
            int mid = si + (ei - si) / 2;
            invCount += mergeSort(arr, si, mid);
            invCount += mergeSort(arr, mid + 1, ei);
            invCount += merge(arr, si, mid, ei);
        }

        return invCount;
    }

    public static int inversionCountMergeApp(int arr[]) {
        return mergeSort(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        // 1
        String arr[] = { "sun", "earth", "mars", "mercury" };
        mergeSortStringArray(arr, 0, arr.length - 1);
        printArray(arr);

        System.out.println();

        // 2
        int nums[] = { 2, 2, 2, 1, 1, 1, 2 };
        System.out.println(majorityElementBruteForce(nums));

        int nums02[] = { 3, 1, 3 };
        System.out.println(majorityElementDVCApproach(nums02));

        // 3
        int array[] = { 2, 4, 1, 3, 5 };
        // System.out.println(inversionCountBruteForceApp(array));
        System.out.println(inversionCountMergeApp(array));
    }
}
