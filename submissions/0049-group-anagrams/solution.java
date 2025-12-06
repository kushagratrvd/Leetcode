class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            String curr = strs[i];
            char[] Chars = curr.toCharArray();
            Arrays.sort(Chars);
            String sorted = new String(Chars);

            if(map.containsKey(sorted)){
                ans.get(map.get(sorted)).add(curr);
            }
            else{
                map.put(sorted,ans.size());
                List<String> temp = new ArrayList<>();
                temp.add(curr);
                ans.add(temp);
            }
        }
        return ans;
    }
}
