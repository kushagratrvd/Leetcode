class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer> map2 = new HashMap<>();
        TreeSet<Integer> emptyDays = new TreeSet<>();
        int[] ans = new int[rains.length];
        Arrays.fill(ans,1);
        for(int i=0; i<rains.length; i++){
            if(i+1 < rains.length && rains[i] > 0 && rains[i+1] == rains[i]) return new int[0];
            if(rains[i] != 0){
                if(map2.containsKey(rains[i])){
                    
                    int ind = map2.get(rains[i]);
                    Integer index = emptyDays.higher(ind);
                    if(index == null) return new int[0];

                    ans[index] = rains[i];
                    emptyDays.remove(index);
                    map2.put(rains[i],i);
                    
                    ans[i] = -1;
                } else{
                    ans[i] = -1;
                    map2.put(rains[i],i);
                }
                 
            } else{
                emptyDays.add(i);
            } 
        } 

        return ans;
    }
}
