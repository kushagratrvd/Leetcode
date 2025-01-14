class Solution {
    public int[] singleNumber(int[] Arr) {
        int N = Arr.length;
        long xorr = 0;
        for(int i=0; i<N; i++){
            xorr ^= Arr[i];
        }
        int rightMostBit = (int)((xorr & xorr-1) ^ xorr);
        int b1 = 0,b2 = 0;
        for(int i = 0; i<N; i++){
            if((Arr[i] & rightMostBit) == rightMostBit){
                b1 ^= Arr[i];
            }
            else{
                b2 ^= Arr[i];
            }
        } 
        int[] keys = new int[2];
        keys[0] = b1;
        keys[1] = b2;
        return keys;
    }
}
