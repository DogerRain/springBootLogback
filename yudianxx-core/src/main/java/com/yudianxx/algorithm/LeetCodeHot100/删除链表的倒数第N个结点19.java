package com.yudianxx.algorithm.LeetCodeHot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Administrator
 * @date 2021/2/21 17:07
 * @webSite https://rain.baimuxym.cn
 * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除链表的倒数第N个结点19 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode resultListNode = removeNthFromEnd4(listNode, 5);
        printListNode(resultListNode);

    }

    /**
     *
     * 遍历两次链表，找出链表的长度和位置
     *
     * @param head
     * @param n
     * @return
     */
    static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        ListNode cur = head;

        if (length == 1) {
            return null;
        }
        if (n == length) {
            return cur.next;
        }
        int nowLocation = 1;

        while (cur != null) {
            if (length - nowLocation == n) {
                cur.next = cur.next.next;
                break;
            }
            nowLocation++;
            cur = cur.next;
        }
        return head;
    }

    static int getLength(ListNode listNode) {
        int i = 0;
        while (listNode != null) {
            i++;
            listNode = listNode.next;
        }
        return i;
    }

    /**
     *
     * 官方题解，也是先求长度
     * 一种常用的技巧是添加一个哑节点（dummy node），它的next 指针指向链表的头节点。
     * 这样一来，我们就不需要对头节点进行特殊的判断了。
     *
     *
     * 复杂度分析
     *
     * 时间复杂度：O(L)O(L)，其中 LL 是链表的长度。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * @param head
     * @param n
     * @return
     */
    static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        //此节点前的都是正常遍历，
        //length-n+1 即删除节点前一个
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }


    /**
     * 官方 ，栈
     *
     * 复杂度分析
     *
     * 时间复杂度：O(L)O(L)，其中 LL 是链表的长度。
     *
     * 空间复杂度：O(L)O(L)，其中 LL 是链表的长度。主要为栈的开销
     *
     *
     */
    static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //从后往前，弹出n个栈
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        //全部出栈
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    /**
     *
     * 官方，双指针
     *
     * 复杂度分析
     *
     * 时间复杂度：O(L)O(L)，其中 LL 是链表的长度。
     *
     * 空间复杂度：O(1)O(1)
     *
     */
    static ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy.next;
        ListNode second = dummy;
        //让first先跑n步
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
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
