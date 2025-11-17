class Solution {
    public void recursion(int start,List<Integer> temp,int n,List<List<Integer>> ans,int[] visited, int[] nums){
        if(temp.size()==n){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=(start+1)%n; i!=start; i=(i+1)%n){
            if(visited[i]==1) continue;
            visited[i]=1;
            temp.add(nums[i]);
            recursion(i,temp,n,ans,visited,nums);
            temp.remove(temp.size()-1);
            visited[i] = 0;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<n; i++){
            int[] visited = new int[n];
            visited[i] = 1;
            temp.add(nums[i]);
            recursion(i,temp,n,ans,visited,nums);
            temp.remove(temp.size()-1);
        }
        return ans;
    }
}
