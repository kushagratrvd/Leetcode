class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] Ansarr = new int[n];
        int left = 0;
        int right = n-1;
        for(int i = n-1; i >=0; i--){
            if(Math.abs(nums[left]) >= Math.abs(nums[right])){
                Ansarr[i] = nums[left]*nums[left];
                left++;
            }
            else{
                Ansarr[i] = nums[right]*nums[right];
                right--;
            }
        }
        return Ansarr;
    }
}
