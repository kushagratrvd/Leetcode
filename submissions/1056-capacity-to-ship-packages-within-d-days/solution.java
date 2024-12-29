class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = weights[0];
        for(int i=1; i<weights.length; i++){
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        //int ans=0;
        while(low < high){
            int mid = (low + high)/2;
            int NumOfDays = CountDays(weights,mid);
            if(NumOfDays <= days){
                high = mid;
                //ans = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int CountDays(int[] weights, int capacity) {
        int countDays = 0;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            if(sum > capacity){
                sum = weights[i];
                countDays++;
            }
        }
        return countDays+1;
    }
}
