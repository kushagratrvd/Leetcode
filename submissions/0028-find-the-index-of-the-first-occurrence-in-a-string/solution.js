/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    let n = haystack.length;
    let m = needle.length;
    for(let i=0; i<n; i++){
        if(i+m <= n && haystack.substring(i,i+m) === needle) return i;
    }
    return -1;
};
