class StockSpanner {

    public StockSpanner() {
        
    }
    Stack<int[]> st = new Stack<>();
    public int next(int price) {
        if(st.isEmpty()){
                st.push(new int[]{price, 1});
                return 1;
            
        }
        if(st.peek()[0] > price){
            st.push(new int[]{price, 1});
            return 1;
        }
        int sum = 0;
        while(!st.isEmpty() && st.peek()[0] <= price){
            //System.out.println(ans);
            sum += st.peek()[1];
            st.pop();
        }
        //System.out.println(ans);
        st.push(new int[]{price,sum+1});
        return sum+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
