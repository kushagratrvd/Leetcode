class Solution {
    public void bfs(int[][] grid, int row, int col, int[][] visited){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == 1 || grid[row][col] == 0) return;
        visited[row][col] = 1;
        bfs(grid,row+1,col,visited);
        bfs(grid,row,col+1,visited);
        bfs(grid,row-1,col,visited);
        bfs(grid,row,col-1,visited);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for(int i=0; i<n; i++){
            if(visited[0][i] == 1 || grid[0][i] == 0) continue;
            //visited[0][i] = 1;
            bfs(grid,0,i,visited);
        }
        for(int i=0; i<n; i++){
            if(visited[m-1][i] == 1 || grid[m-1][i] == 0) continue;
            //visited[m-1][i] = 1;
            bfs(grid,m-1,i,visited);
        }
        for(int j=0; j<m; j++){
            if(visited[j][0] == 1 || grid[j][0] == 0) continue;
            //visited[j][0] = 1;
            bfs(grid,j,0,visited);
        }
        for(int j=0; j<m; j++){
            if(visited[j][n-1] == 1 || grid[j][n-1] == 0) continue;
            //visited[j][n-1] = 1;
            bfs(grid,j,n-1,visited);
        }
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
