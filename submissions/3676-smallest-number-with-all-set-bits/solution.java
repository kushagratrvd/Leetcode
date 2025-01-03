class Solution {
        public int smallestNumber(int n) {
            int b = (int) (Math.log(n) / Math.log(2)) + 1;
            return (1 << b) - 1;
    }
}
