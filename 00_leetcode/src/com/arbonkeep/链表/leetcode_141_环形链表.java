package com.arbonkeep.链表;

/**
 * 141：https://leetcode-cn.com/problems/linked-list-cycle/
 * @author arbonkeep
 * @date 2020/1/20 - 10:04
 */
public class leetcode_141_环形链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 环形链表(判断是否有环)
     * @param head
     * @return
     * 思路：使用快慢指针来确定是否有环，如果快指针先到达null说明没有环，如果快慢会相遇，说明有环
     */
    public boolean hasCycle(ListNode head) {
        //只 有环，两个指针不会相遇
        if (head == null || head.next == null) return false;

        //初始两个指针
        ListNode slow = head;//快指针
        ListNode fast = head.next;//慢指针

        while (slow != null && fast != null) {
            //让快慢指针移动(初始两个指针不相等，所以先移动)
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;//两者相遇说明有环，返回true
        }

        return false;

    }

}
