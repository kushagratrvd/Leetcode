class Solution {
    public int reverse(int x) {
        boolean flag = false;
        Long n = (long)x;
        if(x < 0){
            flag = true;
            n = (long)x*(-1);
        }
        long ans = 0;
        while(n > 0){
            long rem = n % 10;
            ans = ans * 10 + rem;
            n /= 10; 
        }
        if(ans > (long)Integer.MAX_VALUE) return 0;
        if(flag) return (int)ans*(-1);
        return (int)ans;
    }
}
