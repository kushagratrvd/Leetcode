class Solution {
    public boolean doesAliceWin(String s) {
        for(int i=0; i < s.length(); i++){
            int vow = s.charAt(i);
            if (vow == 'a' || vow == 'e' || vow == 'i' || vow == 'o' || vow == 'u') {
                return true;
            }
        }
        return false;
        
    }
}
