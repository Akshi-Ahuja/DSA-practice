import java.util.*;

public class sorting {

    public static void printArray(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(Integer arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        printArray(arr);
    }

    public static void selectionSort(Integer arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }

        printArray(arr);
    }

    public static void insertionSort(Integer arr[]) {

        for (int i = 1; i < arr.length; i++) {
            int curr = i;
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }

        printArray(arr);
    }

    public static void countingSort(int arr[]) {
        int count = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > count) {
                count = arr[i];
            }
        }

        int array[] = new int[count + 1];

        for (int i = 0; i < arr.length; i++) {
            array[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                arr[j] = i;
                array[i]--;
                j++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Integer arr[] = { 7, 1, 3, 9, 6, 5 };
        // bubbleSort(arr);

        // selectionSort(arr);
        insertionSort(arr);

        Integer arr02[] = { 2, 6, 9, 1, 4, 0 };
        // Arrays.sort(arr02);
        // printArray(arr02);

        Arrays.sort(arr02, Collections.reverseOrder());
        printArray(arr02);

        int arr03[] = { 7, 3, 8, 9, 1, 0 };
        countingSort(arr03);
    }
}