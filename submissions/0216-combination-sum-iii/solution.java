class Solution {
    public void dfs(int num, int sum, List<Integer> temp, List<List<Integer>> ans, int k, int target){
        if(sum == target){
            if(temp.size() == k){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(sum > target || num >= 10 || temp.size() >= k) return;
        temp.add(num);
        dfs(num + 1, sum + num, temp, ans, k, target);
        temp.remove(temp.size()-1);
        dfs(num+1, sum, temp, ans, k, target);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(1,0,temp,ans,k,n);
        return ans;
    }
}
