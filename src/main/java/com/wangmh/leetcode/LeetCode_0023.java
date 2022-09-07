package com.wangmh.leetcode;

import com.wangmh.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_0023 {


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
class Solution_0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists) return null;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int length = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(length, Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (null != listNode) {
                pq.add(listNode);
            }
        }

//        PriorityQueue<ListNode> pq = new PriorityQueue<>(length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return Integer.compare(o1.val,o2.val);
//            }
//        });

        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            head.next = poll;
            head = head.next;
            if (poll.next != null) {
                pq.add(poll.next);
            }
        }
        return dummy.next;
    }
}
