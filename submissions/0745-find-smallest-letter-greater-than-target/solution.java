class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if(letters[n-1] <= target) return letters[0];
        if(letters[0] > target) return letters[0];
        int low = 0;
        int high = n-1;
        int mid = 0;
        while(low < high){
            mid = (low+high)/2;
            if(letters[mid] > target) high = mid - 1;
            else if(letters[mid] <= target) low = mid + 1;
            //else return letters[mid + 1];
        }
        if(low == n-1) return letters[low];
        if(letters[low] > target) return letters[low];
        return letters[low + 1];
    }
}
