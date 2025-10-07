class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int OriginalColor = image[sr][sc];
        check(image, OriginalColor, sr, sc, color);
        return image;
    }
    public void check(int[][] image, int OriginalColor, int sr, int sc, int color){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != OriginalColor) return;

        image[sr][sc] = color;
        check(image, OriginalColor, sr+1, sc, color);
        check(image, OriginalColor, sr-1, sc, color);
        check(image, OriginalColor, sr, sc+1, color);
        check(image, OriginalColor, sr, sc-1, color);

    }
}
