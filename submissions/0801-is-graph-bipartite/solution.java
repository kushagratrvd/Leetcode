class Solution {
    public boolean dfs(int[][] graph, int[] map, int curr){
        int c = map[curr];
        for(int i : graph[curr]){
            if(map[i] != 0){
                if(map[i] == c) return false;
            }
            else{
                if(c == 1) map[i] = 2;
                else map[i] = 1;
                if(!dfs(graph,map,i)) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] map = new int[graph.length];
        for(int i=0; i<map.length; i++){
            
            if(map[i] == 0){
                map[i] = 1;
                if(!dfs(graph,map,i)) return false;
            }  
        }
        
        return true;
    }
}
