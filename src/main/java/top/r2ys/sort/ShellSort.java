package top.r2ys.sort;

import java.util.Arrays;

/**
 * @program: leetcode-course
 * @description: 希尔排序
 * https://zhuanlan.zhihu.com/p/34914588
 * @author: HU
 * @create: 2021-02-24 18:05
 */
//Java 代码实现
public class ShellSort implements IArraySort {

    public static void main(String[] args) {
//        int array[] = {20,50,20,40,70,10,80,30,60};
        int[] array={49,38,65,97,76,13,27,49,78,34,12,64,1};
//        System.out.println("排序之前:" + Arrays.toString(array));
//        ShellSort(array);
//        System.out.println("排序之后:" + Arrays.toString(array));

        sortSample(array);
        System.out.println("排序之后:" + Arrays.toString(array));

    }

    public static void sortSample(int[] array) {
        int gap = array.length;
        while (true) {
            gap /= 2;   //增量每次减半
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序
                    int k = j - gap;
                    while (k >= 0 && array[k] > array[k+gap]) {
                        int temp = array[k];
                        array[k] = array[k+gap];
                        array[k + gap] = temp;
                        k -= gap;
                    }
                }
            }
            if (gap == 1)
                break;
        }
    }

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        return new int[0];
    }
}
