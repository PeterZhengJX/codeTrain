package leetcode;

import org.junit.Test;

public class L1234 {
    @Test
    public void test(){
        System.out.println(balancedString("WQWRQQQW"));
        System.out.println(balancedString("QWER"));
        System.out.println(balancedString("QQWE"));
        System.out.println(balancedString("QQQW"));
        System.out.println(balancedString("QQQQ"));
    }

    public int balancedString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'A']++;
        }
        cnt['Q' - 'A'] = cnt['Q' - 'A'] > n / 4 ? cnt['Q' - 'A'] - n / 4 : 0;
        cnt['W' - 'A'] = cnt['W' - 'A'] > n / 4 ? cnt['W' - 'A'] - n / 4 : 0;
        cnt['E' - 'A'] = cnt['E' - 'A'] > n / 4 ? cnt['E' - 'A'] - n / 4 : 0;
        cnt['R' - 'A'] = cnt['R' - 'A'] > n / 4 ? cnt['R' - 'A'] - n / 4 : 0;

        if (cnt['Q' - 'A'] == 0 && cnt['W' - 'A'] == 0 && cnt['E' - 'A'] == 0 && cnt['R' - 'A'] == 0) return 0;

        int[] cntTmp = new int[26];
        int ret = n;
        for (int start = 0, end = 0; end < n; end++) {
            cntTmp[s.charAt(end) - 'A']++;
            while (cntTmp['Q' - 'A'] >= cnt['Q' - 'A'] && cntTmp['W' - 'A'] >= cnt['W' - 'A']
                    && cntTmp['E' - 'A'] >= cnt['E' - 'A'] && cntTmp['R' - 'A'] >= cnt['R' - 'A']) {
                ret = Math.min(ret, end - start + 1);
                cntTmp[s.charAt(start) - 'A']--;
                start++;
            }
        }

        return ret;
    }
}
