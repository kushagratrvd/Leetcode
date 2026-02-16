class Solution {
    public int reverseBits(int n) {
        String num = Integer.toBinaryString(n);
        int x = 32-num.length();
        for(int i=0; i<x; i++){
            num = '0' + num;
        }
        int result = 0;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '1') result += Math.pow(2,i);
        }
        return result;
    }
}
