impl Solution {
    pub fn does_alice_win(s: String) -> bool {
        for ch in s.chars(){
            if "aeiou".contains(ch){
               return true
            } 
        }
        return false
    }
}
