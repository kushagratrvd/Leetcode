class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            while(!q.isEmpty() && q.peek() < nums[i]) q.poll();
            while(!q.isEmpty() && q.peekLast() < nums[i]) q.pollLast();
            q.offer(nums[i]);
        }
        int[] ans = new int[nums.length-k+1];
        for(int i=0; i<nums.length-k+1; i++){
            ans[i] = q.peek();
            if(nums[i] == q.peek()) q.poll();
            while(!q.isEmpty() && i+k < nums.length && q.peek() < nums[i+k]) q.poll();
            while(!q.isEmpty() && i+k < nums.length && q.peekLast() < nums[i+k]) q.pollLast();
            if(i+k < nums.length) q.offer(nums[i+k]);
        }
        return ans;
    }
}
