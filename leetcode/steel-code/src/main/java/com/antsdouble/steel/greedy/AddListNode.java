package com.antsdouble.steel.greedy;

import com.antsdouble.steel.greedy.commons.ListNode;

/**
 * @author lyy
 * @Deprecated 合并两个有序链表
 * @date 2019/10/17
 */
public class AddListNode {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode return_list = new ListNode(0);
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode tail = return_list;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        if (l1 == null)
            tail.next = l2;
        else if (l2 == null)
            tail.next = l1;
        return return_list.next;
    }
}
