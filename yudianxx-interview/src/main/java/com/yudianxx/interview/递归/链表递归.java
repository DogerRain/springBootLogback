package com.yudianxx.interview.递归;

/**
 * @author huangyongwen
 * @date 2021/1/19
 * @Description
 */
public class 链表递归 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 递归终止条件
        if (head == null) {
            return null;
        }

        // 调用方法removeElements将当前结点之后的链表部分中的
        // 和val值相等的结点删除
        ListNode result = removeElements(head.next, val);

        // 如果当前结点head的值等于val则返回result
        if (head.val == val) {
            return result;
        } else {
            // 如果当前结点head的值不等于val则
            // 将result挂在当前结点head之后返回
            head.next = result;
            return head;
        }
    }
}
