class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        //set.add(s.charAt(0));
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)) set.add(c);
            else{
                count++;
                set.clear();
                set.add(c);
            }
        }
        return count+1;
    }
}
