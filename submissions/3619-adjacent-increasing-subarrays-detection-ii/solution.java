class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prev = 0;
        int curr = 1;
        int k=0;
        for(int i=1; i<nums.size(); i++){
            if(nums.get(i-1) < nums.get(i)){
                curr++;
                k=Math.max(k, curr/2);
            }
            else{
                k = Math.max(k,Math.min(curr, prev));
                prev = curr;
                curr = 1;
            }
        }
        k = Math.max(k,Math.min(curr, prev));
        return k;
    }
}
