package com.yudianxx.algorithm.LeetCodeHot100.第002题_两数相加;


/**
 * @author huangyongwen
 * @date 2020/1/9
 * @Description
 */
public class Solution {
/*
    leetcode第2题，链表做带进位加法
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)  两个已知链表对象ListNode l1, ListNode l2
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807

    */

//二话不说用链表解决

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;

        int carry = 0;


        while (p != null || q != null) {
            //提取每一位，然后进行赋值相加
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;


            int sum = carry + x + y;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (q != null) q = q.next;
            if (p != null) p =p.next;
        }

        if (carry>0){

        }


        return head.next;
    }
}

/**
 * 自定义链表结构
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}