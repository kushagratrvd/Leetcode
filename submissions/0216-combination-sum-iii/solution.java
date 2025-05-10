class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(ans, temp, k, n, 0, 1);
        return ans;
    }

    public void recursion(List<List<Integer>> ans, List<Integer> temp, int k, int n, int sum, int ind){
        if(temp.size() == k && sum == n){
            ans.add(new ArrayList<>(temp));
        }

        for(int i=ind; i<=9; i++){
            temp.add(i);
            recursion(ans, temp, k, n, sum + i, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
