package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class L2090 {
    @Test
    public void test() {
        int[] arr  = new int[9];
        arr[0] = 7;
        arr[1] = 4;
        arr[2] = 3;
        arr[3] = 9;
        arr[4] = 1;
        arr[5] = 8;
        arr[6] = 5;
        arr[7] = 2;
        arr[8] = 6;
        System.out.println(Arrays.toString(getAverages(arr, 3)));
    }

    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            avgs[i] = -1;
            if (i < 2 * k) {
                continue;
            }
            avgs[i - k] = (int)(sum / (2 * k + 1));
            sum -= nums[i - 2 * k];
        }

        return avgs;
    }
}