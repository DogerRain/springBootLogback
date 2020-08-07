package com.yudianxx.algorithm.链表;

/**
 * @author huangyongwen
 * @date 2020/7/10
 * @Description
 */


/*
*
* 输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
* */

public class 删除链表的节点 {


    public ListNode deleteNode(ListNode head, int val) {
        //特殊情况处理，删除的节点是头节点的时候
        if (head.val == val) return head.next;

        ListNode pre = head, cur = head.next;

        //判断是否匹配到值，匹配到了就跳出来了
        while (cur != null && cur.val != val) {
            pre = cur;  //当前值的上一个值
            cur = cur.next;  //next
        }
        //覆盖匹配到的值,把匹配到的值去掉，直接指向下一个值  A->B->C   B 是 cur ，A 是 pre  C 是 cur.next
        pre.next = cur.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(11); //头部
        ListNode head = listNode;  //头部
        ListNode listNode2 = listNode; //先指向第一个，头部
        //初始化链表
        for (int i = 0; i < 10; i++) {
            listNode2.next = new ListNode(i);
            listNode2 = listNode2.next; //此时listNode2指向了末尾
        }

/*        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }*/

        ListNode result = new 删除链表的节点().deleteNode(head, 0);

        //这里是node节点不为空就把节点打印出来
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}
