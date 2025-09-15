class Solution {
    public int canBeTypedWords(String text, String o) {
        ArrayList<String> word = new ArrayList<>(Arrays.asList(text.split(" ")));
        Iterator<String> it = word.iterator();
        while(it.hasNext()){
            String temp = it.next();
            for(int i=0; i<o.length(); i++){
                if(temp.indexOf(o.charAt(i)) != -1){
                    it.remove();
                    break;
                }
            }
        }
        return word.size();
    }
}
