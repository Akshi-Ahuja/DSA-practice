public class DivideAndConquer {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si, j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void mergeSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si) / 2;

        // left
        mergeSort(arr, si, mid);
        // right
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    // Quick Sort

    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei)
            return;

        // kaam

        // last element - pivot
        int pIdx = partition(arr, si, ei);

        quickSort(arr, si, pIdx - 1); // left
        quickSort(arr, pIdx + 1, ei); // right
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place the pivot at its right place as well
        i++;
        // swap for pivot
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    // Search Target in Rotated Sorted Array - Recursion

    public static int search(int arr[], int target, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        // kaam
        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        // mid lies on L1
        if (arr[si] <= arr[mid]) {
            // case a: left of mid
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid - 1);
            }
            // case b: right to mid
            else {
                return search(arr, target, mid + 1, ei);
            }
        }

        // mid lies on L2
        else {
            // case c: target right to mid
            if (arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei);
            }
            // case d: left to mid
            else {
                return search(arr, target, si, mid - 1);
            }
        }
    }

    // Search Target in Rotated Sorted Array - Iterations

    public static int searchWithIterations(int arr[], int target) {
        int si = 0;
        int ei = arr.length;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[si] <= arr[mid]) {
                if (arr[si] <= target && target <= arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }

            else {
                if (arr[mid] <= target && target <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // MERGE SORT
        // int arr[] = { 6, 3, 9, 5, 2, 8, -2 };
        // mergeSort(arr, 0, arr.length - 1);
        // printArray(arr);

        // QUICK SORT
        // int arr02[] = { 6, 5, 8, 2, 1, 3 };
        // quickSort(arr02, 0, arr02.length - 1);
        // printArray(arr02);

        // SEARCH TARGET IN ROTATED SORTED ARRAY
        int arr03[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6;
        // int tIdx = search(arr03, target, 0, arr03.length - 1);
        int tIdx = searchWithIterations(arr03, target);
        System.out.println(tIdx);
    }
}
