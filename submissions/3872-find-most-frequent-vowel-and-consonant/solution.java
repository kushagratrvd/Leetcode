class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> Vowels = new HashMap<>();
        HashMap<Character, Integer> Consonants = new HashMap<>();
        for(char c : "aeiou".toCharArray()){
            Vowels.put(c,0);
        }
        for(char c : "bcdfghjklmnpqrstvwxyz".toCharArray()){
            Consonants.put(c,0);
        }
        int vowMax = 0;
        int consMax = 0;
        for(char c : s.toCharArray()){
            if(Vowels.containsKey(c)){
                int vow = Vowels.get(c);
                vowMax = Math.max(vowMax, vow + 1);
                Vowels.put(c, vow + 1);
            }
            else{
                int cons = Consonants.get(c);
                consMax = Math.max(consMax, cons + 1);
                Consonants.put(c, cons + 1);
            }
        }
        return vowMax + consMax;
    }
}
