class Solution {
    public int mySqrt(int x) {
        int low=0;
        int high = x/2+1;
        long mid = 0;
        while(low <= high){
            mid = low + (high-low)/2;
            if(mid*mid < x) low=(int)mid+1;
          else if(mid*mid>x) high=(int)mid-1;
else return (int)mid;
}
        if(mid*mid > x) return (int)mid-1;
        
return (int)mid;
    }
}
