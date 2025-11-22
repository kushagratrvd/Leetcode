class Solution {
    public int findParent(int[] parent, int x){
        if(x == parent[x]) return x;
        parent[x] = findParent(parent,parent[x]);
        return parent[x];
    }
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        int Extralines = 0;
        for(int[] curr:connections){
            int src = curr[0];
            int dest = curr[1];
            int srcPar = findParent(parent,src);
            int destPar = findParent(parent,dest);
            if(srcPar != destPar){
                if(srcPar == src && destPar == dest) parent[dest] = src;
                else if(srcPar == src && destPar != dest) parent[src] = destPar;
                else if(srcPar != src && destPar == dest) parent[dest] = srcPar;
                else{
                    parent[destPar] = srcPar;
                    parent[dest] = findParent(parent,dest);
                }
            }
            else Extralines++;
        }
        int count = 0;
        for(int i=0; i<parent.length; i++){
            if(parent[i] == i){
                count++;
            }
        }
        if(Extralines < count-1) return -1;
        return count-1;
    }
}
