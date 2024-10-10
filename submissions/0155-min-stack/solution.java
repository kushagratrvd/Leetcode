class MinStack {
    Stack <Integer> stack = new Stack();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(min > val || stack.size() == 1){
            min = val;
        }
    }
    
    public void pop() {
        
        if(min == stack.peek()){
            min = stack.get(0);
            for(int i = 1; i < stack.size()-1; i++){
                if(min > stack.get(i)){
                    min = stack.get(i);
                }
            }
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        // if(stack.size() == 1){
        //     return stack.get(0);
        // }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
