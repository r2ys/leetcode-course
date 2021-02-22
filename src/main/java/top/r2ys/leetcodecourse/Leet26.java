package top.r2ys.leetcodecourse;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode-course
 * @description:
 * @author: HU
 * @create: 2021-02-10 14:53
 */
public class Leet26 {

    /**
     * remove-duplicates-from-sorted-array:删除排序数组中的重复项
     * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC26%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E5%88%A0%E9%99%A4%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E9%87%8D%E5%A4%8D%E9%A1%B9.md
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
//        Stack<Integer> decreasingStack = new Stack<>();
        Deque<Integer> decreasingStack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            int ele = T[i];
            while (!decreasingStack.isEmpty() && T[decreasingStack.peek()] < ele) {
                result[decreasingStack.peek()] = i - decreasingStack.peek();
                decreasingStack.pop();
            }
            decreasingStack.push(i);
        }
        return result;
    }
}
