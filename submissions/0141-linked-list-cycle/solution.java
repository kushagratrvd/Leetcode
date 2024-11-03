/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode tort = head;
        ListNode rabbit = head.next;
        while(rabbit != null && rabbit.next != null){
            if(tort == rabbit){
                return true;
            }
            tort = tort.next;
            rabbit = rabbit.next.next;
        }
        return false;
        
    }
}
