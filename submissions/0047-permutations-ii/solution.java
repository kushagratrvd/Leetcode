class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] map = new int[nums.length];
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        String num = "";
        solve(new ArrayList<>(),ans,nums,map,set,num);
        return ans;

    }
    public void solve(List<Integer>ds,List<List<Integer>> ans,int [] nums,int[] map,HashSet<String> set, String num){
        if(ds.size()==nums.length){
            if(set.contains(num)) return;
            set.add(num);
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(map[i]==0){
                map[i]=1;
                String prev = num;
                num = num + String.valueOf(nums[i]);
                ds.add(nums[i]);
                solve(ds,ans,nums,map,set,num);
                ds.remove(ds.size()-1);
                num = prev;
                map[i]=0;
            }
        }
    }
}
