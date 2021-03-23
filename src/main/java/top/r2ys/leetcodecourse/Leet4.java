package top.r2ys.leetcodecourse;

/**
 * @program: leetcode-course
 * @description: 寻找两个有序数组的中位数
 * https://mp.weixin.qq.com/s/FBlH7o-ssj_iMEPLcvsY2w
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 * 解法1：本身两个有序的数组合并，也就是先归并排序
 * 最终排序的数组偶数取中间两位的平均值，奇数取中间一位的值
 * 解法2：
 * @author: HU
 * @create: 2021-03-05 10:23
 */
public class Leet4 {

    // 解法2
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        // 与运算 偶数与1 == 0，奇数与1 == 1
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2, 4, 5, 6, 7, 8};
        System.out.println(new Leet4().findMedianSortedArrays(a, b));
    }

}
