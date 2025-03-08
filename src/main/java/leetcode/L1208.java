package leetcode;

import org.junit.Test;

public class L1208 {
    @Test
    public void test(){
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int ret = 0;
        int n = t.length();
        int cost = 0;
        for (int start = 0, end = 0; end < n; end++) {
            cost += Math.abs(t.charAt(end) - s.charAt(end));
            while (cost > maxCost) {
                cost -= Math.abs(t.charAt(start) - s.charAt(start));
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}
