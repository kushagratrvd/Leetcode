class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++){
            int val = (int) Math.ceil(1.0 * success / spells[i]);

            int low = 0;
            int high = potions.length-1;
            int first = potions.length;
            while(low <= high){
                int mid = (low + high)/2;
                if((long) potions[mid] >= val){
                    first = mid;
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            pairs[i] = potions.length - first;


        }
        return pairs;
    }
}
