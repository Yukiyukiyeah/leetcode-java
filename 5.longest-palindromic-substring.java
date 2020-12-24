class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int max_length = 0;
        for(int i = 0; i < s.length(); i++) {
            int cur = Math.max(getLen(i, i, s), getLen(i, i + 1, s));
            if (cur > max_length) {
                max_length = cur;
                start = i - (cur - 1) / 2;
            }
        }
        return s.substring(start, start + max_length);
    }
    private int getLen(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l --;
            r ++;
        }
        return r - l - 1;
    }
}