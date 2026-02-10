/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    function dfs(i,j,grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
            grid[i][j] = '0';
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
            dfs(i,j-1,grid);
            dfs(i,j+1,grid);
        }
    let m = grid.length;
    let n = grid[0].length;
    let count = 0;
    for(let i=0; i<m; i++){
        for(let j=0; j<n; j++){
            if(grid[i][j] == '1'){
                dfs(i,j,grid);
                count++;
            }
        }
    }
    return count;
};
