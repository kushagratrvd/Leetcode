class Solution {
    public int[][] merge(int[][] arr) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        ans.add(arr[0]);
        int ind = 0;
        for(int i=1; i<arr.length; i++){
            int[] prev = ans.get(ans.size()-1);
            if(prev[1] - arr[i][0] >= 0){
                if(arr[i][1] > prev[1]){
                    ans.set(ans.size()-1, new int[]{prev[0], arr[i][1]});
                }
            }
            else{
                ans.add(new int[]{arr[i][0], arr[i][1]});
            }
        }
        int[][] arr2 = new int[ans.size()][2];
        for(int i=0; i<arr2.length; i++){
            arr2[i] = ans.get(i);
        }
        return arr2;
    }
}
