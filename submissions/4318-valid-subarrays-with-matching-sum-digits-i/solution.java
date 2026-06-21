class Solution {
    /*public int helper(int[] nums, int x, long[] dp, long sum, int[] count, int ind){
        if(ind >= nums.length){
            
        }
    }*/
    public int countValidSubarrays(int[] nums, int x) {
        long sum = 0;
        int count = 0;
        char o = (char)('0' + x);
        for(int i=0; i<nums.length; i++){
            sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j]; 
                String sumstring = String.valueOf(sum);
                if(sumstring.charAt(0) == o && sumstring.charAt(sumstring.length()-1) == o) count++;
            }
        }
        return count;
        /*long[] dp = new long[nums.length+1];
        Arrays.fill(dp, -1);
        
        int ind = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if((char)('0') + nums[i] == o) count++; 
        }
        long prevsum = 0;
        if(nums.length == 1) return count;
        for(int i=0; i<nums.length; i++){
            long newsum = sum - prevsum;
            String sumstring = String.valueOf(newsum);
            if(sumstring.charAt(0) == o && sumstring.charAt(sumstring.length()-1) == o) count++;
            prevsum += nums[i];
        }
        //if()
        return count;
        //helper(nums, x, dp, sum, count, i);*/
    }
}
