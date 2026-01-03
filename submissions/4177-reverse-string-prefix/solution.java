class Solution {
    public String reversePrefix(String s, int k) {
        String substring1 = s.substring(0,k);
        String substring2 = s.substring(k,s.length());
        StringBuilder temp = new StringBuilder(substring1);
        String ans = temp.reverse().append(substring2).toString();
        return ans;
    }
}
