class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;
        int minutes = -1;
        int[][] dir = {{0,1},{-1,0},{1,0},{0,-1}};
        while(!q.isEmpty()){
            minutes++;
            int k = q.size();
            for(int i=0; i<k; i++){
                int[] arr = q.poll();
                for(int j=0; j<dir.length; j++){
                    int x = arr[0] + dir[j][0];
                    int y = arr[1] + dir[j][1];
                    if(x<0 || y<0 || x>=grid.length || y >=grid[0].length || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    fresh--;
                    q.offer(new int[]{x,y});
                }
            }
        }
        if(fresh > 0) return -1;
        return minutes;
    }
}
