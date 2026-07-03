class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s = "";
        int min = 201;
        for(String curr : strs){
            if(curr.length() < min){
                s = curr;
                min = curr.length();
            }
        }
        int i=0;
        for(i=0; i<s.length(); i++){
            for(int j=0; j<strs.length; j++){
                if(s.charAt(i) != strs[j].charAt(i)) return s.substring(0, i);
            }
        }
        return s.substring(0, i);
    }
}
