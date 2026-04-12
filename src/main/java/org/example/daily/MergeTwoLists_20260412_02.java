package org.example.daily;
public class MergeTwoLists_20260412_02 {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(0), t = d;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { t.next = l1; l1 = l1.next; }
            else { t.next = l2; l2 = l2.next; }
            t = t.next;
        }
        t.next = (l1 != null) ? l1 : l2;
        return d.next;
    }
}