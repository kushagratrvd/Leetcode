class Solution {
    static class Dsu{
        int[] parent;
        int[] size;

        Dsu(int total){
            parent = new int[total];
            size = new int[total];
            for(int i=0; i<total; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int x){
            if(parent[x] != x){
                return parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }
        void UnionBySize(int a, int b){
            int pa = findParent(a);
            int pb = findParent(b);
            if(pa == pb) return;

            if(size[pa] >= size[pb]){
                parent[pb] = pa;
                size[pa] += size[pb];
            }
            else{
                parent[pa] = pb;
                size[pb] += size[pa];
            }
        }
    } 
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int[] curr:stones){
            maxRow = Math.max(maxRow,curr[0]);
            maxCol = Math.max(maxCol,curr[1]);
        }
        int n = stones.length;
        int offset = maxRow + 1;
        int total = offset + maxCol + 1;
        Dsu dsu = new Dsu(total);
        for(int[] curr:stones){
            dsu.UnionBySize(curr[0],offset+curr[1]);
        }
        int count = 0;
        for (int i = 0; i < total; i++) {
            if (dsu.parent[i] == i && dsu.size[i] > 1) count++;
        }
        return n-count;
    }
}
