class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0) q.offer(new int[]{i,j});
                else ans[i][j] = -1;
            }
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] a = q.poll();
            for(int[] d: dir){
                int x = a[0]+d[0];
                int y = a[1]+d[1];
                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                if(ans[x][y] == -1){
                    ans[x][y] = ans[a[0]][a[1]]+1;
                    q.offer(new int[]{x,y});
                }
            }    
        }
        return ans;
    }
}
