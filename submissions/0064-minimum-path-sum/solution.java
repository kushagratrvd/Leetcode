class Solution {
    public void dfs(int i, int j, int[][] dp, int[][] grid, int prev){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(dp[i][j] == 0){
            dp[i][j] = grid[i][j] + prev;
            dfs(i+1,j,dp,grid,dp[i][j]);
            dfs(i,j+1,dp,grid,dp[i][j]);
        }
        else if(grid[i][j] + prev < dp[i][j]){
            dp[i][j] = grid[i][j] + prev;
            dfs(i+1,j,dp,grid,dp[i][j]);
            dfs(i,j+1,dp,grid,dp[i][j]);
        }
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        dfs(0, 1, dp, grid, grid[0][0]);
        dfs(1, 0, dp, grid, grid[0][0]);
        return dp[m-1][n-1];
    }
}
