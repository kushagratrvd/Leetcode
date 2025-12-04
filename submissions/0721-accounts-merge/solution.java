class Dsu{
    int[] parent;
    int[] size;
    Dsu(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int UltPar(int x){
        if(parent[x] != x) parent[x] = UltPar(parent[x]);
        return parent[x];
    }

    void UnionBySize(int x, int y){
        int Parx = UltPar(x);
        int Pary = UltPar(y);
        if(Parx == Pary) return;

        if(size[Parx] >= size[Pary]){
            size[Parx] += size[Pary];
            parent[Pary] = Parx;
        }
        else{
            size[Pary] += size[Parx];
            parent[Parx] = Pary;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Dsu ds = new Dsu(n);
        int[] parent = new int[n];
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            List<String> curr = accounts.get(i);
            for(int j=1; j < curr.size(); j++){
                String s = curr.get(j);
                if(map.containsKey(s)){
                    ds.UnionBySize(i,map.get(s));
                }
                else map.put(s,i);
            }
        }

        ArrayList<String>[] merged = new ArrayList[n];
        for(int i=0; i<n; i++) merged[i] = new ArrayList<String>();

        for(Map.Entry<String, Integer> it : map.entrySet()){
            String curr = it.getKey();
            int node = ds.UltPar(it.getValue());
            merged[node].add(curr);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(merged[i].isEmpty()) continue;
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            Collections.sort(merged[i]);
            for (String mail : merged[i]) {
                temp.add(mail);
            }
            ans.add(temp);
        }
        return ans;
    }
}
