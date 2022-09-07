package com.wangmh.leetcode;

import com.wangmh.ListNode;

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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) return null;
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while (null != l1 || null != l2 || carry != 0) {
            int value1 = null == l1 ? 0 : l1.val;
            int value2 = null == l2 ? 0 : l2.val;
            int value = value1 + value2 + carry;
            carry = value / 10;
            head.next = new ListNode(value % 10);
            head = head.next;

            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}

public class LeetCode_0002 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        listNode.printListNode(listNode);
    }

}
