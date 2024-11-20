class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m * k > bloomDay.length) return -1;
        int ans = 0;
        int min = bloomDay[0], max = bloomDay[0];
        for(int i = 0; i < bloomDay.length; i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        while(min < max){
            int mid = (min + max)/2;
            if(possibleBouqets(bloomDay, mid, k ,m)){
                max = mid;
                ans = mid;
            }
            else{
                min = mid + 1;
            }
        }
        return min;
    }
    public boolean possibleBouqets(int[] arr, int days, int k, int m){
        int flowers = 0;
        int bouqets = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= days){
                flowers++;
                if(flowers == k){
                    bouqets++;
                    flowers = 0;
                }
            }
            else{
                flowers = 0;
            }
        }
        return (bouqets >= m);
    }
}

