class Solution {
    public boolean isValid(String s) {

        Stack <Character> stack = new Stack();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if(stack.peek() == '(' && s.charAt(i) !=')'){
                    return false;
                }
                else if(stack.peek() == '{' && s.charAt(i) !='}'){
                    return false;
                }
                else if(stack.peek() == '[' && s.charAt(i) !=']'){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }
}
