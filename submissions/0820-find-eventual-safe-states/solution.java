class Solution {
    public int dfs(int val,int[][] graph,int[] visited,int[] safe){
        visited[val] = 1;
        safe[val] = 1;
        int[] curr = graph[val];
        for(int j : curr){
            if(safe[j] == 1) return -1;
            else if(visited[j] == 1) continue;
            int value = dfs(j, graph,visited,safe);
            if(value == -1) return -1;
        }
        safe[val] = 0;
        return 0;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        //int[] pathVisited = new int[graph.length];
        int[] safe = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(visited[i] == 1) continue;
            dfs(i, graph,visited,safe);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<safe.length; i++){
            if(safe[i] == 0) ans.add(i);
        }
        return ans;
    }
}
