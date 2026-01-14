class Solution {
    public boolean isPalindrome(int x) {
        int s = 0;
        int prev = x;
        while(x > 0){
            s = s*10 + x%10;
            x /= 10;
        }
        if(s == prev) return true;
        return false;
    }
}
