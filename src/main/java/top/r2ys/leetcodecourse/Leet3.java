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
        for (int start = 0, end = 0; end < c.length; end++) {
            if (map.containsKey(c[end])) {
                start = Math.max(map.get(c[end]) + 1, start);
            }
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
