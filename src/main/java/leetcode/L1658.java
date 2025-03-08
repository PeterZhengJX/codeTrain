package leetcode;

import org.junit.Test;

public class L1658 {
    @Test
    public void test(){

    }

    public int minOperations(int[] nums, int x) {
        int ret = nums.length + 1;
        int sum = 0;
        for (int start = 0, end = 0; end < 2 * nums.length; end++) {
            sum += nums[end % nums.length];
            while (sum > x) {
                sum -= nums[start % nums.length];
                start++;
            }
            if (sum == x && (start % nums.length == 0 || end % nums.length == nums.length - 1 || start % nums.length >= end % nums.length))
                ret = Math.min(ret, end - start + 1);
        }
        return ret == nums.length + 1 ? -1 : ret;
    }
}
