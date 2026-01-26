class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> q = new LinkedList<>();
        int i=0, j=0;
        while(i<m+n && j<n){
            if(q.isEmpty()){
                if(nums2[j] < nums1[i] || (i>=m && nums1[i] == 0)){
                    if(i < m) q.offer(nums1[i]);
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                }
                else i++;
            }
            else{
                if(nums2[j] < q.peek()){
                    if(i < m) q.offer(nums1[i]);
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                }
                else if(nums2[j] >= q.peek()){
                    if(i < m) q.offer(nums1[i]);
                    nums1[i] = q.poll();
                    i++;
                }
            }
        }
        while(!q.isEmpty()){
            if(i < m) q.offer(nums1[i]);
            nums1[i] = q.poll();
            i++;
        }
    }
}
