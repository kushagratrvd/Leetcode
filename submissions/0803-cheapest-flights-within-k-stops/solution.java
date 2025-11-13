class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        } 
        for(int[] j:flights){
            adj.get(j[0]).add(new int[]{j[1],j[2]});
        }
        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        Queue<int[]> pq = new ArrayDeque<>();
        pq.offer(new int[]{0,src,0});
        cost[src] = 0;
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int c = polled[0];
            int node = polled[1];
            int count = polled[2];
            //if(node == dst && (count <=k+1)) return c;
            if(count > k) continue;
            for(int[] flight:adj.get(node)){
                int a = flight[0];
                int b = flight[1];
                if(cost[a] > b+c){
                    pq.offer(new int[]{b+c,a,count+1});
                    cost[a] = b+c;
                }
            }
        }

        if(cost[dst] < Integer.MAX_VALUE) return cost[dst];
        return -1;
    }
}
