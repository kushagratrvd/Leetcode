class Solution {
    public int brokenCalc(int startValue, int target) {
        if(target <= startValue) return startValue - target;
        int op = 0;

        while(target > startValue){
            if(target%2 != 0){
                target += 1;
                op++;
            }
            target = target / 2;
            op++;
        }

        op += startValue-target;
        return op;


    }
}
