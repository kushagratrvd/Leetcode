class Solution {
    public boolean isPalindrome(int n) {
    int original=n;
    int reversed = 0;
    
    while (n > 0) {
        int rem = n % 10;
        reversed = reversed * 10 + rem;
        n /= 10;
    }
    
    return original == reversed;
}
}

