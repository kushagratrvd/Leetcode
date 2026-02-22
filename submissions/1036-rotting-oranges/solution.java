class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int count = 0;
        int size = q.size(); 
        while(!q.isEmpty()){
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                for(int[] d : dir){
                    int nr = d[0] + curr[0];
                    int nc = d[1] + curr[1];
                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr,nc});
                }
            }
            if(!q.isEmpty()) count++;
            size = q.size();
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return count;
    }
}
