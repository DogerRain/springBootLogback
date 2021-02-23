package com.yudianxx.algorithm.链表;

/**
 * @author huangyongwen
 * @date 2020/7/10
 * @Description
 */
public class ListNode {
    //自定义链表结构
    int val;

    ListNode next;   // 下一个链表对象

    //赋值链表的值
    ListNode(int x) {
        val = x;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
