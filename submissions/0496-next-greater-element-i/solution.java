class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] map = new int[10001];
        int max = -1;
        Stack<Integer> st = new Stack<>();
        st.push(nums2[nums2.length-1]);
        map[nums2[nums2.length-1]] = -1;
        for(int i = nums2.length-2; i>=0; i--){
            while(nums2[i] > st.peek()){
                st.pop();
                if(st.isEmpty()){
                    break;
                }
            }
            if(st.isEmpty()) map[nums2[i]] = -1; 
            else map[nums2[i]] = st.peek();
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = map[nums1[i]];
        }
        return ans;
    }
}
