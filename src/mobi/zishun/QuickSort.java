package mobi.zishun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    private static ArrayList<Integer> quickSort(ArrayList<Integer> arrList) {
        int pivot = arrList.get(0);
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        //分解当前列表的数据
        for (int i = 1; i < arrList.size(); i++) {
            if (arrList.get(i) <= pivot) {
                less.add(arrList.get(i));
            } else {
                greater.add(arrList.get(i));
            }
        }

        //递归调用
        if (less.size() > 1) {
            quickSort(less);
        }
        if (greater.size() > 1) {
            quickSort(greater);
        }

        //合并数据，先要清空每次输入的arr（在分解到less，greater以后）
        arrList.removeAll(arrList);
        arrList.addAll(less);
        arrList.add(pivot);
        arrList.addAll(greater);
        return arrList;
    }

    public static void main(String[] args) {
        // 使用List生成ArrayList
        List<Integer> listA = Arrays.asList(9, 5, 4, 10, 0, 1, 2, 6, 3);
        ArrayList<Integer> arrList = new ArrayList<>(listA);

        System.out.println(quickSort(arrList));
    }
}
