class Solution {
    class Pair{
        String x;
        int y;
        Pair(String x, int y){
            this.x = x;
            this.y = y;
        }
    }
    /*public boolean checkDiff(String a, String b){
        if(a.length() != b.length()) return false;
        int c = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) == b.charAt(i)){
                c++;
                if(c >= a.length()) return false;
            }
        }
        if(c == a.length()-1) return true;
        return false;
    }*/
    public int ladderLength(String begin, String end, List<String> words) {
        //HashSet<String> set = new HashSet<>();
        HashSet<String> map = new HashSet<>();
        for(String s : words) map.add(s);
        map.add(begin);
        //int[] visited = new int[words.size()];
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(begin,1));
        int min = 0;
        //int count = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.x;
            int y = p.y;
            String a = s.substring(1);
            for (int i = 0; i < s.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String g = s.substring(0, i) + c + s.substring(i + 1);
                    if (map.contains(g)) {
                        if (g.equals(end)) return y + 1;
                        q.offer(new Pair(g, y + 1));
                        map.remove(g);
                    }
                }
            }
            /*for(char c : abc){
                String a = words.get(i);
                if(!set.contains(a) && check(s,a)){
                    if(a.equals(end)){
                        min = Math.min(y+1,min);
                        break;
                    }
                    q.offer(new Pair(a,y+1));
                    set.add(a);
                }
            }*/
        }
        //if(min == 6000) return 0;
        //min = Math.min(count,min);
        return min;
    }
}
