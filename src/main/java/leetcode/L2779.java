package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class L2779 {
    @Test
    public void test(){
        System.out.println(maximumBeauty(new int[]{4,6,1,2}, 2));
        System.out.println(maximumBeauty(new int[]{1,1,1,1}, 10));
    }

    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1) return nums.length;
        Arrays.sort(nums);
        int ret = 1;
        for (int start = 0, end = 0; end < nums.length; end++) {
            while (nums[end] - nums[start] > 2 * k) {
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}

