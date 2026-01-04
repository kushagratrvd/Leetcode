/**
 * @param {string} word
 * @return {number}
 */
var minTimeToType = function(word) {
    let initial = 'a'; 
    let count = 0;
    for(let i = 0; i < word.length; i++){
        let current = word.charAt(i);
        let time = Math.abs(current.charCodeAt(0)-initial.charCodeAt(0));
        let time2 = Math.min(time,26-time);
        count = count+time2+1;
        initial = current;
    }
    return count;
};
