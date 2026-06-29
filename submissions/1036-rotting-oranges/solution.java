class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }
        int[][] dir = new int[][]{{-1,0}, {1, 0}, {0, 1}, {0,-1}};
        int count = 0;
        while(!q.isEmpty()){
            int s = q.size();
            count++;
            for(int i=0; i<s; i++){
                int[] curr = q.poll();
                for(int[] d:dir){
                    int a=d[0] + curr[0];
                    int b = d[1] + curr[1];
                    if(a >=0 && b >= 0 && a < m && b < n && visited[a][b] != 1 && grid[a][b] != 0){
                        visited[a][b] = 1;
                        q.offer(new int[]{a,b});
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == 0 && grid[i][j] != 0) return -1;
            }
        }
        if(count == 0) return 0;
        return count-1;
    }
}
