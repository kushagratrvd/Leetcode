class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;
        int[][] arr=new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                arr[i][n-j-1]=image[i][j];
            }
        

        for(int k=0; k<n;k++){
            if (arr[i][k]==0){
                arr[i][k]=1;
            }
            else{
                arr[i][k]=0;
            }
        }
        }
        return arr;
    }
}
