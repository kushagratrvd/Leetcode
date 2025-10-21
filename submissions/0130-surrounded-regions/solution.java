class Solution {
    public void dfs(char[][] board, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d : dir){
            int x = d[0] + i;
            int y = d[1] + j;
            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'O' && !visited[x][y]){
                dfs(board, visited, x, y);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n]; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i==m-1 || j==n-1) && !visited[i][j]){
                    dfs(board, visited, i, j);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    if(!visited[i][j]) board[i][j] = 'X'; 
                } 
            }
        }

    }
}
