class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length() == 0) return 0;
        //System.out.println(s);
        char c = s.charAt(0);
        boolean flag = false;
        long sum = 0;
        int i=0;
        if(c == '-'){
            flag = true;
            i++;
        }
        else if(c == '+'){
            i++;
        }
        for(int j=i; j<s.length(); j++){
            c = s.charAt(j);
            //System.out.println(c);
            if(c >= 48 && c < 58){
                //System.out.println(Long.valueOf(c));

                sum = (long)(sum * 10 + c - '0');
                if(sum > Integer.MAX_VALUE){
                    if(flag) sum = Integer.MIN_VALUE;
                    else sum = Integer.MAX_VALUE;
                    break;
                }
            }
            else break;
        }
        if(flag) sum *= -1;
        
        return (int)sum;

    }
}
