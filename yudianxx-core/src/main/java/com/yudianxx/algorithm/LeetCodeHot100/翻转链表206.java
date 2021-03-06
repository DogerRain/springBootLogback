package com.yudianxx.algorithm.LeetCodeHot100;

import java.util.Stack;

/**
 * @author huangyongwen
 * @date 2021/1/22
 * @Description
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


public class 翻转链表206 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        printListNode(listNode);
        System.out.println();
        printListNode(reverseList(listNode));
        System.out.println();
//        printListNode(reverseList2(listNode));
    }

    /**
     * 官方答案1 ， 双指针
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; //新链表
        ListNode curr = head; //指向表头
        while (curr != null) {
            //next
            ListNode next = curr.next; //暂存起来下一个
            //三个数交换
            curr.next = prev; //指向左侧，不再指向右侧（翻转）
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 用栈、或者List 实现
     * @param head
     * @return
     */
    public static ListNode reverseList3(ListNode head) {

        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode newListNode = new ListNode(0);
        ListNode cur = newListNode;
        while (!stack.empty()) {
            Integer i = stack.pop();
            newListNode.next = new ListNode(i);
            newListNode = newListNode.next;
        }
        return cur.next;
    }

    /**
     * 打印链表
     * @param head
     */
    static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
