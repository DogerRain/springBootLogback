package com.yudianxx.algorithm.链表;

/**
 * @author huangyongwen
 * @date 2020/7/8
 * @Description
 */
public class 链表 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        //初始化链表结构， former表示先走的，latter表示后走的
        ListNode former = head, latter = head;
        //前指针先走k 步
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        //
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;

    }

    public static void main(String[] args) {
        链表 lian = new 链表();
        ListNode listNode = new ListNode(1); //listNode指向第一个
        ListNode head = listNode;
        ListNode listNode2 = listNode; //先指向第一个，头部
        //初始化链表
        for (int i = 0; i < 10; i++) {
            head.next = new ListNode(i);
            head = head.next; //此时head指向了末尾
        }
        System.out.println(head.val);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
        System.out.println("----------------");

        ListNode listNode1 = lian.getKthFromEnd(listNode2, 2);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

}
