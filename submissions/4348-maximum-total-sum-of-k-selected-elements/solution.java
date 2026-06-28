class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        long totalSum = 0;
        Arrays.sort(nums);
        int[] chosen = new int[k];
        int j=0;
        for(int i=nums.length-1; i>=0 && j<k; i--){
            chosen[j++] =  nums[i];
        }

        for(int i=0; i<k; i++){
            if(mul > 0){
                long ch = chosen[i];
                long sum = ch * mul;
                mul--;
                totalSum += sum;
            }
            else totalSum += chosen[i];
        }
        return totalSum;
    }
}
