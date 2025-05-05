class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int k) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Combi(nums, k, 0, arr, temp, 0);
        return arr;
    }

    public void Combi(int[] nums, int k, int ind, List<List<Integer>> arr, List<Integer> temp, int sum) {
        if(sum == k){
            arr.add(new ArrayList<>(temp));
            return;
        } 
        if(ind >= nums.length || sum > k) return;
        temp.add(nums[ind]);
        sum += nums[ind];
        Combi(nums, k, ind, arr, temp, sum);

        temp.remove(temp.size()-1);
        sum -= nums[ind];
        Combi(nums, k, ind+1, arr, temp, sum);
    }
}
