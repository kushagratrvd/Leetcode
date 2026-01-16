class Solution {
    public int[][] highestPeak(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        //for(int i=0; i<m; i++) Arrays.fill(ans[i],Integer.MAX_VALUE);
        int[][] visited = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    //mat[i][j] = 0;
                    //visited[i][j] = 1;
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];int col = curr[1];
            for(int[] d : dir){
                int a = row + d[0];
                int b = col + d[1];
                if(a < 0 || b < 0 || a >= m || b >= n) continue;
                if(mat[a][b] == 0){
                    ans[a][b] = ans[row][col] + 1;
                    mat[a][b] = 1;
                    //visited[a][b] = 1;
                    q.offer(new int[]{a,b});
                }
            }
        }
                
        return ans;
    }
}
