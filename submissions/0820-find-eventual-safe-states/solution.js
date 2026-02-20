/**
 * @param {number[][]} graph
 * @return {number[]}
 */
var eventualSafeNodes = function(graph) {
    function dfs(val){
        if(pathVisited[val] === 1 || safe[val] === -1) return -1;
        if(safe[val] === 1) return 1;
        visited[val] = 1;
        pathVisited[val] = 1;
        let curr = graph[val];
        let count = 0;
        for(let j of curr){
            if(visited[j] === 1){
                count += safe[j];
                continue;
            }
            let value = dfs(j);
            if(value === -1) break;
            count += value;
        }
        if(count === curr.length) safe[val] = 1;
        else safe[val] = -1;
        pathVisited[val] = 0;
        return safe[val];
    }
    let n = graph.length;
        let visited = new Array(n);
        let pathVisited = new Array(n);
        let safe = new Array(n);
        for(let i=0; i<graph.length; i++){
            if(visited[i] === 1) continue;
            dfs(i);
        }
        let ans = [];
        for(let i=0; i<safe.length; i++){
            if(safe[i] === 1) ans = [...ans,i];
        }
        return ans;
};
