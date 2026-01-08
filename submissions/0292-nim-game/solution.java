class Solution {
    public boolean canWinNim(int n) {
        if(n < 4) return true;
        int rem = n % 4 ;
        //if(n-1 % 6 == 1 || n-1 % 6 == 2 || n-1 % )
        if(rem == 0) return false;
        return true;
    }
}
