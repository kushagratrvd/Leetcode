class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        int level = 0;
        boolean[] visited = new boolean[n+1];
        visited[n] = true;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0; i<size; i++){
                int curr = q.poll();
                for(int j=1; j*j<=curr; j++){
                    int next = curr - j*j;
                    if(next == 0) return level;
                    if(!visited[next]) q.offer(next);
                }
            }
        }
        return level;
    }
}
