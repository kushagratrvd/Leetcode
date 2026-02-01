class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target > matrix[m-1][n-1]) return false;
        int low = 0;
        int high = m-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(matrix[mid][n-1] > target) high = mid - 1;
            else if(matrix[mid][n-1] < target) low = mid + 1;
            else return true;
        }
        for(int j = 0; j < n; j++){
            if(matrix[low][j] == target) return true;
        }
        return false;
    }
}
