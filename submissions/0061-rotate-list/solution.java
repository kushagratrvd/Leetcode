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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode temp = head;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        count++;
        if(count == k) return head;
        temp.next=head;
        temp = head;
        int c = count - (k%count)-1;
        while(c>0){
            temp = temp.next;
            c--;
        }
        head = temp.next;
        temp.next = null;
        return head;
        
    }
}
