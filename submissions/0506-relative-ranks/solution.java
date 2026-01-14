class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        if(n == 1){
            result[0] = "Gold Medal";
            return result;
        } 
        if(n == 2){
            if(score[0] > score[1]){
                result[0] = "Gold Medal";
                result[1] = "Silver Medal";
            }
            else if(score[1] > score[0]){
                result[1] = "Gold Medal";
                result[0] = "Silver Medal";
            }
            return result; 
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] clone = new int[n];
        for(int i=0; i<n; i++){
            clone[i] = score[i];
        }
        Arrays.sort(clone);
        for(int i=0; i<n; i++){
            map.put(clone[i],n-i);
        }
    
        for(int i=0; i<n; i++){
            int val = map.get(score[i]);
            if(val == 1) result[i] = "Gold Medal";
            else if(val == 2) result[i] = "Silver Medal";
            else if(val == 3) result[i] = "Bronze Medal";
            else result[i] = String.valueOf(val);
        }
        return result;
    }
}
