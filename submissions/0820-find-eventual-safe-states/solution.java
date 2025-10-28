class Solution {
    public boolean dfs(int curr, int[][] graph, boolean[] visited, boolean[] pathVisited,
    int[] flag){
        visited[curr] = true;
        pathVisited[curr] = true;
        int[] list = graph[curr];

        for(int i=0; i<list.length; i++){
            int a = list[i];
            if(!visited[a]){
                if(dfs(a, graph, visited, pathVisited, flag)) return true;
            }
            else if(pathVisited[a]){
                //pathVisited[a] = false;
                //flag[a] = 1;
                return true;
            }
        }
        pathVisited[curr] = false;
        flag[curr] = 2;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        int[] flag = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dfs(i, graph, visited, pathVisited, flag);
            }
        }
        for(int i=0; i<flag.length; i++){
            if(flag[i] == 2) ans.add(i);
        }
        return ans;
    }
}
