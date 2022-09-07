package com.wangmh.leetcode;

import com.wangmh.ListNode;

/**
 * 21. 合并两个有序链表
 */
public class LeetCode_0021 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        Solution_0021 solution_0021 = new Solution_0021();
        ListNode listNode = solution_0021.mergeTwoLists(listNode1, listNode2);
        listNode.printListNode(listNode);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1 && null == list2) return null;
        if (null == list1) return list2;
        if (null == list2) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (null != list1 && null != list2) {
            int value1 = list1.val;
            int value2 = list2.val;
            if (value1 >= value2) {
                head.next = new ListNode(value2);
                list2 = list2.next;
            } else {
                head.next = new ListNode(value1);
                list1 = list1.next;
            }
            head = head.next;
        }
        if (null != list1) {
            head.next = list1;
        }
        if (null != list2) {
            head.next = list2;
        }
        return dummy.next;
    }
}
