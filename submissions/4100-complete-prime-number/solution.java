class Solution {
    public boolean isPrime(int num){
        if(num == 1) return false;
        int n = num/2;
        for(int i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    public boolean completePrime(int num) {
        String nums = String.valueOf(num);
        char[] chars = nums.toCharArray();
        StringBuilder prefix = new StringBuilder();
        for(int i=0; i<chars.length; i++){
            char ch = chars[i];
            prefix.append(ch);
            int curr = Integer.valueOf(prefix.toString());
            if(!isPrime(curr)) return false;
        }
        StringBuilder suffix = new StringBuilder();
        for(int i=chars.length-1; i>=0; i--){
            char ch = chars[i];
            suffix.append(ch);
            int curr = Integer.valueOf(new StringBuilder(suffix).reverse().toString());
            if(!isPrime(curr)) return false;
        }
        return true;
    }
}
