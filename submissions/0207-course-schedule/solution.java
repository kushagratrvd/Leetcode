class Solution {
    public boolean dfs(int[] visited,int[] pathVisited, List<List<Integer>> graph, int node){
        visited[node] = 1;
        pathVisited[node] = 1;
        for(int j=0; j<graph.get(node).size(); j++){
            int curr = graph.get(node).get(j);
            if(pathVisited[curr] == 1) return true;
            if(visited[curr] == 0){
                if(dfs(visited,pathVisited,graph,curr)) return true;
            } 
            
            //pathVisited[curr] = 0;
        }
        pathVisited[node] = 0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] nums) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<nums.length; i++){
            graph.get(nums[i][1]).add(nums[i][0]);
        }
        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(visited[i] == 1) continue;
            if(dfs(visited,pathVisited,graph,i)) return false;
        }
        return true;
    }
}
