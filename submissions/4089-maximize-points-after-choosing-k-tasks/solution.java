class Solution {
    public long maxPoints(int[] tech1, int[] tech2, int k) {
        int n = tech1.length;
        int[][] temp = new int[n][2];
        for(int i=0; i < n; i++){
            temp[i][0] = tech2[i] - tech1[i];
            temp[i][1] = i;
        }
        Arrays.sort(temp, (a,b) -> a[0]-b[0]);
        int left = 0;
        int right = n-1;
        long sum = 0;
        while(k > 0){
            sum += tech1[temp[left][1]];
            k--;
            left++;
        }
        k = left;
        while(n-k > 0){
            if(temp[right][0] > 0) sum += tech2[temp[right][1]];
            else sum += tech1[temp[right][1]];
            right--;
            k++;
        }
        return sum;
    }
}
