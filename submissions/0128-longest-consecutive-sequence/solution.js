var longestConsecutive = function(nums) {
    const map = new Map();
    let longest = 0;

    for (let num of nums) {
        if (map.has(num)) continue;

        const left = map.get(num - 1) || 0;
        const right = map.get(num + 1) || 0;

        const total = left + right + 1;

        map.set(num, total);
        map.set(num - left, total);
        map.set(num + right, total);

        longest = Math.max(longest, total);
    }

    return longest;
};
