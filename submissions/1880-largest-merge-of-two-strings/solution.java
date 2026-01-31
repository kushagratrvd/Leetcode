class Solution {
    public String largestMerge(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int i=0,j=0;
        StringBuilder a = new StringBuilder();
        while(i<n1 && j<n2){
            if(word1.substring(i).compareTo(word2.substring(j)) > 0){
                a.append(word1.charAt(i));
                i++;
            }
            else{
                a.append(word2.charAt(j));
                j++;
            }
        }
        a.append(word1.substring(i));
        a.append(word2.substring(j));
        return a.toString();
    }
}
