package leetcode;

import org.junit.Test;

public class L1493 {
    @Test
    public void test () {
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 1}));
        System.out.println(longestSubarray(new int[]{1}));
    }

    public int longestSubarray(int[] nums) {
        int ret = 0;
        int zeroCnt = 0;
        for (int start = 0, end =0; end < nums.length; end++) {
            if (nums[end] == 0) zeroCnt++;
            while (zeroCnt > 1) {
                if (nums[start] == 0) zeroCnt--;
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret > 0 ? ret - 1 : ret;
    }
}
