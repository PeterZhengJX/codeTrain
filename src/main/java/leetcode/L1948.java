package leetcode;

import org.junit.Test;

public class L1948 {
    @Test
    public void test(){
        System.out.println(takeCharacters("ccbcac", 1));
    }

    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] sum = new int[3];
        for (int i = 0; i < n; i++) {
            sum[s.charAt(i) - 'a']++;
        }
        if (sum[0] < k || sum[1] < k || sum[2] < k)
            return -1;

        int ret = 0;
        for (int start = 0, end = 0; end < n; end++) {
            int i = s.charAt(end) - 'a';
            sum[i]--;
            while (sum[i] < k) {
                sum[s.charAt(start) - 'a']++;
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return n - ret;
    }
}
