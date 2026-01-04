class Solution {
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<Integer>();
        int temp = num;
        while(temp > 0){
            list.add(temp%10);
            temp /= 10;
        }
        for(int i=list.size()-1; i>=0; i--){
            if(list.get(i) == 6){
                list.set(i,9);
                break;
            }
        }
        for(int i=list.size()-1; i>=0; i--){
            temp = temp*10 + list.get(i);
        }
        return temp;
    }
}
