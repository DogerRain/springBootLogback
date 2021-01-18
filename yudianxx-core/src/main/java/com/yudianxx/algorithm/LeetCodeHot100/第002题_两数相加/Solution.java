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

    /**
     * 自定义链表结构
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

//二话不说用链表解决

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;

        int carry = 0;


        while (p != null || q != null) {
            //提取每一位，然后进行赋值相加
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;


            int sum = carry + x + y;

            carry = sum / 10;

            if (carry > 0) {
                head.val = 1;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (q != null) q = q.next;
            if (p != null) p = p.next;


        }


        return head;
    }

    static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode one = l1;
        ListNode two = l2;

        int count = 0; //进位
        ListNode head = new ListNode(0); //头
        ListNode cur = head;

        while (one != null || two != null) {
            int x = one != null ? one.val : 0;
            int y = two != null ? two.val : 0;

            int sum = x + y + count;

            count = sum / 10;


            if (count > 0) {
                head.val = 1;
            }
            head.next = new ListNode(sum % 10);


            if (one != null) {
                one = one.next;
            }
            if (two != null) {
                two = two.next;
            }
        }
        return head.next;

    }

    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        one.next = new ListNode(4);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(5);
        two.next = new ListNode(6);
        two.next.next = new ListNode(4);

        ListNode returnNode = addTwoNumbers(one, two);

        while (returnNode != null) {
            System.out.print(returnNode.val + " ");
            returnNode = returnNode.next;
        }
//        ListNode returnNode2 = addTwoNumbers2(one, two);
//        while (returnNode2 != null) {
//            System.out.print(returnNode2.val + " ");
//            returnNode2 = returnNode2.next;
//        }

    }
}

