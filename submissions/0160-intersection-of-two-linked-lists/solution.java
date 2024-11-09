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
        if(tempA == null){
            return null;
        }
        if(headA.next == null && headB.next == null && headA == headB){
            return headA;
        }
        while(tempA != tempB){
            if(tempA == null){
                tempA = headB;
                tempB = tempB.next;
            }
            else if(tempB == null){
                tempB = headA;
                tempA = tempA.next;
            }
            else{
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        if(tempA == tempB){
            return tempA;
        }
        return null;
    }
}
