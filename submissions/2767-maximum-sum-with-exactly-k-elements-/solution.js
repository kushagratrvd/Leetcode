/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximizeSum = function(nums, k) {
    let max = nums[0];
    for(let x of nums) max = Math.max(...nums);
    let sum = max * k + (k-1)*(k)/2;
    return sum;
};
