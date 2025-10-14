class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k==1) return true;
        int count = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=1; i<nums.size(); i++){
            if(nums.get(i-1) >= nums.get(i)) count = 1;
            else {
                count++;
                map.put(count,i);
            }
            if(count == k){
                int count2 = 1;
                for(int j=i+1; j<i+k; j++){
                    if(j+1 < nums.size() && nums.get(j) >= nums.get(j+1)){
                        count2 = 1;
                        if(k > 2) i = map.get(2);
                        break;
                    }
                    else if(j+1 < nums.size() && nums.get(j) < nums.get(j+1)) count2++;
                    if(count2 == k) return true;
                }
                count = 1;
            }
        }
        return false;
    }
}
