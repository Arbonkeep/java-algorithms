package com.arbonkeep.链表;

import com.sun.org.apache.regexp.internal.RE;

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

    /**
     * 使用迭代方式实现(非递归)
     * @param head
     * @return
     * 思路：创建一个新节点newHead=null，创建一个临时节点temp=head.next,然后循环依次
     *      head.next = newHead;newHead = head;head = temp;
     */
    public ListNode reservseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }


}
