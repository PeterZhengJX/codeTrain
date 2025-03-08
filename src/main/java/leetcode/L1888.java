package leetcode;

import org.junit.Test;

public class L1888 {
    @Test
    public void test() {
        System.out.println(minFlips("111000"));
        System.out.println(minFlips("010"));
        System.out.println(minFlips("1110"));
        System.out.println(minFlips("1"));
        System.out.println(minFlips("01001001101"));
        System.out.println(minFlips("10100101011001111110"));
    }

    public int minFlips(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int ret = 0;
        if (cs.length == 1) return ret;
        if (cs[0] == cs[1]) {
            ret++;
            cs[1] = cs[0] == '1' ? '0' : '1';
        }
        for (int i = 2; i < n; i++) {
            if (cs[i] != cs[i - 2]) {
                ret++;
                cs[i - 2] = cs[i];
            }
        }

        int temp = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                s = s.substring(i, n) + s.substring(0, i);
                break;
            }
        }
        cs = s.toCharArray();
        if (cs[0] == cs[1]) {
            temp++;
            cs[1] = cs[0] == '1' ? '0' : '1';
        }
        for (int i = 2; i < n; i++) {
            if (cs[i] != cs[i - 2]) {
                temp++;
                cs[i - 2] = cs[i];
            }
        }

        return Math.min(ret, temp);
    }
}
