class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        int max = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] < prices[l]){
                max = Math.max(prices[r] - prices[l], max);
                l = i;
                r = i;
            }
            else if(prices[i] > prices[r]) r = i;
        }
        max = Math.max(prices[r] - prices[l], max);
        return max;
    }
}
