class Solution {
    public String winningPlayer(int x, int y) {
        int q = (y/4);
        if(y < 4) return "Bob";
        if(Math.min(x,q)%2 == 0) return "Bob";
        return "Alice";
    }
}
