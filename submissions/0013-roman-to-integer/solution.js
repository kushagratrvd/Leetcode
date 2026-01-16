/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let ans = 0;
    let n = s.length;
    for(let i=0; i<n; i++){
        let curr = s.charAt(i);
        if(curr == 'I'){
            if(i+1 < n && s.charAt(i+1) == 'V'){
                ans += 4;
                i++;
            } 
            else if(i+1 < n && s.charAt(i+1) == 'X'){
                ans += 9;
                i++;
            }
            else ans++;
        }
        else if(curr == 'X'){
            if(i+1 < n && s.charAt(i+1) == 'L'){
                ans += 40;
                i++;
            } 
            else if(i+1 < n && s.charAt(i+1) == 'C'){
                ans += 90;
                i++;
            }
            else ans += 10;
        }
        else if(curr == 'C'){
            if(i+1 < n && s.charAt(i+1) == 'D'){
                ans += 400;
                i++;
            } 
            else if(i+1 < n && s.charAt(i+1) == 'M'){
                ans += 900;
                i++;
            }
            else ans += 100;
        }
        else if(curr == 'V'){
            ans += 5;
        }
        else if(curr == 'L'){
            ans += 50;
        }
        else if(curr == 'D'){
            ans += 500;
        }
        else ans += 1000;
    }
    return ans;
};
