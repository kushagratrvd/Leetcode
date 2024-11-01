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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 1;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        int mid;
        if(count%2 == 0){
            mid = count/2;
        }else{
            mid = (int)Math.ceil(count/2);
        }
        ListNode temp1 = head;
        for(int i = 1; i <= mid; i++){
            temp1 = temp1.next;
        }
        return temp1;
    }
}
