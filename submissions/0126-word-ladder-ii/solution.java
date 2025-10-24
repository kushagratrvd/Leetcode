class Solution {
    public void dfs(String begin, String curr,List<List<String>> ans,List<String> temp,HashMap<String,Integer> set){
        if(curr.equals(begin)){
            List<String> arr = new ArrayList<>(temp);
            Collections.reverse(arr);
            ans.add(arr);
            return;
        }
        int steps = set.get(curr);
        for(int i=0; i<curr.length(); i++){
            for (char c = 'a'; c <= 'z'; c++) {
                String g = curr.substring(0,i) + c + curr.substring(i+1);
                if(set.containsKey(g) && set.get(g) == steps-1){
                    temp.add(g);
                    dfs(begin,g,ans,temp,set);
                    temp.remove(g);
                }
            }
        }
    }
    public List<List<String>> findLadders(String begin, String end, List<String> words) {
        HashMap<String,Integer> set = new HashMap<>();
        HashSet<String> map = new HashSet<>();
        for(String s : words) map.add(s);
        List<List<String>> ans = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(begin);
        set.put(begin,1);
        map.remove(begin);
        while(!q.isEmpty()){
            String p = q.poll();
            int steps = set.get(p);
            if(p.equals(end)) break;
            for(int i=0; i<p.length(); i++){
                for (char c = 'a'; c <= 'z'; c++) {
                    String g = p.substring(0,i) + c + p.substring(i+1);
                    if(map.contains(g)){
                        if(g.equals(end)){
                            q.offer(g);
                            set.put(g,steps+1);
                            map.remove(g);
                            break;
                        }
                        q.offer(g);
                        set.put(g,steps+1);
                        map.remove(g);
                    }
                }
            }
        }
        if(set.containsKey(end)){
            List<String> temp = new ArrayList<>();
            temp.add(end);
            dfs(begin,end,ans,temp,set);
        }
        return ans;        
    }
}
