package leetcode;

import org.junit.Test;

public class L209 {
    @Test
    public void test(){
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ret = nums.length + 1;
        int sum = 0;

        for(int start = 0, end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target && start <= end) {
                ret = Math.min(ret, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return ret == nums.length + 1 ? 0 : ret;
    }
}
