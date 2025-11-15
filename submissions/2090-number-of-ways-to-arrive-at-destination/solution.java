class Solution {
    static final long MOD = 1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge:roads){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        long[] duration = new long[n];
        long[] ways = new long[n];
        Arrays.fill(duration,Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0,0});
        duration[0] = 0;
        ways[0] = 1;
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int)curr[1];
            if(time > duration[node]) continue;
            for(int[] next: adj.get(node)){
                long totalTime = ((time + next[1]));
                if(duration[next[0]] > totalTime){
                    //if(ways[next[0]] = )
                    ways[next[0]] = ways[node];
                    duration[next[0]] = totalTime;
                    if(next[0] == n-1) continue;
                    pq.offer(new long[]{totalTime,(long)next[0]});
                }
                else if(duration[next[0]] == totalTime){
                    ways[next[0]] = (ways[next[0]] + ways[node])%MOD;
                }
            }
        }
        return (int)ways[n-1];
    }
}
