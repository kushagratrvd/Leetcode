class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int j=0; j<matrix[0].length; j++){
            int initial = matrix[0][j];
            int row = 1;
            int col = j+1;
            while(row<matrix.length && col<matrix[0].length){
                if(matrix[row][col] != initial) return false;
                row++;
                col++;
            }
        }
        for(int i=1; i<matrix.length; i++){
            int initial = matrix[i][0];
            int row = i+1;
            int col = 1;
            while(row<matrix.length && col<matrix[0].length){
                if(matrix[row][col] != initial) return false;
                row++;
                col++;
            }
        }
        return true;
    }
}
