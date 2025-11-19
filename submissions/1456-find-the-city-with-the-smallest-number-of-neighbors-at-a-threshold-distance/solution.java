class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //matrix
        //flow warshal
        //traverse matrix from last, maintain min which is not 0, <distthreshhold, place it in int[]
        int[][] dist = new int[n][n];
        for(int[] curr : edges){
            int i = curr[0];
            int j = curr[1];
            int wt = curr[2];
            if(wt > distanceThreshold) continue;
            dist[i][j] = wt;
            dist[j][i] = wt;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i !=j && dist[i][j] == 0) dist[i][j] = (int)1e5;
            }
        }

        for(int via = 0; via < n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    int betterPath = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    dist[i][j] = betterPath;
                    dist[j][i] = betterPath;
                }
            }
        }

        int[] min = new int[2];
        min[1] = n+1;
        for(int i=n-1; i>=0; i--){
            int count = 0;
            for(int j=0; j<n; j++){
                int wt = dist[i][j];
                if(wt != 0 && wt <= distanceThreshold){
                    count++;
                }
                if(count > min[1]) break;
            }
            if(count < min[1]){
                min[0] = i;
                min[1] = count;
            }
        }
        return min[0];
    }
}
