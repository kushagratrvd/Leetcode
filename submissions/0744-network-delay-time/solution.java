class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int[] edge:times){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        int[] visited = new int[n+1];
        Arrays.fill(visited,Integer.MAX_VALUE);
        visited[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,k});
        visited[k] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];
            for(int[] next: adj.get(node)){
                int totalTime = time + next[1];
                if(visited[next[0]] > totalTime){
                    pq.offer(new int[]{totalTime,next[0]});
                    visited[next[0]] = totalTime;
                }
            }
        }
        int max = 0;
        for(int i:visited){
            if(i == Integer.MAX_VALUE) return -1;
            max = Math.max(max,i);
        }
        return max;
    }
}
