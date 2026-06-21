class Solution {
    public int maxDistance(String moves) {
        int dashes = 0;
        int verticalsum = 0;
        int horizontalsum = 0;
        for(int i=0; i<moves.length(); i++){
            if(moves.charAt(i) == '_') dashes++;
            else{
                if(moves.charAt(i) == 'U') verticalsum++;
                else if(moves.charAt(i) == 'R') horizontalsum++;
                else if(moves.charAt(i) == 'L') horizontalsum--;
                else verticalsum--;
            }
        }
        return Math.abs(verticalsum)+Math.abs(horizontalsum)+dashes;
    }
}
