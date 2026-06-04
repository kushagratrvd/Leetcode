class Solution {
    public int[] asteroidCollision(int[] arr) {
        LinkedList<Integer> q = new LinkedList<>();
        
        for(int i=0; i<arr.length; i++){
            int flag = -1;
            if(arr[i] < 0 && !q.isEmpty() && q.peekLast() > 0){
                int num = -1*arr[i];
                while(!q.isEmpty() && num >= q.peekLast() && q.peekLast() > 0){
                    if(num == q.peekLast()){
                        q.pollLast();
                        flag = 0;
                        break;
                    }
                    q.pollLast();
                }
                if(!q.isEmpty() && q.peekLast() < 0 && flag == -1) q.offer(arr[i]);
                else if(flag == -1 && (q.isEmpty() || q.peekLast() < 0)){
                    q.offer(arr[i]);
                }
            }
            else q.offer(arr[i]);
        }
        int[] res = new int[q.size()];
        for(int i=0; i<q.size(); i++){
            res[i] = q.get(i);
        }
        return res;
    }
}
