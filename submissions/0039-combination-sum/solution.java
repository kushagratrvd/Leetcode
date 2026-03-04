class Solution {
    public void dfs(int index, int sum, int[] arr, int target, List<Integer> temp, List<List<Integer>> ans){
        if(sum == target){
            List<Integer> temp2 = new ArrayList<>(temp);
            //Collections.sort(temp2);
            
            ans.add(temp2);
            
            return;
        }
        if(index >= arr.length || sum + arr[index] > target) return;
        
        for(int i = index; i<arr.length; i++){
            if(sum + arr[i] <= target){
                temp.add(arr[i]);
                dfs(i, sum + arr[i], arr, target, temp, ans);
                temp.remove(temp.size()-1);
                //dfs(i+1, sum, arr, target, temp, ans);
            }
        }
            
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        int sum = 0;
        for(int num:arr) sum += num;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, 0, arr, target, temp, ans);
        return ans;
    }
}
