class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c = cost1 + cost2;
        if(costBoth < c){
            long c1 = Math.min(need1,need2) * (long)costBoth;
            if(need1 > need2){
                long extra = need1-need2;
                if(cost1 <= costBoth){
                    return c1 + extra * cost1;
                }
                return c1 + extra * costBoth;
            }
            else if(need2 > need1){
                long extra = need2-need1;
                if(cost2 <= costBoth){
                    return c1 + extra * cost2;
                }
                return c1 + extra * costBoth;
            }
            else return c1;
        }
        else{
            return (long)need1 * cost1 + (long)need2 * cost2;
        }
    }
}
