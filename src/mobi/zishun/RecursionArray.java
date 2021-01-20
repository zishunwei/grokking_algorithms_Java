package mobi.zishun;

//使用递归实现一些基础数组方法
public class RecursionArray {
    //使用递归实现数组求和
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

    //使用递归实现数组计数
    private static int recursionCount(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return 1;
        } else {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i + 1];
            }
            // 等效于下行：使用系统自带函数arraycopy实现数组拷贝
            // System.arraycopy(arr, 1, newArr, 0, newArr.length);
            return 1 + recursionCount(newArr);
        }
    }

    //使用递归实现数组最大值
    private static int recursionMax(int[] arr) {
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
            int max = recursionMax(newArr);
            if (arr[0] > max) {
                return arr[0];
            } else {
                return max;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 8, 11, 13};
        System.out.println(recursionSum(arr));
        System.out.println(recursionCount(arr));
        System.out.println(recursionMax(arr));
    }
}
