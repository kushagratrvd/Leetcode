class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int j=0; j<nums2.length; j++){
            if(map.containsKey(nums2[j]) && map.get(nums2[j]) > 0){
                ans.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j])-1);
            }
        }
        int[] result = new int[ans.size()];
        for(int i=0; i<result.length; i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}
