class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> st = new Stack<>();
        int n = h.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && h[st.peek()] >= h[i]) st.pop();
            if(st.isEmpty()) left[i] = -1;
            else left[i] = st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && h[st.peek()] >= h[i]) st.pop();
            if(st.isEmpty()) right[i] = n;
            else right[i] = st.peek();
            st.push(i);
        }
        int max = -1;
        for(int i=0; i<n; i++){
            int width = right[i] - left[i] - 1;
            System.out.println(i + ": " + right[i] + " " + left[i] + " " + width);
            max = Math.max(max, h[i]*width);
        }
        return max;
    }
}
