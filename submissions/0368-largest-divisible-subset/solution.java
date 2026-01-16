class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = 0;
        int maxIndex = 0;
        int[] dp = new int[n+1];
        int[] parent = new int[n+1];
        int prevIndex = 0;
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                    if(dp[i] > max){
                        max = dp[i];
                        maxIndex = i;
                    }
                    
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(maxIndex != -1){
            ans.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        return ans;
    }
}
