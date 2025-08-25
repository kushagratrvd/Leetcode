/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int flagA = 0;
        int flagB = 0;
        while(tempA != tempB){
            if(tempA == null && flagA == 1) return null;
            if(tempA == null){
                tempA = headB;
                flagA = 1;
            }
            else tempA = tempA.next;
            if(tempB == null && flagB == 1) return null;
            if(tempB == null){
                tempB = headA;
                flagB = 1;
            }
            else tempB = tempB.next;
        }
        return tempA;
    }
}
