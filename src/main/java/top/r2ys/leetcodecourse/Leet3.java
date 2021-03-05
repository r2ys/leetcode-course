package top.r2ys.leetcodecourse;

import java.util.HashMap;

/**
 * @program: leetcode-course
 * @description: 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 * @author: HU
 * @create: 2021-03-04 12:00
 */
public class Leet3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int max = 0;
        // 遍历指针和不重复子串的开始指针
        for (int start = 0, end = 0; end < c.length; end++) {
            // 当前遍历元素在哈希表中有的话，开始指针向前移动一位
            if (map.containsKey(c[end])) {
                // 当前遍历元素存在哈希表中，但是开始指针已经越过了下标（说明下标距离遍历指针中间已经有重复的，并且不重复子串的计算已经重新开始了）
                // 所以开始指针只能向前移动(下标小，上次不重复子串开始指针大，还是移动到上次的位置)
                start = Math.max(map.get(c[end]) + 1, start);
            }
            // 开始指针和遍历指针的距离就是当前截止到当前光标的最大不重复子串的长度，然后和中间变量比较取最大
            max = Math.max(max, end - start + 1);
            map.put(c[end], end);
        }
        return max;

    }

    public static void main(String[] args) {
        Leet3 leet3 = new Leet3();
        int len = leet3.lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }
}
