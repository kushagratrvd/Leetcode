class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder o = new StringBuilder();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        List<Character> keys = new ArrayList(map.keySet());
        keys.sort((ob1,ob2) -> map.get(ob2) - map.get(ob1));// sorting in dec order

        for(char c: keys){
            for(int j=0; j < map.get(c); j++){
                o.append(c);
            }
        }
        return o.toString();
    }
}
