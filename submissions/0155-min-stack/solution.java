class MinStack {
    ArrayList<Integer> arr;
    ArrayList<Integer> min;
    public MinStack() {
        arr = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int value) {
        arr.add(value);
        if(min.size() == 0){
            min.add(value);
            System.out.println(min);
        }
        else{
            if(min.get(min.size()-1) >= value) min.add(value);
        }
    }
    
    public void pop() {
        System.out.println("arr before: "+ arr);
        System.out.println("min before: "+ min);
        if(arr.get(arr.size()-1).equals(min.get(min.size()-1))) min.remove(min.size()-1); 
        arr.remove(arr.size()-1);
        System.out.println("arr after: "+ arr);
        System.out.println("min after: "+ min);
    }
    
    public int top() {
        return arr.get(arr.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
