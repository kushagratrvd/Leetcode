/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let sum = 0;
    let max = Number.MIN_SAFE_INTEGER;
    for(let i=0; i<nums.length; i++){
        if(sum < 0){
            sum = nums[i];
            max = Math.max(sum,max);
        }
        else{
            sum += nums[i];
            max = Math.max(sum,max);
        }
    }
    return max;
};
