package leetcode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L1838 {
    @Test
    public void test(){
        System.out.println(maxFrequency(new int[]{1,2,4}, 5));
        System.out.println(maxFrequency(new int[]{1,4,8,13}, 5));
        System.out.println(maxFrequency(new int[]{1,1,6}, 2));
    }

    public int maxFrequency(int[] nums, int k) {
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int ret = 1;
        long sum = 0;
        for (int start = 0, end = 0; end < nums.length; end++) {
            if (end > start)
                sum += (long) (end - start) * (nums[end] - nums[end - 1]);
            while (sum > k) {
                sum -= (nums[end] - nums[start]);
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}
