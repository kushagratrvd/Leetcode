class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i=1; i<=n/2; i++){
            String curr = s.substring(0,i);
            int count = 1;
            for(int j=i; j<n; j+=i){
                if(j+i <= n && s.substring(j,j+i).equals(curr)){
                    count++;
                };
            }
            if(count * curr.length() == n) return true;
        }
        return false;
    }
}
