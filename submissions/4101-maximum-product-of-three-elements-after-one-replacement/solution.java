class Solution {
    public long maxProduct(int[] nums) {
        //HashMap<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = max + 1;
        int[] MIN = {0,0};
        int[] MAX = {0,0};
        for(int i : nums){
            int j = Math.abs(i);
            if(j > max){
                MIN[0] = max;
                MIN[1] = MAX[1];
                min = max;
                max = j;
                MAX[0] = j;
                MAX[1] = i;
            }
            else if(j > min){
                min = j;
                MIN[0] = j;
                MIN[1] = i;
            } 
        }
        if(MAX[1] * MIN[1] >= 0) return (long)MAX[1] * MIN[1] * 100000;
        return (long)MAX[1] * MIN[1] * -100000; 
    }
}
