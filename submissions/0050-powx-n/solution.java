class Solution {
    public double myPow(double x, int n) {
        double odd = 1;
        if(n == Integer.MIN_VALUE){
            n = n+1;
            odd = 1/x;
        }
        if(n == 0) return 1;
        boolean flag = false;
        if(n < 0){
            flag = true;
            n*=-1;
        }
        while(n > 1){
            if(n % 2 == 1){
                odd = odd * x;
                n = n-1;
            }
            x = x*x;
            n = n/2;
        }
        if(flag) return 1/(x*odd);
        return x * odd;
    }
}
