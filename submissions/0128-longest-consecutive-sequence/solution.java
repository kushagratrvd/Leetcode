class Solution {
    public int longestConsecutive(int[] nums) {
        //392
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        int count = 1;
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        for(int num : set){
            if(!set.contains(num-1)){
                int curr = num;
                count = 1;
                while(set.contains(curr + 1)){
                    //set.remove(curr);   i cannot remove and traverse elements from set at same time
                    count++;
                    curr++;
                }
                max = Math.max(max,count);
            }
        }
        //max = Math.max(max,count);
        return max;
    }
}
