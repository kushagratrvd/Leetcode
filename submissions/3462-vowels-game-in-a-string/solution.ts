function doesAliceWin(s: string): boolean {
    for(let i=0; i<s.length; i++){
        let vow: string = s[i];
        if(vow === 'a' || vow === 'e' || vow === 'i' || vow === 'o' || vow === 'u') return true;
    }
    return false;
};
