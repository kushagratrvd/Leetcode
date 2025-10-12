class Solution {
    public int longestBalanced(String s) {
        int max = 1;
        for(int i=0; i<s.length(); i++){            
            int[] visited = new int[26];
            visited[s.charAt(i)-'a']++;
            for(int j=i+1; j<s.length(); j++){
                //visited[s.charAt(j)-'a']++;
                int freq = ++visited[s.charAt(j)-'a'];
                int count = 0;
                for(int k=i; k<=j; k++){
                    if(visited[s.charAt(k)-'a'] == freq) count++;
                    else break;
                }
                if(count == j-i+1) max = Math.max(max,count);
            }
            
        }
        return max;
    }
}
