class Solution {
    public int convertTime(String current, String correct) {
        int curr = Integer.valueOf(current.substring(0,2))*60;
        curr += Integer.valueOf(current.substring(3,5));
        int target = Integer.valueOf(correct.substring(0,2))*60;
        target += Integer.valueOf(correct.substring(3,5));
        int time = target - curr;
        int count = 0;
        while(time > 0){
            if(time >= 60){
                count += time/60;
                time = time%60;
            }
            else if(time >= 15){
                count += time/15;
                time = time%15;
            }
            else if(time >= 5){
                count += time/5;
                time = time%5;
            }
            else{
                count += time/1;
                time = 0;
            }
        }
        return count;
    }
}
