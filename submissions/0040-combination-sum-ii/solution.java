class Solution {
    public void dfs(int index, int sum, int[] arr, int target, List<Integer> temp, List<List<Integer>> ans, int prev){
        if(sum == target){
            List<Integer> temp2 = new ArrayList<>(temp);
            //Collections.sort(temp2);
            if(!ans.contains(temp2)){
                ans.add(temp2);
            }
            return;
        }
        if(index >= arr.length || sum > target) return;
        
        for(int i = index; i<arr.length; i++){
            if(sum + arr[i] <= target && prev != arr[i]){
                temp.add(arr[i]);
                dfs(i + 1, sum + arr[i], arr, target, temp, ans, prev);
                prev = temp.get(temp.size()-1);
                temp.remove(temp.size()-1);
            }
        }
            
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        int sum = 0;
        for(int num:arr) sum += num;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, 0, arr, target, temp, ans, -1);
        return ans;
    }
}
