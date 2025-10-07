class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<Integer>());
        }
        boolean[] visited = new boolean[n];
        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> st = new ArrayDeque<>();
        st.add(source);
        visited[source] = true;
        while(!st.isEmpty()){
            int a = st.poll();
            
            for(int i:graph.get(a)){
                if(visited[i]) continue;
                if(i == destination) return true;
                st.add(i);
                visited[i] = true;
            }
        }
        return false;
    }
}
