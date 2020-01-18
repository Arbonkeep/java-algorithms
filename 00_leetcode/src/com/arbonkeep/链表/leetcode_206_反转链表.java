package com.arbonkeep.链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author arbonkeep
 * @date 2020/1/18 - 17:19
 */
public class leetcode_206_反转链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 递归方式
     * @param head
     * @return
     */
    public ListNode reservseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;//如果head.next为null说明只有一个节点(head)

        ListNode newHead = reservseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
