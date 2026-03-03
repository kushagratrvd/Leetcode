class Solution {
    public boolean dfs(int index, int temp, Boolean[][] set, int[] nums, int sum){
        if(temp == sum) return true;
        if(index >= nums.length || temp > sum) return false;
        
        if(set[index][temp] != null) return set[index][temp];
        
        boolean take = dfs(index+1, temp + nums[index], set, nums, sum);
        boolean notTake = dfs(index+1, temp, set, nums, sum);
        
        return set[index][temp] = take || notTake;
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        
        if(sum % 2 != 0) return false;
        
        sum /= 2;
        
        Boolean[][] set = new Boolean[nums.length][sum + 1];
        
        return dfs(0, 0, set, nums, sum);
    }
}
