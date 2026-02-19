class Solution {
    public boolean dfs(int[] pathVisited, int[] visited, List<List<Integer>> graph, int node, Deque<Integer> st){
        visited[node] = 1;
        pathVisited[node] = 1;
        List<Integer> relatives = graph.get(node);
        for(int curr : relatives){
            if(pathVisited[curr] == 1){
                return true;
            }
            if(visited[curr] != 1){
                if(dfs(pathVisited,visited,graph,curr,st)) return true;
            }
        }
        pathVisited[node] = 0;
        st.push(node);
        return false;
    }
    public int[] findOrder(int num, int[][] pre) {
        int[] ans = new int[num];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<num; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<pre.length; i++){
            graph.get(pre[i][1]).add(pre[i][0]);
        }
        Deque<Integer> st = new ArrayDeque<>();
        int[] visited = new int[num];
        int[] pathVisited = new int[num];
        for(int i=0; i<num; i++){
            if(visited[i] == 1) continue;
            if(dfs(pathVisited, visited, graph, i, st)) return new int[0];
        }
        int[] res = new int[num];
        int n = st.size();
        for(int i=0; i<n; i++){
            res[i] = st.pop();
        }
        return res;
    }
}
