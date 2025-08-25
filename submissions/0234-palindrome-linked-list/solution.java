/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        if(head.next.next == null){
            if(head.val == head.next.val) return true;
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        //ListNode temp = slow;
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        ListNode first = head;
        ListNode last = prev;
        while(first != null && last != null){
            if(first.val != last.val) return false;
            first = first.next;
            last = last.next;
        }
        return true;
    }
}
