class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        int right = 1;
        int max = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(left));
        while(right < s.length() && left < right){
            if(set.contains(s.charAt(right))){
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            
            set.add(s.charAt(right));
            right++;
            max = Math.max(max,set.size());
            
        }
        max = Math.max(max,set.size());
        return max;
    }
}
