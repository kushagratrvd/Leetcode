/**
 * @param {string} s
 * @return {number}
 */
var partitionString = function(s) {
    let count = 1;
    let arr = new Array(26).fill(0);
    for(let i=0; i<s.length; i++){
        let c = s[i];
        if(arr[c.charCodeAt(0)-'a'.charCodeAt(0)] == 1){
            count++;
            arr = new Array(26).fill(0);
            //arr[c-'a'] = 1;
        }
        arr[c.charCodeAt(0)-'a'.charCodeAt(0)] = 1;
    }
    return count;
};
