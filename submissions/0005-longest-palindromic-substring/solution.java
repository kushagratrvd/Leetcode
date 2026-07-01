class Solution {
    public boolean helper(String p, int i, int j, boolean[][] dp){
        //System.out.println("i: "+ i + " j: " + j);
        if(i>=j) return true;
        if(i<0 || j < 0 || i >= p.length() || j >= p.length()) return false;
        int m = i;
        int n = j;
        if(p.charAt(m) == p.charAt(n)){
            //System.out.println("m: "+ m);
            //System.out.println("n: "+ n);
            if(dp[m][n]) return true;
            if(helper(p, ++m, --n, dp)){
                //System.out.println(p.substring(m, n+1));
                dp[m][n] = true;
                return true;
            }
        }
        return false;
    }
    public String longestPalindrome(String s) {
        //if(s.length() == 1) return s;
        int max = 1;
        String ans = new String();
        ans = String.valueOf(s.charAt(0));
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length()-1; i++){
            for(int j=i+1; j<s.length(); j++){
                if(i==j) dp[i][j] = true;
                if(j-i+1 < max) continue;
                String sub = s.substring(i,j+1);
                //System.out.println(sub);
                boolean val = helper(s, i, j, dp);
                //System.out.println(val);
                if(val && sub.length() > max){
                    ans = sub;
                    max = Math.max(max, sub.length());
                }
            }
        }
        return ans;
    }
}
