package top.r2ys.leetcodecourse;

import top.r2ys.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode-course
 * @description: 二叉搜索树中第K小的元素
 * 二叉排序树==二叉搜索树==二叉查找树
 * 它的特点是：根节点删除时，要将右子树中最左的叶子节点移动到根节点
 * 通过递归左树、当前根节点、递归右树，每次计数，这个递归的整体顺序就是从小到大的顺序，当计数==k时，就是结果
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @author: HU
 * @create: 2021-02-10 10:26
 */
public class Leet230 {

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        System.out.println(nums.toString());
        return nums.get(k - 1);
    }

    private int res;
    private int count;

    public int kthSmallest2(TreeNode root, int k) {
        inorder(root, k);

        return res;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        // 递归左树
        inorder(root.left, k);

        // 迭代当前根节点
        ++count;
        if (count == k) {
            res = root.val;
            return;
        }

        // 递归右树
        inorder(root.right, k);
    }

}
