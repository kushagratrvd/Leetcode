class Solution {
    public int longestConsecutive(int[] a) {
        int n = a.length;
        if (n == 0) return 0;
        int longest = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i],i);
        }
        for (int i=0; i < a.length; i++) {
            int it = a[i];
            if (!map.containsKey(it - 1)) {
                int cnt = 1;
                int x = it;
                while (map.containsKey(++x)) {
                    //x = x + 1;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
