package com.yudianxx.algorithm.LeetCodeHot100;

/**
 * @author huangyongwen
 * @date 2021/2/8
 * @Description
 */

/**
 * pA:1->2->3->4->5->6->null->9->5->6->null
 * pB:9->5->6->null->1->2->3->4->5->6->null
 */
public class 相交链表160 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(1);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(4);
        l2.next.next.next.next.next = new ListNode(5);

        ListNode resultList = getIntersectionNode(l1, l2);

        printListNode(resultList);


    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pB;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
