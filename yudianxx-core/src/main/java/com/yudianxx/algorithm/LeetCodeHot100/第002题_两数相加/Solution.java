package com.yudianxx.algorithm.LeetCodeHot100.第002题_两数相加;


/**
 * @author huangyongwen
 * @date 2020/1/9
 * @Description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        return null;
    }

    static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode one = l1;
        ListNode two = l2;

        int count = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (one != null || two != null) {
            int x = one != null ? one.val : 0;
            int y = two != null ? two.val : 0;

            int sum = x + y + count;

            count = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;


            if (one != null) {
                one = one.next;
            }
            if (two != null) {
                two = two.next;
            }
        }
        //末位进1
        if (count > 0) {
            cur.next = new ListNode(1);
        }
//去掉 首位的 0
        return head.next;

    }

    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        one.next = new ListNode(8);
        one.next.next = new ListNode(9);

        ListNode two = new ListNode(8);
        two.next = new ListNode(3);
        two.next.next = new ListNode(1);

        ListNode returnNode = addTwoNumbers(one, two);

//        while (returnNode != null) {
//            System.out.print(returnNode.val + " ");
//            returnNode = returnNode.next;
//        }
        ListNode returnNode2 = addTwoNumbers2(one, two);
        while (returnNode2 != null) {
            System.out.print(returnNode2.val + " ");
            returnNode2 = returnNode2.next;
        }
    }
}

