class Solution {
    public int recursion(int ind, int parent, int sum, int n, int[] dp){
        int left = Math.abs(ind - parent) - 1;
        int right = n - ind;
        int leftcall = 0;
        if(dp[left] != -1) leftcall = dp[left];
        else{
            for(int i=parent+1; i<=parent+left; i++){
                leftcall += recursion(i, ind, sum, ind-1, dp);
            }
            dp[left] = leftcall;
        }
        int rightcall = 0;
        if(dp[right] != -1) rightcall = dp[right];
        else{
            for(int i=ind+1; i<=ind+right; i++){
                rightcall += recursion(i, ind, sum ,n, dp);
            }
            dp[right] = rightcall;
        }
        if(leftcall == 0) return rightcall;
        if(rightcall == 0) return leftcall;
        return leftcall * rightcall;
    }
    public int numTrees(int n) {
        if(n == 1) return 1;
        int total = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        if(n > 1) dp[2] = 2;
        for(int i=1; i<=n; i++){
            total += recursion(i, 0, 0, n, dp);
        }
        return total;
    }
}
