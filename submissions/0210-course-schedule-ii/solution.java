class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N; i++) graph.add(new ArrayList<>());
        int[] ind = new int[N]; 
        for(int[] i:prerequisites){
            graph.get(i[1]).add(i[0]);
            ind[i[0]]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<ind.length; i++){
            if(ind[i]==0) q.offer(i); 
        }
        int[] ans = new int[N];
        int k=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[k++] = curr;
            List<Integer> temp = graph.get(curr);
            for(int i:temp){
                ind[i]--;
                if(ind[i] == 0) q.offer(i);
            }
        }
        if(k != N) return new int[0];
        return ans;      
    }
}
