/**
 * @param {number[][]} isConnected
 * @return {number}
 */

    function findParent(x, parents){
        if(parents[x] != x) return parents[x] = findParent(parents[x],parents);
        return parents[x];
    }
    function Union(a, b, parents, ranks){
        let parentA = findParent(a, parents);
        let parentB = findParent(b, parents);
        if(parentA == parentB){
            return;
        }
        if(ranks[parentA] > ranks[parentB]){
            parents[parentB] = parentA;
        }
        else if(ranks[parentA] < ranks[parentB]){
            parents[parentA] = parentB;
        }
        else{
            parents[parentB] = parentA;
            ranks[parentA]++;
        }
    }
    var findCircleNum = function(mat) {
        let n = mat.length;
        const ranks = new Array(n).fill(0);
        const parents = new Array(n);
        for(let i=0; i<n; i++){
            parents[i] = i;
        }
        for(let i=0; i<n; i++){
            for(let j=0; j<n; j++){
                if(i != j && mat[i][j] == 1){
                    Union(i,j, parents, ranks);
                }
            }
        }
        let count = 0;
        for(let i=0; i<n; i++){
            if(parents[i] == i) count++;
        }
        return count;
};
