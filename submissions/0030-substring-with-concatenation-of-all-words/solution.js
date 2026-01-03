/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function (s, words) {
    if (words.length === 0) return [];

    const wordLen = words[0].length;
    const wordCount = words.length;
    const windowLen = wordLen * wordCount;

    const freq = new Map();
    for (const w of words) {
        freq.set(w, (freq.get(w) || 0) + 1);
    }

    const result = [];

    for (let offset = 0; offset < wordLen; offset++) {
        let left = offset;
        let count = 0;
        const seen = new Map();

        for (let right = offset; right + wordLen <= s.length; right += wordLen) {
            const word = s.substring(right, right + wordLen);

            if (freq.has(word)) {
                seen.set(word, (seen.get(word) || 0) + 1);
                count++;

                while (seen.get(word) > freq.get(word)) {
                    const leftWord = s.substring(left, left + wordLen);
                    seen.set(leftWord, seen.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count === wordCount) {
                    result.push(left);
                }
            } else {
                seen.clear();
                count = 0;
                left = right + wordLen;
            }
        }
    }

    return result;
};

