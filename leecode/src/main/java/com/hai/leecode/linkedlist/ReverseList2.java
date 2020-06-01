package com.hai.leecode.linkedlist;

/**
 * leecode 92
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hai
 * @date 2020-05-18 15:43
 */
public class ReverseList2 {

    //头插法，引入一个空的头节点，最简单，最容易实现
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumpNode = new ListNode(0);
        dumpNode.next = head;
        ListNode stand = dumpNode, move = head;
        int index = 0;
        while (index < m - 1) {
            stand = stand.next;
            move = move.next;
            index++;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removed = move.next;
            move.next = move.next.next;
            removed.next = stand.next;
            stand.next = removed;

        }

        return dumpNode.next;


    }

    //迭代法
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode cur = head;
        while (m > 1) {
            prev = prev.next;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode first = prev, tail = cur;
        for (int i = n; i > 0; i--) {
            ListNode third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
        }
        if (first.val != 0) {
            first.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode list = head;

        for (int i = 2; i <= 5; i++) {
            list.next = new ListNode(i);
            list = list.next;
        }
        ReverseList2 instance = new ReverseList2();
        ListNode listNode = instance.reverseBetween(head, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;

        }
    }


}
