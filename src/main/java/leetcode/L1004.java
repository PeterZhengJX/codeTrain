package leetcode;

import org.junit.Test;

public class L1004 {
    @Test
    public void test(){

    }

    public int longestOnes(int[] nums, int k) {
        int ret = 0;
        int zeroCnt = 0;
        for (int start = 0, end = 0; end < nums.length; end++) {
            if (nums[end] == 0) zeroCnt++;
            while(zeroCnt > k) {
                if (nums[start] == 0) zeroCnt--;
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}
