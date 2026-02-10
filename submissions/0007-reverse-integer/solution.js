/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let isNegative = false;
        let n = x;
        if(x < 0){
            isNegative = true;
            n = Math.abs(x);
        }
        let reversed = 0;
        while(n > 0){
            const digit = n % 10;
            reversed = reversed * 10 + digit;
            n = Math.floor(n / 10);
        }
        if(reversed > Math.pow(2, 31) - 1) return 0;
        if(isNegative) return -reversed;
        return reversed;
};
