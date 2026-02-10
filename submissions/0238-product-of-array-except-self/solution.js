/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let n = nums.length;
        const result = new Array(n);
        result[0] = 1;
        let product = nums[0];
        for(let i = 1; i<n; i++){
            result[i] = product;
            product *= nums[i];
        }
        product = nums[n-1];
        for(let i = n-2; i >= 0; i--){
            result[i] = result[i] * product;
            product *= nums[i];
        }
        return result;
};
