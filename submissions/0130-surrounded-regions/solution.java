class Solution {
    public void dfs(int row, int col, int[][] visited, char[][] board){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'X' || visited[row][col] == 1) return;
        visited[row][col] = 1;
        dfs(row+1,col,visited,board);
        dfs(row-1,col,visited,board);
        dfs(row,col+1,visited,board);
        dfs(row,col-1,visited,board);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O' && visited[0][j] != 1){
                //visited[0][j] = 1;
                dfs(0,j,visited,board);
            }
        }
        for(int j=0; j<n; j++){
            if(board[m-1][j] == 'O' && visited[m-1][j] != 1){
                //visited[m-1][j] = 1;
                dfs(m-1,j,visited,board);
            }
        }
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O' && visited[i][0] != 1){
                //visited[i][0] = 1;
                dfs(i,0,visited,board);
            }
        }
        for(int i=0; i<m; i++){
            if(board[i][n-1] == 'O' && visited[i][n-1] != 1){
                //visited[i][n-1] = 1;
                dfs(i,n-1,visited,board);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
