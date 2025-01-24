import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        addToList(list, 0, 0, str, n);
        return list;
    }

    public void addToList(List<String> list, int l, int r, StringBuilder str, int n) {
        if (l == n && r == n) {
            list.add(str.toString());
            return;
        }

        if (l < n) {
            str.append("("); // Append an open parenthesis
            addToList(list, l + 1, r, str, n);
            str.deleteCharAt(str.length() - 1); // Backtrack
        }

        if (r < l) {
            str.append(")"); // Append a close parenthesis
            addToList(list, l, r + 1, str, n);
            str.deleteCharAt(str.length() - 1); // Backtrack
        }
    }
}

