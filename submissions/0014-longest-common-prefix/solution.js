/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if(strs.length == 1) return strs[0];
    let smallest = 201;
    for(let i=0; i<strs.length; i++){
        smallest = Math.min(smallest,strs[i].length);
    }
    let max = -1;
    for(let i=1; i<=smallest; i++){
        let flag = true;
        for(let j=0; j<strs.length-1; j++){
            if(strs[j].substring(0,i) != strs[j+1].substring(0,i)){
                flag = false;
                break;
            }
        }
        if(flag) max = i;
    }
    if(smallest == 1){
        let flag = true;
        for(let j=0; j<strs.length-1; j++){
            if(strs[j].substring(0,1) != strs[j+1].substring(0,1)){
                flag = false;
                break;
            }
        }
        if(flag) max = 1;
    }
    if(max == -1) return "";
    return strs[0].substring(0,max);
};
