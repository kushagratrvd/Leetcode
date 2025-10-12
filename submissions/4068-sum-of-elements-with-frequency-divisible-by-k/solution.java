class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] visited = new int[101];
        for(int i=0; i<nums.length; i++){
            visited[nums[i]]++;
        }
        int sum = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]%k == 0){
                sum += i*visited[i];
            }
        }
        return sum;
    }
}
