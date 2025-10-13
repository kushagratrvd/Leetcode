class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int bal = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) bal++;
            else bal--;
            
            if(map.containsKey(bal)){
                max = Math.max(max,i-map.get(bal));
            }
            else{
                map.put(bal,i);
            }
        }
        return max;
    }
}
