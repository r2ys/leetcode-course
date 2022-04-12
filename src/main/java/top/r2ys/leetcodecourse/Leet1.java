package top.r2ys.leetcodecourse;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-course
 * @description: 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author: HU
 * @create: 2021-03-04 10:13
 */
public class Leet1 {

    public int[] twoSum(int[] nums, int target) {
        // 把遍历过的数保存至map中，当前下标对应的差值数去map里查有否
        Map<Integer, Integer> iteratedMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (iteratedMap.containsKey(target - nums[i])) {
                return new int[]{iteratedMap.get(target - nums[i]), i};
            }
            iteratedMap.put(nums[i], i);
        }
        return new int[0];
    }
}
