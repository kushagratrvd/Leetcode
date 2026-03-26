class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int j=0; j<nums2.length; j++){
            if(set.contains(nums2[j])){
                ans.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        int[] result = new int[ans.size()];
        for(int i=0; i<result.length; i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}
