class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int low = bloomDay[0];
        int high = bloomDay[0];
        for(int i : bloomDay){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        while(low < high){
            int mid = low + (high-low)/2;
            int flower = 0;
            int bouqet = 0;
            for(int i : bloomDay){
                if(mid >= i){
                    flower += 1;
                    if(flower == k){
                        bouqet++;
                        flower = 0;
                    }
                }
                else flower = 0;
            }
            if(bouqet >= m) high = mid;
            else low = mid+1; 
            //System.out.println("low " +low);
            //System.out.println("high " +high);
        }
        return low;
    }
}
