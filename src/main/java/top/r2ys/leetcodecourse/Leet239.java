package top.r2ys.leetcodecourse;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode-course
 * @description: 滑动窗口最大值
 * 使用双端队列，每滑动一次，当前值附加到队列末尾，末尾前只要小的都移除，队列头部的下标超出窗口的话也移除
 * 每次遍历的时候取队列的头就是每个滑动窗口的最大值
 * @author: HU
 * @create: 2021-02-10 10:26
 */
public class Leet239 {

    public int[] maxSlidingWindow2(int[] nums, int k) {
        // 数组长度
        int leng = nums.length;
        // 滑动窗口移动次数 == 需要计算的次数（滑动窗口每次最大值）
        int[] maxValues = new int[leng - k + 1];
        // 采用双端队列，head->end, 从大到小，每个队列的元素保存的是数组的下标
        Deque<Integer> idxDeque = new LinkedList<>();
        // 从头到尾遍历数组
        for (int i = 0; i < leng; i++) {
            // 将当前下标保存到队列末尾前，从后到前比较队列中的元素(已经是排序过的)，如果有小于当前下标值的，就删掉
            int curValue = nums[i];
            while (i != 0 && !idxDeque.isEmpty() && nums[idxDeque.getLast()] < curValue) {
                idxDeque.removeLast();
            }

            // 将当前下标保存到队列末尾
            idxDeque.offerLast(i);

            // 窗口每移动一次，就将窗口离开的下标元素移除
            // 如果上一次窗口中第一个元素最大，那移动一次窗口后就会删除；
            // 如果上一次窗口中第二个元素最大，那移动两次窗口后就会删除；
            // 如果上一次窗口中第k-1个元素最大，那移动k-1次窗口后就会删除；
            // 新窗口中有比大部分值大的情况，非最大的元素在第一步就已经删除了
            // 新窗口中没有比原窗口大的情况，就把新元素附加到队列末尾，但是下一次移动窗口就会把头移除
            // 所以在每次移动窗口时，只需要考虑删除队列头的元素即可
            int maxValueIdx = idxDeque.getFirst();
            if (maxValueIdx <= i - k) {
                idxDeque.removeFirst();
            }

            // 当前数组遍历的下标是滑动窗口最后位置，才开始保存最大值
            int valueIdx = i - k + 1;
            if (valueIdx >= 0) {
                maxValueIdx = idxDeque.getFirst();
                maxValues[valueIdx] = nums[maxValueIdx];
            }
        }
        return maxValues;
    }

    public static void main(String[] args) {
        Leet239 leet239 = new Leet239();
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int[] resultArr2 = leet239.maxSlidingWindow2(arr, 3);
        System.out.println(Arrays.toString(resultArr2));
    }
}
