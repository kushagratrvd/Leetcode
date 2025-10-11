class Solution {
    public boolean scoreBalance(String s) {
        for(int i=1; i<s.length(); i++){
            String Left = s.substring(0,i);
            String Right = s.substring(i,s.length());
            int left=0,right=0;
            for(int j=0; j<Left.length(); j++){
                left += Left.charAt(j)-'a'+1;
            }
            for(int j=0; j<Right.length(); j++){
                right += Right.charAt(j)-'a'+1;
            }
            if(left == right) return true;
        }
        return false;
    }
    
}
