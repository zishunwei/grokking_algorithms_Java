package mobi.zishun;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[][] arr = new int[3][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
