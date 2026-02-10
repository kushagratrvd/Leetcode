/**
 * @param {number[]} nums
 * @return {number}
 */
var wiggleMaxLength = function(nums) {
    if (nums.length < 2) return nums.length;
    if(nums.length == 2 && nums[1] - nums[0] == 0) return 1;

    let prev = nums[1] - nums[0];
    let count = (prev != 0) ? 2 : 1;
    for (let i = 2; i < nums.length; i++) {
        let curr = nums[i] - nums[i-1];
        if(curr > 0 && prev <= 0 || curr < 0 && prev >= 0){
            count++;
            prev = curr;
        }             
    }

    return count;
};
