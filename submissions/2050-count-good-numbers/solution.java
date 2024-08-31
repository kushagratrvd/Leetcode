class Solution {
    private static final int MOD = 1_000_000_007; 

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2; 
        long odd = n / 2;        

        long powerOf5 = modExp(5, even, MOD);
        long powerOf4 = modExp(4, odd, MOD);

        return (int) ((powerOf5 * powerOf4) % MOD);
    }

    private long modExp(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) { 
                result = (result * base) % mod;
            }
            base = (base * base) % mod; 
            exp >>= 1; 
        }
        return result;
    }
}

