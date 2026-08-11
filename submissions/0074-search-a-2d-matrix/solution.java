class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        int m = matrix.length;
        int n = matrix[0].length;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(matrix[mid][n-1] == target) return true;
            else if(matrix[mid][n-1] > target) high = mid;
            else low = mid+1;
        }
        int row = low;
        low = 0;
        high = n-1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target) high = mid;
            else low = mid+1;
        }
        if(matrix[row][low] == target) return true;
        return false;
    }
}
