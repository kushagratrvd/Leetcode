class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = new int[][]{{-1, 0},{0, 1},{1,0},{0,-1}};
        q.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        int startColor = image[sr][sc]; 
        while(!q.isEmpty()){
            int[] curr = q.poll();
            image[curr[0]][curr[1]] = color;
            for(int[] d : dir){
                int row = curr[0] + d[0];
                int col = curr[1] + d[1];
                if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || image[row][col] != startColor) continue;
                q.offer(new int[]{row,col});
                visited[row][col] = true;
            }
        }
        return image;
    }
}
