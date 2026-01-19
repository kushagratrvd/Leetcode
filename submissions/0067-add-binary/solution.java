class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int m = a.length();
        int n = b.length();
        StringBuilder ans = new StringBuilder();
        int i=0,j=0;
        for(i=0,j=0; i<m && j<n; i++,j++){
            char currA = a.charAt(m-i-1); 
            char currB = b.charAt(n-j-1);
            if(currA == '1' && currB == '1'){
                if(carry == 0){
                    carry = 1;
                    ans.append("0");
                }
                else ans.append("1");
            }
            else if(currA == '1' || currB == '1'){
                if(carry == 0){
                    ans.append("1");
                }
                else{
                    ans.append("0");
                } 
            }
            else{
                if(carry == 0){
                    ans.append("0");
                }
                else{
                    ans.append("1");
                    carry = 0;
                } 
            }
        }
        while(i<m){
            char currA = a.charAt(m-i-1); 
            if(currA == '1' && carry == 1){
                ans.append("0");
                carry = 1;
            }
            else if(currA == '1' && carry == 0){
                ans.append("1");
            }
            else{
                if(carry == 0) ans.append("0");
                else{
                    ans.append("1");
                    carry = 0;
                }
            } 
            i++;     
        }
        while(j<n){
            char currB = b.charAt(n-j-1); 
            if(currB == '1' && carry == 1){
                ans.append("0");
                carry = 1;
            }
            else if(currB == '1' && carry == 0){
                ans.append("1");
            }
            else{
                if(carry == 0) ans.append("0");
                else{
                    ans.append("1");
                    carry = 0;
                }
            }  
            j++;    
        }
        if(carry == 1) ans.append("1");
        return ans.reverse().toString();
    }
}
