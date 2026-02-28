class Solution {

    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        for(int num : nums){
            if(num == 0) zeroes++;
            else if(num == 1) ones++;
            else twos++;
        }
        int curr = 0;
        while(zeroes > 0){
            nums[curr] = 0;
            zeroes--;
            curr++;
        }
        while(ones > 0){
            nums[curr] = 1;
            ones--;
            curr++;
        }
        while(twos > 0){
            nums[curr] = 2;
            twos--;
            curr++;
        }
    }
}

