package leetcode;

import org.junit.Test;

public class L3090 {
    @Test
    public void test() {
        System.out.println(maximumLengthSubstring("bcbbbcba")); // 4
        System.out.println(maximumLengthSubstring("aaaa"));
    }

    public int maximumLengthSubstring(String s) {
        int ret = 2;
        int n = s.length();
        int[] hash = new int[26];
        for (int start = 0, end = 0; end < n; end++) {
            int i = s.charAt(end) - 'a';

            hash[i]++;
            while (hash[i] > 2) {
                hash[s.charAt(start) - 'a']--;
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}
