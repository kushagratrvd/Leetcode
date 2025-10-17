class Solution {
    public int findSmallestInteger(int[] nums, int val) {
        int[] map = new int[val];
        for(int i=0; i<nums.length; i++){
            int a = ((nums[i] % val) + val) % val;
            map[a]++;
        }
        int mex = 0;
        while(true){
            if(map[mex%val] > 0){
                map[mex%val]--;
                mex++;
            } 
            else return mex;
        }
    }
}
