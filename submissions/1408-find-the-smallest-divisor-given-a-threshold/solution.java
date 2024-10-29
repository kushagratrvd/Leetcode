class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // int sum = threshold + 1;
        // double divisor = 1.0;
        // while(sum > threshold){
        //     sum = 0;
        //     for(int i = 0; i < nums.length; i++){
        //         sum+=Math.ceil(nums[i]/divisor);
        //     }
        //     divisor++;
        // }
        // return (int)divisor-1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int low = 1;
        int high = max;
        while(low <= high){
            int mid = (low + high)/2;
            int result = SumByD(nums,mid);
            if(result <= threshold){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
            
        }
        return low;
        
    }
    
    public int SumByD(int[] arr, int divisor){
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                sum += Math.ceil((double)(arr[i])/divisor);
            }
            return sum;
        }
}
