class Solution {
    public int minTimeToType(String word) {
        char initial = 'a'; 
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            char current = word.charAt(i);
            int time = Math.min(Math.abs(current-initial),Math.abs(current-initial-26));
            int time2 = Math.min(time,Math.abs(current-initial+26));
            count = count+time2+1;
            initial = current;
        }
        return count;
    }
}
