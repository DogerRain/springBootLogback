package com.yudianxx.algorithm;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    //    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//    输出：7 -> 0 -> 8
//    原因：342 + 465 = 807
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0);
        int cache = 0;

        ListNode l3 = resultList;
        while (l1 != null || l2 != null || cache > 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int l3Val = l1Val + l2Val + cache;
            cache = 0;

            // 判断是否大于 9 大于9 进一位
            if (l3Val > 9) {
                cache = 1;
                l3Val = l3Val - 10;
            }

            l3.next = new ListNode(l3Val);

            l3 = l3.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        return resultList.next;
    }

}
