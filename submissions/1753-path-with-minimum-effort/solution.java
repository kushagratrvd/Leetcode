class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int mineffort = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[][] effort = new int[heights.length][heights[0].length];
        for(int i=0; i<heights.length; i++) Arrays.fill(effort[i],Integer.MAX_VALUE);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int e = polled[0];
            int x = polled[1];
            int y = polled[2];
            if(x == heights.length-1 && y == heights[0].length-1) return e;
            for(int[] d: dir){
                int nx = d[0] + x;
                int ny = d[1] + y;
                if(nx >= 0 && ny >= 0 && nx < heights.length && ny < heights[0].length && effort[nx][ny] > e){
                    int diff = Math.abs(heights[x][y]-heights[nx][ny]);
                    int maxdiff = Math.max(e,diff);
                    effort[nx][ny] = maxdiff;
                    pq.offer(new int[]{maxdiff,nx,ny});
                }
            }
        }

        return 0;
    }
}
