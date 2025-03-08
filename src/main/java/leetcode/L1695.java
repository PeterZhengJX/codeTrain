package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class L1695 {
    @Test
    public void test(){
        System.out.println(maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    public int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int ret = nums[0];
        Set<Integer> numSet = new HashSet<>();
        int sum = 0;
        for (int start = 0, end = 0; end < nums.length; end ++) {
            int num = nums[end];
            if (numSet.contains(num)) {
                while (numSet.contains(num)) {
                    numSet.remove(nums[start]);
                    sum -= nums[start];
                    start++;
                }
            }
            numSet.add(num);
            sum += num;
            ret = Math.max(ret, sum);
        }
        return ret;
    }
}
