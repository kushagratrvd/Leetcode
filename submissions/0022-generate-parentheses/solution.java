class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        Parenthesis(s, temp, 0, 0, n);
        return s;
    }

    public void Parenthesis(List<String> s, StringBuilder temp, int left, int right, int n) {
        if(left == n && n == right){
            s.add(temp.toString());
        }
        if(left < n){
            temp.append("(");
            Parenthesis(s, temp, left+1, right, n);
            temp.deleteCharAt(temp.length()-1);
        }
        if(right < left && right < n){
            temp.append(")");
            Parenthesis(s, temp, left, right+1, n);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
