class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] ans = new int[arr.length];
        int max = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        for(int i=0; i<arr.length; i++){
            if(max == arr[i]) ans[i] = -1;
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                ans[st.pop()] = arr[i];
            }

        }
        
        return ans;
    }
}
