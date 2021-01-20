package mobi.zishun;

//使用递归实现数组求和
public class RecursionSum {
    private static int recursionSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return arr[0];
        } else {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i + 1];
            }
            // 等效于下行：使用系统自带函数arraycopy实现数组拷贝
            // System.arraycopy(arr, 1, newArr, 0, newArr.length);
            return arr[0] + recursionSum(newArr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 8};
        System.out.println(recursionSum(arr));
    }
}
