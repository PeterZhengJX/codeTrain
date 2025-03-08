package leetcode;

import org.junit.Test;

public class L2730 {
    @Test
    public void test(){
        System.out.println(longestSemiRepetitiveSubstring("52233"));
        System.out.println(longestSemiRepetitiveSubstring("5494"));
        System.out.println(longestSemiRepetitiveSubstring("1111"));
    }

    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        if (n <= 2) return n;
        int ret = 2;
        int cnt = 0;
        for (int start = 0, end = 1; end < n; end ++) {
            if (s.charAt(end) == s.charAt(end - 1)) cnt++;
            while (cnt > 1) {
                if (s.charAt(start) == s.charAt(start + 1)) cnt--;
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}
