package top.r2ys.common;

/**
 * @program: leetcode-course
 * @description:
 * @author: HU
 * @create: 2021-03-25 14:57
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
