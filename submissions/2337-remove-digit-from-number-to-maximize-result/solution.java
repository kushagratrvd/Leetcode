import java.util.*;
import java.math.BigInteger;

class Solution {
    public String removeDigit(String number, char digit) {
        ArrayList<BigInteger> arr = new ArrayList<BigInteger>();

        for (int i = 0; i < number.length(); i++) {
            StringBuilder sb = new StringBuilder(number);
            if (sb.charAt(i) == digit) {
                sb.deleteCharAt(i);
                String newStr = sb.toString();
                arr.add(new BigInteger(newStr));
            }
        }

        return Collections.max(arr).toString();
    }
}

