package top.r2ys.leetcodecourse;

/**
 * @program: leetcode-course
 * @description:
 * @author: HU
 * @create: 2021-02-10 14:53
 */
public class Leet242 {

    /**
     * valid-anagram：有效的字母异位词
     * https://mp.weixin.qq.com/s/o5HTxmOgpftSaQdebS9zyQ
     * https://leetcode-cn.com/problems/valid-anagram/
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 两个字符串长度不相等
        if (s.length() != t.length()) {
            return false;
        }

        // 26个字母的哈希表（每个元素计数）
        int[] couterTable = new int[26];

        // 遍历两个字符串
        // s字符串+1，t字符串-1
        for (int i = 0; i < s.length(); i++) {
            (couterTable[s.charAt(i) - 'a'])++;
            (couterTable[t.charAt(i) - 'a'])--;
        }

        // 哈希表每个元素计数都为0
        for (int i = 0; i < couterTable.length; i++) {
            if (couterTable[i] != 0) {
                return false;
            }
        }

        // 所有计数都为0
        return true;
    }
}
