class Solution {
    public int largestRectangleArea(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int max = -1;
        for(int i=1; i<nums.length; i++){
            while(!st.isEmpty() && nums[i] < nums[st.peek()]){
                int top = st.pop();
                int product = i - top - 1;
                if(!st.isEmpty()) product = product + top - st.peek();
                else product = product + top + 1;
                max = Math.max(max, nums[top] * product);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int top = st.pop();
            int product = nums.length - top - 1;
            if(!st.isEmpty()) product = product + top - st.peek();
            else product = product + top + 1;
            max = Math.max(max, nums[top] * product);
        }
        return max;
    }
}
