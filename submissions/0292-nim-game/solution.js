/**
 * @param {number} n
 * @return {boolean}
 */
var canWinNim = function(n) {
    let rem = n % 4 ;
    if(rem === 0) return false;
    return true;
};
