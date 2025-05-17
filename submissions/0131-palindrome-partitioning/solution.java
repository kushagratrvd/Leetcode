class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        recursion(ans, s, 0, temp);
        return ans;
    }

    public void recursion(List<List<String>> ans, String s, int ind, List<String> temp){
        if(ind == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(s, ind, i)){
                String str = s.substring(ind,i+1);
                temp.add(str);
                recursion(ans, s, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int ind, int i){
        int start = ind, end = i;
        while(start<=end){
            if(s.charAt(start) != s.charAt(end)) return false;
            end--;
            start++;
        }
        return true;
    }
}
