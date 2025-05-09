class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(recursion(i, j, board, word, 1, visited)) return true; 
                }
            }
        }
        return false;
    }

    public boolean recursion(int i, int j, char[][] board, String word, int ind, boolean[][] visited){
        if(ind == word.length()){
            return true;
        }
        visited[i][j] = true;
        if(j+1 < board[0].length && board[i][j+1] == word.charAt(ind) && !visited[i][j+1]){
            
                if(recursion(i, j+1, board, word, ind+1, visited)) return true;
            
        }

        if(j-1 >= 0 && board[i][j-1] == word.charAt(ind) && !visited[i][j-1]){
                if(recursion(i, j-1, board, word, ind+1, visited)) return true;
            
        }

        if(i+1 < board.length && board[i+1][j] == word.charAt(ind) && !visited[i+1][j]){
                if(recursion(i+1, j, board, word, ind+1, visited)) return true;
            
        }

        if(i-1 >= 0 && board[i-1][j] == word.charAt(ind) && !visited[i-1][j]){
            if(recursion(i-1, j, board, word, ind+1, visited)) return true;
            
        }
        visited[i][j] = false;
        return false;
    }
}
