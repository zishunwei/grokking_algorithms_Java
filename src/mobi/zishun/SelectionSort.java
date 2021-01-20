package mobi.zishun;

import java.util.Arrays;

public class SelectionSort {
    private static int[] selectionSort(int[] arr) {
        int[] newArray = new int[arr.length];

        for (int i = 0; i < newArray.length; i++) {
            int smallestIndex = findSmallestIndex(arr);
            newArray[i] = arr[smallestIndex];

            arr = deleteSmallest(arr, smallestIndex);
        }
        return newArray;
    }

    private static int[] deleteSmallest(int[] arr, int smallestIndex) {
        int[] newArray = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < smallestIndex) {
                newArray[i] = arr[i];
            } else if (i > smallestIndex) {
                newArray[i - 1] = arr[i];
            }
        }
        return newArray;
    }

    private static int findSmallestIndex(int[] arr) {
        int smallest = arr[0];
        int smallestIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 6, 1, 5, 4};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
