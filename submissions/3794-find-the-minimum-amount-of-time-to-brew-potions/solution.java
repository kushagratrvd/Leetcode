class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] arr = new long[skill.length+1];
        arr[0] = 0;
        long count = 0;
        for(int i=0; i<skill.length; i++){
            long val = (long) mana[0] * skill[i];
            arr[i+1] = arr[i] + val;
        }
        for(int j=1; j<mana.length; j++){
            arr[0] = arr[1];
            count = 0;
            for(int i=0; i<skill.length; i++){
                long val = (long) mana[j] * skill[i];
                arr[i+1] = arr[i] + val;
                if(i+2 < arr.length && arr[i+2] > arr[i+1] + count) count += Math.abs(arr[i+2] - arr[i+1] - count);
            }
            if(count != 0){
                for(int i=0; i<arr.length; i++){
                    arr[i] = arr[i] + count;
                }
            }
            
        }
        return arr[arr.length-1];
    }
}
