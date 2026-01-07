class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] store = new int[26];
        for(int i=0; i<tasks.length; i++){
            store[tasks[i]-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y-x);
        for(int i=0; i<26; i++){
            if(store[i] > 0) pq.offer(store[i]);
        }
        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            if(!pq.isEmpty()){
                int curr = pq.poll();
                if(curr-1 > 0) q.offer(new int[]{curr - 1, time + n});
            }
            if(!q.isEmpty()){
                int[] check = q.peek();
                if(check[1] == time){
                    int[] reenter = q.poll();
                    pq.offer(reenter[0]);
                }
            }
        
            time++;
        }
        return time;
    }
}
