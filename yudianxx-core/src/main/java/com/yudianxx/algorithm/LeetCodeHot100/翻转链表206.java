package com.yudianxx.algorithm.LeetCodeHot100;

import io.swagger.models.auth.In;

import java.util.Stack;

/**
 * @author huangyongwen
 * @date 2021/1/22
 * @Description
 */


public class 翻转链表206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //next
            ListNode next = curr.next;
            //三个数交换
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {

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

    static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
