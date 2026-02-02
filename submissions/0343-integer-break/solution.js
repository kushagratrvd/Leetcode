/**
 * @param {number} n
 * @return {number}
 */
var integerBreak = function(n) {
    if(n<=3) return n-1;
        if(n%3==0) return Math.pow(3,n/3);
        if(n % 3 > 1) return Math.pow(3,Math.floor(n/3))*(n%3);
        return Math.pow(3, Math.floor(n/3)-1) * 4;
};
