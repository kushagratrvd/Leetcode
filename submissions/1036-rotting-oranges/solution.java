class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int count = 0;
        int o = q.size();
        while(!q.isEmpty()){
            for(int i=0; i<o; i++){
                int[] polled = q.poll();
                
                for(int[] d:dir){
                    int row = polled[0]+d[0];
                    int col = polled[1]+d[1];
                    if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != 1) continue;
                    q.offer(new int[]{row,col});
                    grid[row][col] = 2;
                }
            }
            o = q.size();
            count++;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        if(count == 0) return 0;
        return count-1;
    }
}
