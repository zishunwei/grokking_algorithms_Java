package mobi.zishun;

public class RecursionBinarySearch {
    private static Integer recursionBinarySearch(int[] arr, int target) {
        if (arr.length == 1) {
            if (arr[0] == target) {
                return 0;
            } else {
                return null;
            }
        }

        int low = 0;
        int high = arr.length - 1;
        int mid = low + high / 2;
        int guess = arr[mid];

        if (guess == target) {
            return mid;
        } else {
            int[] newArr = new int[arr.length / 2];
            if (guess < target) {
                for (int i = 0; i < newArr.length; i++) {
                    newArr[i] = arr[mid + i + 1];
                }
            } else {
                for (int i = 0; i < newArr.length; i++) {
                    newArr[i] = arr[i];
                }
            }
            return recursionBinarySearch(newArr, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(recursionBinarySearch(arr, 7));
        System.out.println(recursionBinarySearch(arr, -1));
    }
}
