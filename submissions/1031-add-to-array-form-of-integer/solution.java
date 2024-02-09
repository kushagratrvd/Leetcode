import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        int carry = k;

        while (i >= 0 || carry > 0) {
            if (i >= 0) {
                carry += num[i];
            }
            result.add(carry % 10);
            carry /= 10;
            i--;
        }
        
        Collections.reverse(result); // Reverse the result to get the correct order
        return result;
    }
}

