class Solution {
    public int removeDuplicates(int[] arr) {
        int max = arr[0];
        int prev = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                arr[prev++] = arr[i];
                max = arr[i];
            }
        }
        return prev;
    }
}
