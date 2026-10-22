
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        count['l' - 'a'] /= 2;
        count['o' - 'a'] /= 2;

        int res = Integer.MAX_VALUE;

        res = Math.min(res, count['b' - 'a']);
        res = Math.min(res, count['a' - 'a']);
        res = Math.min(res, count['l' - 'a']);
        res = Math.min(res, count['o' - 'a']);
        res = Math.min(res, count['n' - 'a']);

        return res;
    }
}
