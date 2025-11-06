class Solution {
    public void dfs(int[][] dist, int[][] grid, int i, int j, int[] dir) {
        for(int o:dir){
            for(int p:dir){
                if(i+o < 0 || j+p < 0 || i+o >= grid.length || j+p >= grid.length || grid[i+o][j+p] == 1) continue;
                if(i+o == i && j+p == j) continue;
                int wt = dist[i][j] + 1;
                if(dist[i+o][j+p] > wt){
                    dist[i+o][j+p] = wt;
                    dfs(dist, grid, i+o, j+p, dir);
                }  
            }
        }
    
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dist[i],1000000);
        dist[0][0] = 0;

        int[][] dir = {{-1,-1},{-1,0},{-1,1},
                        {0,-1},    {0,1},
                        {1,-1},{1,0},{1,1}};
        //dfs(dist, grid, 0, 0, dir);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            for(int[] i:dir){
                int nx = x + i[0];
                int ny = y + i[1];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0 && dist[nx][ny] > dist[x][y] + 1){
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                } 
            }
        }

        if(dist[n-1][n-1] >= 1000000) return -1;
        return dist[n-1][n-1]+1;
    }
}
