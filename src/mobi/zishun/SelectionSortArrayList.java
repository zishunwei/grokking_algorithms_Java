package mobi.zishun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSortArrayList {
    private static ArrayList<Integer> selectionSort(ArrayList<Integer> arrayList) {
        ArrayList<Integer> newArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            int smallestIndex = findSmallest(arrayList);
            newArrayList.add(arrayList.get(smallestIndex));
            arrayList.remove(smallestIndex);
        }
        return newArrayList;
    }


    private static int findSmallest(ArrayList<Integer> arrayList) {
        int smallest = arrayList.get(0);
        int smallestIndex = 0;

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < smallest) {
                smallest = arrayList.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        // 使用List生成ArrayList
        List<Integer> list = Arrays.asList(9, 5, 4, 10, 0, 1, 2, 6, 3);
        ArrayList<Integer> arrList = new ArrayList<>(list);

        System.out.println(selectionSort(arrList));
    }
}
