class Solution {
    public boolean isPowerOfTwo(int n) {
if (n <= 0) return false;
        return (1 << 30) % n == 0;    }
}
