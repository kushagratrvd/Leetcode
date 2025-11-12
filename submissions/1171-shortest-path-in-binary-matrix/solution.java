class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dist[i],1000000);
        dist[0][0] = 0;

        int[][] dir = {{-1,-1},{-1,0},{-1,1},
                        {0,-1},    {0,1},
                        {1,-1},{1,0},{1,1}};
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
                    if(nx == n-1 && ny == n-1) return dist[nx][ny]+1;
                    q.offer(new int[]{nx,ny});
                } 
            }
        }

        if(dist[n-1][n-1] >= 1000000) return -1;
        return dist[n-1][n-1]+1;
    }
}
