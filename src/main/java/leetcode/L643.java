package leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;


public class L643 {
    @Test
    public void test() {
        int[] nums = new int[6];
        nums[0] = 1;
        nums[1] = 12;
        nums[2] = -5;
        nums[3] = -6;
        nums[4] = 50;
        nums[5] = 3;
        System.out.println(findMaxAverage(nums, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        double sum = 0;
        int i = 0;
        for (; i < k; i++) {
            sum += nums[i];
        }
        avg = sum / k;
        i = 1;
        while (i + k - 1 < nums.length) {
            sum = sum + nums[i + k - 1] - nums[i - 1];
            avg= Math.max(avg, sum / k);
            i++;
        }
        return avg;
    }
}
