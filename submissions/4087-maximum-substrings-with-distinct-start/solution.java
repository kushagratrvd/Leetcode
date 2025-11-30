class Solution {
    public int maxDistinct(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                count++;
                set.add(c);
            } 
        }
        return count;
    }
}
