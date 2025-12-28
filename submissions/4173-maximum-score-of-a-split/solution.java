class Solution {
    public long maximumScore(int[] nums) {
        int minIndex = 1;
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[0]-y[0]);
        for(int i=1; i<nums.length; i++){
            pq.offer(new int[]{nums[i],i});
        }
        for(int i=0; i<nums.length-1; i++){
            sum += nums[i];
            //int[] polled = pq.poll();
            while(!pq.isEmpty() && pq.peek()[1] <= i){
                pq.poll();
            }
            if(!pq.isEmpty()){
                minIndex = pq.peek()[1];
            }
            maxSum = Math.max(maxSum, sum-nums[minIndex]);
            /*if(i+1 == minIndex){
                minIndex+=1;
                for(int j=i+3; j<nums.length; j++){
                    if(nums[j] < nums[minIndex]) minIndex = j;
                }
            }  */ 
        }
        return maxSum;
    }
}
