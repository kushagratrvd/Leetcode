/**
 * @param {string} s
 * @return {boolean}
 */
var checkZeroOnes = function(s) {
    let max0 = 0;
    let max1 = 0;
    let count0 = 0;
    let count1 = 0;
    for(let i=0; i<s.length; i++){
        if(s[i] === '1'){
            count0 = 0;
            count1++;
            max1 = Math.max(max1,count1);
        }
        else{
            count1 = 0;
            count0++;
            max0 = Math.max(max0,count0);
        }
    }
    return max1 > max0;
}

