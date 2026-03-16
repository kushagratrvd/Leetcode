import java.util.*;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        String act = s;
        
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = new String(arr);

        if(s.equals(act)) return 0;
        if(s.length() < 3) return -1;

        String sub1 = act.substring(0, n - 1);
        System.out.println(sub1);

        char[] sub1Arr = sub1.toCharArray();
        Arrays.sort(sub1Arr);
        sub1 = new String(sub1Arr);
        System.out.println(sub1);

        String sub2 = act.substring(1, n);
        char[] sub2Arr = sub2.toCharArray();
        Arrays.sort(sub2Arr);
        sub2 = new String(sub2Arr);

        String reverse1 = new StringBuilder(act).reverse().toString();

        System.out.println(s);
        System.out.println(sub1 + act.substring(n - 1, n));

        if((sub1 + act.substring(n - 1, n)).equals(s) || (act.substring(0, 1) + sub2).equals(s)){
            return 1;
        } 
        else {
            sub1 += act.substring(n - 1, n);

            String nestedsub1 = sub1.substring(1);
            char[] nested1Arr = nestedsub1.toCharArray();
            Arrays.sort(nested1Arr);
            nestedsub1 = new String(nested1Arr);

            sub2 = act.substring(0, 1) + sub2;

            String nestedsub2 = sub2.substring(0, sub2.length() - 1);
            char[] nested2Arr = nestedsub2.toCharArray();
            Arrays.sort(nested2Arr);
            nestedsub2 = new String(nested2Arr);

            if((sub1.substring(0,1) + nestedsub1).equals(s) || 
               (nestedsub2 + sub2.substring(sub2.length()-1)).equals(s))
                return 2;

            return 3;
        }
    }
}
