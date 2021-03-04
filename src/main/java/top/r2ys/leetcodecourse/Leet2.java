package top.r2ys.leetcodecourse;

import top.r2ys.common.ListNode;

import java.util.Arrays;

/**
 * @program: leetcode-course
 * @description: 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author: HU
 * @create: 2021-03-04 10:25
 */
public class Leet2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cursor = dummyHead;
        // 进位
        int sum = 0;
        int carry = 0;
        int digit = 0;
        while (l1 != null || l2 != null) {
            int u = l1 != null ? l1.getVal() : 0;
            int d = l2 != null ? l2.getVal() : 0;
            sum = u + d + carry;
            digit = sum % 10;
            carry = sum / 10;

            cursor.setNext(new ListNode(digit));
            cursor = cursor.getNext();
            l1 = l1 != null ? l1.getNext() : null;
            l2 = l2 != null ? l2.getNext() : null;
        }

        if (carry > 0) {
            cursor.setNext(new ListNode(carry));
        }

        return dummyHead.getNext();
    }

    public static void main(String[] args) {
        Leet2 leet2 = new Leet2();

        int[] u = {2, 4, 3};
        ListNode l1 = ListNode.arrayToListNode(u);
        int[] d = {5, 6 ,4};
        ListNode l2 = ListNode.arrayToListNode(d);

        ListNode addedHead = leet2.addTwoNumbers(l1, l2);
        System.out.println(Arrays.toString(addedHead.listNodeToArray()));
    }

}
