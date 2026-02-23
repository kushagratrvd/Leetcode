class Solution {
    public void dfs(int row, int col, int[][] visited, int[][] grid, int[] count, int zero, int negative){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == 1 || grid[row][col] == -1) return;
        if(grid[row][col] != 2){
            visited[row][col] = 1;
            zero++;
        }
        else{
            if(zero + negative + 1 == grid.length*grid[0].length) count[0]++;
            return;
        }
        dfs(row+1,col,visited,grid,count,zero,negative);
        dfs(row-1,col,visited,grid,count,zero,negative);
        dfs(row,col+1,visited,grid,count,zero,negative);
        dfs(row,col-1,visited,grid,count,zero,negative);
        visited[row][col] = 0;
        zero--;
    }
    public int uniquePathsIII(int[][] grid) {
        int[] count = new int[]{0};
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int negative = 0;
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == -1){
                    negative++;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    dfs(i,j,visited,grid,count,0,negative);
                    return count[0];
                }
            }
        }
        return 0;
    }
}
