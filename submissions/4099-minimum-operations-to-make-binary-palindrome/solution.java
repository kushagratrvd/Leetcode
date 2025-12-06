class Solution {
    public boolean ans(int x){
        String binary = Integer.toBinaryString(x);
        String reversed = new StringBuilder(binary).reverse().toString();
        if(reversed.equals(binary)) return true;
        return false;
    }
    public int[] minOperations(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            if(ans(curr)) result[i] = 0;
            else{
                int j = 1;
                while(true){
                    if(ans(curr - j) || ans(curr + j)){
                        result[i] = j;
                        break;
                    }
                    j++;
                }
            }
        }
        return result;
    }
}
