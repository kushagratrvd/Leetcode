class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int n1 = a.length();
        int n2 = b.length();
        int i=n1-1;
        int j=n2-1;
        StringBuilder s = new StringBuilder();
        while(i >= 0 && j >= 0){
            char first = a.charAt(i);
            char second = b.charAt(j);
            if(first == '1' && second == '1'){
                if(carry == 1){
                    s.append('1');
                }
                else{
                    carry = 1;
                    s.append('0');
                }
            }
            else if(first == '1' || second == '1'){
                if(carry == 1){
                    s.append('0');
                    //carry = 1;
                }
                else{
                    s.append('1');
                    //carry = 0;
                }
            }
            else{
                if(carry == 1){
                    s.append('1');
                    carry = 0;
                }
                else s.append('0');
            }
            i--;
            j--;
        }
        while(i >= 0){
            char first = a.charAt(i);
            if(first == '1'){
                if(carry == 1){
                    s.append('0');
                }
                else{
                    s.append('1');
                }
            }
            else{
                if(carry == 1){
                    s.append('1');
                    carry = 0;
                }
                else s.append('0');
            }
            i--;
        }
        while(j >= 0){
            char first = b.charAt(j);
            if(first == '1'){
                if(carry == 1){
                    s.append('0');
                }
                else{
                    s.append('1');
                }
            }
            else{
                if(carry == 1){
                    s.append('1');
                    carry = 0;
                }
                else s.append('0');
            }
            j--;
        }
        if(carry == 1) s.append('1');
        return s.reverse().toString();
    }
}
