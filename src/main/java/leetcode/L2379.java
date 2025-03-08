package leetcode;

import org.junit.Test;

public class L2379 {
    @Test
    public void test() {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }

    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int ans = n;
        int wNum = 0;
        for (int i = 0; i < n; i++) {
            if (blocks.charAt(i) == 'W') wNum++;
            if (i + 1 < k) continue;
            ans = Math.min(ans, wNum);
            if (blocks.charAt(i - k + 1) == 'W') wNum--;
        }
        return ans;
    }
}
