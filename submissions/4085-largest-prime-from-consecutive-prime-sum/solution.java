class Solution {
    public boolean isPrime(int x){
        for(int i=2; i*i <= x; i++){
            if(x%i == 0) return false;
        }
        return true;
    }
    public int largestPrime(int n) {
        //HashSet<Integer> set = new HashSet<>();
        //set.add(2);
        //set.add(5);
        int sum = 10;
        int ans = 0;
        for(int i=7; sum+i<=n; i=i+2){
            if(isPrime(i)){
                sum = sum + i;
                if(isPrime(sum)){ 
                    ans = sum;
                }
            }
        }
        
        if(n < 2) return 0;
        if(n < 5) return 2;
        if(n < 17) return 5;
        return ans;
    }
}
