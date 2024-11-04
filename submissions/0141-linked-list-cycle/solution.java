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
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> node = new HashMap<>();
        ListNode temp = head;

        while(temp != null){
            if(node.containsKey(temp)){
                return true;
            }
            node.put(temp,1);
            temp = temp.next;
            
        }
        return false;  
    }
}
