class Solution {
    public boolean isPrime(int x){
        for(int i = 2; i * i <= x; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(isPrime(curr)) continue;
            for(int j=2; j*j <= curr; j++){
                if(isPrime(j) && curr % j == 0){
                    int qoutient = curr/j;
                    if(j != qoutient && isPrime(qoutient) || qoutient == j*j){
                        sum += 1 + j + qoutient + curr;
                    }
                    else break;
                }
            }
        }
        return sum;
    }
}
