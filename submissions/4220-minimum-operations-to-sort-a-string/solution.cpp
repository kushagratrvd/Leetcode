class Solution {
public:
    int minOperations(string s) {
        int n = s.size();
        string act = s;
        sort(s.begin(),s.end());
        if(s == act) return 0;
        if(s.size() < 3) return -1;
        string sub1 = act.substr(0,n-1);
        cout<<sub1<<endl;
        sort(sub1.begin(),sub1.end());
        cout<<sub1<<endl;
        string sub2 = act.substr(1,n);
        sort(sub2.begin(),sub2.end());
        string reverse1 = act;
        cout<<s<<endl;
        cout<<sub1 + act.substr(n-1,n);
        reverse(reverse1.begin(),reverse1.end());
        if(sub1 + act.substr(n-1,n) == s || act.substr(0,1) + sub2 == s ){
            return 1;
        }
        
        // else if(reverse1 == s){
        //     return 3;
        // }
        else{
            sub1 += act.substr(n-1,n);
            string nestedsub1 = sub1.substr(1,sub1.size());
            sort(nestedsub1.begin(),nestedsub1.end());
            sub2 = act.substr(0,1) + sub2;
            string nestedsub2 = sub2.substr(0,sub2.size()-1);
            sort(nestedsub2.begin(),nestedsub2.end());
            if(sub1.substr(0,1) + nestedsub1 == s || nestedsub2 + sub2.substr(sub2.size()-1,sub2.size()) == s) return 2;
            return 3;
        }
    }
};
