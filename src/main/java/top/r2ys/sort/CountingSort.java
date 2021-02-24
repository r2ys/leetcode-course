package top.r2ys.sort;

import java.util.Arrays;

/**
 * @program: leetcode-course
 * @description: 计数排序
 * https://github.com/r2ys/JS-Sorting-Algorithm/blob/master/8.countingSort.md
 * @author: HU
 * @create: 2021-02-24 10:58
 */
public class CountingSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int minValue = getMinValue(arr);
        int maxValue = getMaxValue(arr);

        return countingSort(arr, minValue, maxValue);
    }

    private int[] countingSort(int[] arr, int minValue, int maxValue) {
        int bucketLen = maxValue - minValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value - minValue]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j + minValue;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMinValue(int[] arr) {
        int minValue = arr[0];
        for (int value : arr) {
            if (minValue > value) {
                minValue = value;
            }
        }
        return minValue;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

}
