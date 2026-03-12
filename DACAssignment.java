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

    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mars", "mercury" };
        mergeSortStringArray(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
