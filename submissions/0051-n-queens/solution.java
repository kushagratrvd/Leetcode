class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean flag = false;
        for (char[] row : board)
            Arrays.fill(row, '.');
        Queens(ans, 0, n, board);
        return ans;
    }

    public void Queens(List<List<String>> ans, int col, int n, char[][] board){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for (char[] r : board)
                temp.add(new String(r));
            ans.add(temp);
            return;
        }
        for(int row = 0; row<n; row++){
            boolean flag = false;
            //upper diagonal
            if(!flag) {
                for(int i=row, j=col; i>=0 && j>=0; i--,j--){
                    if(board[i][j] == 'Q'){
                        flag = true;
                        break;
                    }
                }
            }
            //lower diagonal
            if(!flag) {
                for(int i=row, j=col; i<n && j>=0; i++,j--){
                    if(board[i][j] == 'Q'){
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                //horizontal
                for(int j=col; j>=0; j--){
                    if(board[row][j] == 'Q'){
                        flag = true;
                        break;
                    }
                }
            }
            

            if(flag){
                continue;
            }
            board[row][col] = 'Q';

            Queens(ans, col+1, n, board);
            board[row][col] = '.';
        }
    }
}
