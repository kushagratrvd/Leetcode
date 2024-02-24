import java.util.*;

class Solution {
    

    private void rotateMatrix(int[][] mat) {
        int n = mat.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int rotation = 0; rotation < 4; rotation++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            rotateMatrix(mat);
        }
        return false;
    }
}

