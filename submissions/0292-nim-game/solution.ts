function canWinNim(n: number): boolean {
    let rem : number = n % 4 ;
    if(rem === 0) return false;
    return true;
};
