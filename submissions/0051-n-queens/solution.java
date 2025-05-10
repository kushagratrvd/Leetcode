class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        Queens(ans,temp, 0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return ans;
    }

    public void Queens(List<List<String>> ans, List<String> temp, int row, int n, Set<Integer> diff1, Set<Integer> diff2, Set<Integer> lava){
        if(row == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int col = 0; col<n; col++){
            if(diff1.contains(col-row) || diff2.contains(col+row) || lava.contains(col)) continue;

            diff1.add(col-row);
            diff2.add(col+row);
            lava.add(col);
            char[] chars = new char[n];
            Arrays.fill(chars, '.');  // fill entire array with '.'
            chars[col] = 'Q';      // set 'q' at desired colex
            String str = new String(chars);
            temp.add(str);

            Queens(ans, temp, row+1, n, diff1, diff2, lava);
            temp.remove(temp.size()-1);
            diff1.remove(col-row);
            diff2.remove(col+row);
            lava.remove(col);
        }
    }
}
