class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j=0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                while(true){
                    if(s.charAt(j) == s.charAt(i)){
                        //set.remove(s.charAt(j));
                        j = j+1;
                        break;
                    }
                    set.remove(s.charAt(j));
                    j++;
                }
                continue;
            }
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
