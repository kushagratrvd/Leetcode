class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!st.isEmpty()){
                if(s.charAt(i) == ')'){
                    if(st.pop() != '(') return false; 
                    continue;
                } 
                else if(s.charAt(i) == '}'){
                    if(st.pop() != '{') return false; 
                    continue;
                }
                else if(s.charAt(i) == ']'){
                    if(st.pop() != '[') return false; 
                    continue;
                }
            }
            
            st.push(s.charAt(i));
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
