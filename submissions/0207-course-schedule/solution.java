class Solution {
    public boolean canFinish(int nums, int[][] pre) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<nums; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[nums];
        for(int i=0; i<pre.length; i++){
            graph.get(pre[i][1]).add(pre[i][0]);
            indegree[pre[i][0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<nums; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> array = graph.get(curr);
            for(int i : array){
                indegree[i]--;
                if(indegree[i] == 0) q.offer(i);
            }
        }
        for(int i=0; i<nums; i++){
            if(indegree[i] == 1) return false;
        }
        return true;
    }
}
