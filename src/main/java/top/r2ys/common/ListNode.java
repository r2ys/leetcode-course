package top.r2ys.common;

/**
 * @program: leetcode-course
 * @description:
 * @author: HU
 * @create: 2021-03-04 10:37
 */
public class ListNode {

    private int val;

    private ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    //数组转换成链表
    public static ListNode arrayToListNode(int[] s) {
        ListNode root = new ListNode(s[0]);//生成链表的根节点，并将数组的第一个元素的值赋给链表的根节点
        ListNode cursor = root;//生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针
        for (int i = 1; i < s.length; i++) {//由于已给root赋值，所以i从1开始
            ListNode temp = new ListNode(s[i]);//每循环一次生成一个新的节点,并给当前节点赋值
            cursor.next = temp;//将other的下一个节点指向生成的新的节点
            cursor = temp;//将other指向最后一个节点(other的下一个节点)  other=other.getNext();
        }
        return root;
    }

    //将链表转换成数组
    public int[] listNodeToArray() {
        ListNode counter = this;
        int size = 0;
        while (counter != null) {
            size++;
            counter = counter.next;
        }

        ListNode cursor = this;
        int[] arr = new int[size];
        int index = 0;
        while (cursor != null) {
            arr[index] = cursor.val;
            cursor = cursor.next;
            index++;
        }
        return arr;
    }

}
