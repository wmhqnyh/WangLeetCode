package com.wangmh;

/**
 * ListNode
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printListNode(ListNode node) {
        if (null == node) return;
        while (null != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
