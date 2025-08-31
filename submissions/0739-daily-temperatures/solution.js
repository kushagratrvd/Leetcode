/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(arr) {
    const n = arr.length;
    const ans = new Array(n).fill(0);
    const st = [];

    for(let i=0; i<n; i++){
        while(st.length && arr[i] > arr[st[st.length-1]]){
            const prevIndex = st.pop();
            ans[prevIndex] = i-prevIndex;
        }
        st.push(i);
    } 
    return ans;
};
