class Solution {
    public boolean isPalindrome(String s) {
        String lowercased = s.toLowerCase();
        String str = lowercased.replaceAll("[^a-z0-9]", "");
        int low = 0, high = str.length() - 1;
        return validPalindrome(str, low, high);
    }

    public boolean validPalindrome(String str, int low, int high) {
        if (low >= high) {
            return true;
        }
        if (str.charAt(low) == str.charAt(high)) {
            return validPalindrome(str, low+1, high-1);
        } else {
            return false;
        }
    }
}
