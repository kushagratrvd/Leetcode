/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
    if(n <= 2) return 0;
        let arr = new Array(n).fill(true);
        //Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;
        for(let i = 2; i * i < n; i++){
            if(arr[i]){
                for(let j = i*i; j < n; j += i){
                    arr[j] = false;
                }
            }
        }
        let count = 0;
        for(let i=0; i<n; i++){
            if(arr[i]) count++;
        }
        return count;
};
