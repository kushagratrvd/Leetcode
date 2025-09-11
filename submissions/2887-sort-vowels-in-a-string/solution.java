class Solution {
    public String sortVowels(String s) {
        String vowelCheck = "AEIOUaeiou";
        ArrayList<Character> vowels = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(vowelCheck.contains(s.charAt(i) + "")){
                vowels.add(s.charAt(i));
            }
        }
        Collections.sort(vowels);
        StringBuilder ans = new StringBuilder(s);
        int ind=0;
        for(int i=0; i<s.length(); i++){
            if(vowelCheck.contains(s.charAt(i) + "")){
                ans.setCharAt(i, vowels.get(ind++));
            }
        }
        return ans.toString();
    }
}
