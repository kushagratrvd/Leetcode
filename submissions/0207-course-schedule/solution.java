class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int ans = 0;
        Queue<Integer> q = new ArrayDeque<>();
        int[] ind = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            ind[y]++;
            graph.get(x).add(y);
        }
        for(int i=0; i<ind.length; i++){
            if(ind[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int j = q.poll();
            ans++;
            if(ans > numCourses) return false;
            List<Integer> temp = graph.get(j);
            for(int i : temp){
                ind[i]--;
                if(ind[i] == 0) q.offer(i);
            }
        }
        if(ans == numCourses) return true;
        return false;
    }
}
