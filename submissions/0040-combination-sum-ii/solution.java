class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Combi(nums, target, 0, arr, temp);
        return arr;
    }

    public void Combi(int[] nums, int target, int ind, List<List<Integer>> arr, List<Integer> temp) {
        if(target == 0){   
            arr.add(new ArrayList<>(temp));
            return;
        } 
        
        for(int i=ind; i<nums.length; i++){
            if(i>ind && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > target) break;
            temp.add(nums[i]);
            Combi(nums, target-nums[i], i+1, arr, temp);
            temp.remove(temp.size()-1);
        }
        
        
        //Combi(nums, target, ind+1, arr, temp, start);
    }
}
