class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end=-1,st=1,ans=-1;
        for(int i=0;i<piles.length;i++){
            end=Math.max(end,piles[i]);
        }
        while(st<=end){
            int mid=st+(end-st)/2;
            if(helper1(piles,mid,h)){
                ans=mid;
                end=mid-1;
            }
            else st=mid+1;
        }
        return ans;
    }
    
    static boolean helper1(int[] piles,int mid,int h){
        double c=0;
        for(int j=0;j<piles.length;j++){
            c+=(piles[j] + mid - 1) / mid;
        }
        return c<=h;
    }
}
