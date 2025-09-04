class Solution {
    public int nextGreaterElement(int n) {
        if(n%10 == n) return -1;
        if(n == Integer.MAX_VALUE) return -1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(n > 0){
            ans.add(n % 10);
            n = n/10;
            if(ans.size() > 1 && (ans.get(ans.size()-1) < ans.get(ans.size()-2))){
                int target = ans.get(ans.size()-1);
                Collections.sort(ans);
                for(int i = 0; i < ans.size(); i++){
                    if(ans.get(i) > target){
                        n = n * 10 + ans.get(i);
                        ans.remove(i);
                        break;
                    }
                }
                long result = n;
                for(int i : ans){
                    result = result*10 + i;
                    if(result > Integer.MAX_VALUE) return -1;
                }
                
                if(result < 0) return -1;
                return (int)result;
            }
            if(n <= 0) return -1;
        }
        return n;
    }
}
