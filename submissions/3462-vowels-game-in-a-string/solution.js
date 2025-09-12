/**
 * @param {string} s
 * @return {boolean}
 */
var doesAliceWin = function(s) {
    for(let i=0; i<s.length; i++){
        vow = s[i];
        if(vow === 'a' || vow === 'e' || vow === 'i' || vow === 'o' || vow ==='u') return true;
    }
    return false;
};
