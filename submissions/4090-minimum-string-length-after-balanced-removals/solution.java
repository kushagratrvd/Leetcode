class Solution {
    public int minLengthAfterRemovals(String s) {
        int countA = 0;
        int countB = 0;
        for(char i:s.toCharArray()){
            if(i == 'a') countA++;
            else countB++;
        }
        if(countA == 0 || countB == 0) return s.length();
        return s.length()-(2*Math.min(countA,countB));
    }
}
