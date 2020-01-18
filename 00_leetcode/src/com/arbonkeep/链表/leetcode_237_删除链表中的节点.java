package com.arbonkeep.链表;

/**
 * 237：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author arbonkeep
 * @date 2020/1/18 - 17:07
 */
public class leetcode_237_删除链表中的节点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 思路：用后面的节点的val将该节点的val覆盖,然后将用于覆盖的节点删除即可
     * @param node
     */
    public void deleteNode(ListNode node) {//传入什么就删除什么
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
