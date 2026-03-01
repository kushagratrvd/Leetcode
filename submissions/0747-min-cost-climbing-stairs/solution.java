class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int i=2; i<cost.length; i++){
            int jump1 = cost[i] + cost[i-1];
            int jump2 = cost[i] + cost[i-2];
            cost[i] = Math.min(jump1,jump2);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }
}
