class Solution {
    public void dfs(int i, int[] visited, int[][] isConnected) {
        visited[i] = 1;
        for(int j=0; j < isConnected[i].length; j++){
            if(isConnected[i][j] == 1 && visited[j] == 0){
                dfs(j, visited, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1 && visited[j] == 0){
                    count++;
                    dfs(j, visited, isConnected);
                } 
            }
        }
        return count;
    }
}
