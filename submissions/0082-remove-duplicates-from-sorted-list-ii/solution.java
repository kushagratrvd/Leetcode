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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if (head == null || head.next == null) return head;
        while(temp.next != null && temp.val == temp.next.val) {
            while(temp.next != null && temp.val == temp.next.val){
                temp = temp.next;
            }
            head = temp.next;
            temp = head;
            if (head == null || head.next == null) return head;
        }
        ListNode prev = head;
        temp = head.next;
        while(temp != null && temp.next != null){
            while(temp != null && temp.next != null && temp.val == temp.next.val){
                while(temp.next != null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                prev.next = temp.next;
                temp = prev.next;
                if(temp == null) return head;
            }
            prev = prev.next;
            temp = prev.next;
        }
        return head;
    }
}
