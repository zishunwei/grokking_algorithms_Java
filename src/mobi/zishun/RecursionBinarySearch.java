package mobi.zishun;

public class RecursionBinarySearch {
    private static Integer recursionBinarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        int guess = arr[mid];
        if (guess == target) {
            return mid;
        } else if (guess < target) {
            return recursionBinarySearch(arr, target, mid + 1, high);
        } else {
            return recursionBinarySearch(arr, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println(recursionBinarySearch(arr, 7, 0, arr.length - 1));
        System.out.println(recursionBinarySearch(arr, 8, 0, arr.length - 1));
        System.out.println(recursionBinarySearch(arr, 1, 0, arr.length - 1));
        System.out.println(recursionBinarySearch(arr, -1, 0, arr.length - 1));
    }
}
