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
        int row = low;
        low = 0;
        high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(matrix[row][mid] > target) high = mid - 1;
            else if(matrix[row][mid] < target) low = mid + 1;
            else return true;
        }
        return false;
    }
}
