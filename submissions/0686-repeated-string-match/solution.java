class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (rabinKarp(sb.toString(), b)) {
            return count;
        }

        sb.append(a);

        if (rabinKarp(sb.toString(), b)) {
            return count + 1;
        }

        return -1;
    }

    private boolean rabinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m > n) return false;

        long MOD = 1_000_000_007;
        long BASE = 31;

        long patternHash = 0;
        long windowHash = 0;
        long highestPower = 1;

        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * BASE) % MOD;
        }

        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
            windowHash = (windowHash * BASE + text.charAt(i)) % MOD;
        }

        for (int i = 0; i <= n - m; i++) {

            if (patternHash == windowHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    return true;
                }
            }

            if (i < n - m) {
                windowHash = (windowHash
                        - text.charAt(i) * highestPower % MOD
                        + MOD) % MOD;

                windowHash = (windowHash * BASE
                        + text.charAt(i + m)) % MOD;
            }
        }

        return false;
    }
}
