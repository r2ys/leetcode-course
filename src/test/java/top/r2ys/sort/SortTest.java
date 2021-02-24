package top.r2ys.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void radixSort() {
        IArraySort sort;
        int[] result;
        int[] arr = new int[]{-100, 321, 1, 10, 60, 577, 743, 127};

        // 冒泡排序
        sort = new BubbleSort();
        try {
//            result = sort.sort(arr);
//            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 堆排序
        sort = new HeapSort();
        try {
            result = sort.sort(arr);
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 计数排序
        sort = new CountingSort();
        try {
//            result = sort.sort(arr);
//            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 基数排序
        sort = new RadixSort();
        try {
//            result = sort.sort(arr);
//            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}