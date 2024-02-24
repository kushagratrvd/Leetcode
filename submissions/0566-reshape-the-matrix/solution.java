
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[] arr= new int[r*c];
        int k=0;
        int m=mat.length;
        int l=mat[0].length;
        if(r*c!=m*l){
            return mat;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<l; j++, k++){
                arr[k]=mat[i][j];
            }
        }
        int[][] arr1 = new int[r][c];
        int p=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++, p++){
                arr1[i][j]=arr[p];
            }
        }
        return arr1;
    }
}
