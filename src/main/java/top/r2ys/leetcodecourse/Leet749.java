package top.r2ys.leetcodecourse;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: leetcode-course
 * @description:
 * @author: HU
 * @create: 2021-02-10 14:53
 */
public class Leet749 {

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
