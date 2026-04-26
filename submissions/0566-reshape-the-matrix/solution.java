class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length*mat[0].length) return mat;
        int[] arr = new int[mat.length * mat[0].length];
        int o = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                arr[o++] = mat[i][j];
            }
        }
        o = 0;
        int[][] newMat = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                newMat[i][j] = arr[o++];
            }
        }
        return newMat;
    }
}
