function repeatedNTimes(nums: number[]): number {
    let set = new Set();
    for (let i = 0; i < nums.length; i++) {
        if(set.has(nums[i])) return nums[i];
        set.add(nums[i]);
    } 
    return nums[0];
};
