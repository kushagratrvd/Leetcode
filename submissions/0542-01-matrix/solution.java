class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                if(mat[i][j] == 0) q.offer(new int[]{i,j});
            }
        }
        int[][] visited = new int[m][n];
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int size = q.size();
       // int count = 0;
        while(!q.isEmpty()){
            for(int i=0; i<size; i++){
                int[] polled = q.poll();
                for(int[] d : dir){
                    int row = d[0] + polled[0];
                    int col = d[1] + polled[1];
                    if(row >= 0 && col >= 0 && row < m && col < n && mat[row][col] == 1 && visited[row][col] == 0){
                        mat[row][col] = mat[polled[0]][polled[1]] + 1;
                        q.offer(new int[]{row,col});
                        visited[row][col] = 1;
                        
                    }
                }
            }
            size = q.size();
        }
        return mat;
    }
}
