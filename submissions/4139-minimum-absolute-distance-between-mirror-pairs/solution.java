class Solution {
    public int reverseNum(int x) {
        while(x >= 10 && x % 10 == 0) x /= 10; 
        String original = String.valueOf(x);
        String reversed = new StringBuilder(original).reverse().toString();
        return Integer.valueOf(reversed);
    }
    public int minMirrorPairDistance(int[] nums) {
        //Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(reverseNum(nums[i]),i);
            }
            else{
                int ind = map.get(nums[i]);
                min = Math.min(min,i-ind);
                if(min == 0) return 0;
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}
