class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arr2 = arr.clone();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.sort(arr2);
        Map<Integer, Integer> hashie = new HashMap<>();
        int rank = 1;
        for(int i = 0; i < n; i++){
            if(!hashie.containsKey(arr2[i])){
                hashie.put(arr2[i],rank++);
            }
        }
        for(int i = 0; i < n; i++){
            ans[i] = hashie.get(arr[i]);
        }
        
        return ans;
    }
}
