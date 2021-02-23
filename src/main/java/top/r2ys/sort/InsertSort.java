package top.r2ys.sort;

import java.util.Arrays;

/**
 * @program: leetcode-course
 * @description: 插入排序
 * https://github.com/r2ys/JS-Sorting-Algorithm/blob/master/3.insertionSort.md
 * https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247483979&idx=1&sn=b8154f94771a7509f44139e667a2ef84&chksm=fa0e6dcacd79e4dc2645c05720b73d86ca33de41b52ba03e7c9645a02fe9cca919001d612e58&scene=21#wechat_redirect
 * @author: HU
 * @create: 2021-02-23 16:31
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        return arr;
    }
}
