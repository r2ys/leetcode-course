package top.r2ys.sort;

import java.util.Arrays;

/**
 * @program: leetcode-course
 * @description: 冒泡排序
 * https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247483905&idx=1&sn=79512c5e81bc2e8e3095c6ff592e8ed2&chksm=fa0e6d80cd79e496c5cf885d6f5eb5808f47368f855d3f7745d0d407ae22a56d8666eb57b42f&scene=21#wechat_redirect
 * https://github.com/r2ys/JS-Sorting-Algorithm/blob/master/1.bubbleSort.md
 * @author: HU
 * @create: 2021-02-23 16:00
 */
public class BubbleSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arr;
    }
}
