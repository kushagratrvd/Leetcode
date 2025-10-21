class Solution {
    
    public void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d : dir){
            int x = d[0] + i;
            int y = d[1] + j;
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1 && !visited[x][y]){
                dfs(grid, visited, x, y);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n]; 
        for(int i=0; i<m; i++){
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(grid, visited, i, 0);
            }
        }
        for(int j=0; j<n; j++){
            if(grid[0][j] == 1 && !visited[0][j]){
                dfs(grid, visited, 0, j);
            }
        }
        for(int j=0; j<n; j++){
            if(grid[m-1][j] == 1 && !visited[m-1][j]){
                dfs(grid, visited, m-1, j);
            }
        }
        for(int i=0; i<m; i++){
            if(grid[i][n-1] == 1 && !visited[i][n-1]){
                dfs(grid, visited, i, n-1);
            }
        }
        int count = 0;
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(grid[i][j] == 1){
                    if(!visited[i][j]) count++; 
                } 
            }
        }
        return count;
    }
}
