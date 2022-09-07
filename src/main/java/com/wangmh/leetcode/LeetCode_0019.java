package com.wangmh.leetcode;

import com.wangmh.ListNode;

/**
 *
 */
public class LeetCode_0019 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        Solution_0019 solution_0019 = new Solution_0019();
        ListNode listNodeResult = solution_0019.removeNthFromEnd(listNode, 2);
        listNode.printListNode(listNodeResult);
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
class Solution_0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (n >= 0) {
            first = first.next;
            n--;
        }
        while (null != first) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
