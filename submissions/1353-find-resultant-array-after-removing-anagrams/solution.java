class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=0; i<words.length-1; i++){
            int[] visited = new int[26];
            String curr = ans.get(ans.size()-1);
            for(int j=0; j<curr.length(); j++){
                visited[curr.charAt(j) - 'a']++;
            }
            boolean flag = false;
            for(int k=i+1; k<words.length; k++){
                if(words[k].length() != curr.length()){
                    ans.add(words[k]);
                    i=k-1;
                    break;
                }
                String next = words[k];
                int[] visited2 = new int[26];
                for(int j=0; j<next.length(); j++){
                    visited2[next.charAt(j) - 'a']++;
                }
                int count = 0;
                for(int j=0; j<26; j++){
                    if(visited[j] != visited2[j]){
                        ans.add(next);
                        flag = true;
                        i=k-1;
                        break;
                    } 
                    if(visited[j] == visited2[j]) count+=visited[j];
                    if(count == next.length()) break;
                }
                if(flag) break;
            }
            
        }
        return ans;
    }
}
