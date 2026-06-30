class Solution {
    public String reverseWords(String s) {
        String ans = "";
        int i=s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i) == ' ') i--;
            if(i<0) break;
            int j = i;
            while(j>=0 && s.charAt(j) != ' ') j--;
            if(ans.length() > 0) ans += " ";
                String c = s.substring(j+1,i+1);
                //System.out.println(c.length());
                //c.trim();
                ans += c;
                
            i = j;
            
        }
        return ans;
    }
}
