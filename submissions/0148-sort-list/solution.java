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
    public ListNode merge(ListNode temp1, ListNode temp2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(temp1 != null && temp2 != null){
            if(temp1.val >= temp2.val){
                temp.next = temp2;
                temp2 = temp2.next;
            }
            else{
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
        if(temp1 != null){
            temp.next = temp1;
        }
        else{
            temp.next = temp2;
        }
        return dummy.next;
    }
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        if(head == null || head.next == null){
            return head;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = middle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left,right);
    }
}
