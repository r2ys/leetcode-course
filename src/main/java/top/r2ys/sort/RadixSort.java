package top.r2ys.sort;

import top.r2ys.sort.IArraySort;

import java.util.Arrays;

/**
 * @program: leetcode-course
 * @description: 基数排序
 * https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484076&idx=1&sn=fb551e1eb83cd483c7a963cbc432e4bd&chksm=fa0e6d2dcd79e43bc4387b3fd89c61dcc084a4e7396c453d9194f0ae357f1cf725eabd39ebb9&scene=21#wechat_redirect
 * @author: HU
 * @create: 2021-02-23 13:52
 */
public class RadixSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
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

    protected int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            System.out.println("mod:" + mod + "|dev:" + dev);

            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];
            System.out.println("i:" + i + "|counter:" + counter.length);

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                System.out.println("arr[j]:" + arr[j] + "|j:" + j + "|bucket:" + bucket);
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
                System.out.println("counter:" + bucket + "|bucket:" + Arrays.toString(counter[bucket]));
            }

            for (int k = 0; k < counter.length; k++) {
                int[] bucket = counter[k];
                System.out.println("k:" + k + "|counter:" + Arrays.toString(bucket));
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos] = value;
                    pos += 1;
                }
            }
            System.out.println("arr:" + Arrays.toString(arr));
        }

        return arr;
    }
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
