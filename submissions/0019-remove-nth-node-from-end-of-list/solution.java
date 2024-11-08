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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            head = null;
            return head;
        }
        int cnt = 0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null){
            if(n <= cnt){
                slow = slow.next;
            }
            fast = fast.next;
            cnt++;
        }
        if(n > cnt){
            head = head.next;
            return head;
        }
        slow.next = slow.next.next;
        
        return head;

        
    }
}
