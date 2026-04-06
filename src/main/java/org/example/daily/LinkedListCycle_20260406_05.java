package org.example.daily;
public class LinkedListCycle_20260406_05 {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }
    public boolean hasCycle(ListNode head) {
        ListNode s = head, f = head;
        while (f != null && f.next != null) {
            s = s.next; f = f.next.next;
            if (s == f) return true;
        }
        return false;
    }
}