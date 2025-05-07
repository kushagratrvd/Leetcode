class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        StringBuilder temp = new StringBuilder();
        
        List<String> arr = new ArrayList<>();
        if (digits.isEmpty()) return arr;

        Combinations(digits, map, 0, temp, arr);

        return arr;
    }

    public void Combinations(String digits, HashMap<String, String> map, int j, StringBuilder temp, List<String> arr) {
        if(temp.length() == digits.length()){
            arr.add(temp.toString());
            return;
        }

        String s = map.get(String.valueOf(digits.charAt(j)));
        for(int i=0; i<s.length(); i++){
            temp.append(s.charAt(i));
            Combinations(digits, map, j+1, temp, arr);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
