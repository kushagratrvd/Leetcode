class Solution {
    public void dfs(int curr,boolean[] visited, int[][] mat, int n){
        visited[curr] = true;
        for(int i=0; i<n; i++){
            if(mat[curr][i] == 1 && !visited[i]){
                dfs(i,visited,mat,n);
            }
        }
    }
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[j]){
                    dfs(j,visited,mat,n);
                    count++;
                }
            }
        }
        return count;
    }
}
