class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        if(s.length() == 0) return 0;
        if(s.trim().length() == 0) return 1;;
        for(int i=0; i<s.length()-1; i++){
            int[] ans = new int[95];
            ans[s.charAt(i) - ' ']++;
            int count = 1;
            for(int j=i+1; j<s.length(); j++){
                if(ans[s.charAt(j)-' '] == 0){
                    ans[s.charAt(j)-' ']++;
                    count++;
                }
                else{
                    //i=j-1;
                    break;
                } 
            }
            
            max = Math.max(max,count);
        }
        return max;
    }
}
