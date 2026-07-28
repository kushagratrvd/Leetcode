class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] first = new int[]{1};
        ans.add(Arrays.asList(1));
        if(n == 1) return ans;
        ans.add(Arrays.asList(1,1));
        if(n == 2) return ans;
        int prev = 1;
        int level = 2;
        while(level < n){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            int i = 0;
            List<Integer> prevList = ans.get(prev++);
            int[] arr = new int[level+1];
            while(i < prevList.size()-1){
                int sum = prevList.get(i) + prevList.get(i+1);
                //System.out.println(i + " " + prevList);
                temp.add(sum);
                i++;
            }
            temp.add(1);
            ans.add(temp);
            level++;
        }
        return ans;
    }
}
