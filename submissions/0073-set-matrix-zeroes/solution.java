class Solution {
    public void recursion(int row, int col, int[][] mat, int[][] visited){
        for(int i=row-1; i>=0; i--){
            if(mat[i][col] == 0 && visited[i][col] == 0){
                visited[i][col] = 1;
                recursion(i, col, mat, visited);
            }
            mat[i][col] = 0;
            visited[i][col] = 1;
        }
        for(int i=row+1; i<mat.length; i++){
            if(mat[i][col] == 0 && visited[i][col] == 0){
                visited[i][col] = 1;
                recursion(i, col, mat, visited);
            }
            mat[i][col] = 0;
            visited[i][col] = 1;
        }
        for(int j=col-1; j>=0; j--){
            if(mat[row][j] == 0 && visited[row][j] == 0){
                visited[row][j] = 1;
                recursion(row, j, mat, visited);
            }
            mat[row][j] = 0;
            visited[row][j] = 1;
        }
        for(int j=col+1; j<mat[0].length; j++){
            if(mat[row][j] == 0 && visited[row][j] == 0){
                visited[row][j] = 1;
                recursion(row, j, mat, visited);
            }
            mat[row][j] = 0;
            visited[row][j] = 1;
        }
    }
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0 && visited[i][j] == 0){
                    visited[i][j] = 1;
                    recursion(i, j, mat, visited);
                }
            }
        }
        
    }
}
