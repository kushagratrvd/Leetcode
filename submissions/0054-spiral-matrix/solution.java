class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int upw = 0;
        int low = matrix.length-1;
        int rw = matrix[0].length-1;
        int lw = 0;
        List<Integer> list = new ArrayList<>(); 

        while(upw <= low && lw <= rw){
        for(int j=lw; j<=rw ; j++){
            list.add(matrix[upw][j]);
        }
        upw++;

        for(int i=upw; i<=low ; i++){
            list.add(matrix[i][rw]);
        }
        rw--;
            
        if (upw <= low) {
            for(int j=rw; j>=lw ; j--){
                list.add(matrix[low][j]);
            }
            low--;
        }
        if (lw <= rw) {
            for(int i=low; i>=upw ; i--){
                list.add(matrix[i][lw]);
            }
            lw++;
            }
        }
        return list;

    }
    /*public void left_to_right(int[][] matrix,int low, int upw, int lw, int rw, int i, int j, List<Integer> list) {
        
        top_to_bottom(matrix, low, upw, lw, rw, i, j, list);
    }
    public void right_to_left(int[][] matrix,int low, int upw, int lw, int rw, int i, int j, List<Integer> list) {
        
        bottom_to_top(matrix, low, upw, lw, rw, i, j, list);
    }
    public void top_to_bottom(int[][] matrix, int low, int upw, int lw, int rw, int i, int j, List<Integer> list) {
        
        right_to_left(matrix, low, upw, lw, rw, i, j, list);
    }
    public void bottom_to_top(int[][] matrix, int low, int upw, int lw, int rw, int i, int j, List<Integer> list) {
        
        left_to_right(matrix, low, upw, lw, rw, i, j, list);
    }*/

}
