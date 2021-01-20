package mobi.zishun;

public class BinarySearch {
    private static Integer binarySearch(int[] list, int item) {
        //定义查找的范围
        int low = 0;
        int high = list.length - 1;

        //每次检查中间的元素
        while (low <= high) {
            int mid = (low + high) / 2; //Java自动向下取整
            int guess = list[mid];
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] mylist = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(mylist, 5));
        System.out.println(binarySearch(mylist, -1));
    }
}
