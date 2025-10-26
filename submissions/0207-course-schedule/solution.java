class Solution {
    public boolean loop(List<List<Integer>>graph, int node, HashSet<Integer> visited, HashSet<Integer> PathVisited){
        visited.add(node);
        PathVisited.add(node);
        List<Integer> go = graph.get(node);
        for(int k : go){
            if(PathVisited.contains(k)) return false;
            if(!visited.contains(k)){
                if(!loop(graph,k,visited,PathVisited)) return false;
            }
            
        }
        PathVisited.remove(node);
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> PathVisited = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            String a = x + "," + y;
            String b = y + "," + x;
            if (set.contains(b)) return false;
            set.add(a);
            if(x == y) return false;

            graph.get(x).add(y);
        }
        for(int i=0; i<graph.size(); i++){
            if(visited.contains(i)) continue;
            if(!loop(graph,i,visited,PathVisited)) return false; 
        }
        return true;
    }
}
