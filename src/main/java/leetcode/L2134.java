package leetcode;

import org.junit.Test;

public class L2134 {
    @Test
    public void test() {
        System.out.println(minSwaps(new int[]{0,1,0,1,1,0,0}));
        System.out.println(minSwaps(new int[]{0,1,1,1,0,0,1,1,0}));
        System.out.println(minSwaps(new int[]{1,1,0,0,1}));
        System.out.println(minSwaps(new int[]{1}));
        System.out.println(minSwaps(new int[]{0,0,0}));
        System.out.println(minSwaps(new int[]{1,1,1,0,0,1,0,1,1,0}));
    }

    public int minSwaps(int[] nums) {
        int max = 0;
        int zeroTotal = 0;
        for (int num : nums) {
            if (num == 0) zeroTotal++;
        }

        if(zeroTotal == 0 || zeroTotal == nums.length) return 0;

        int sum = 0;
        for (int i = 0; i < zeroTotal; i++) {
            if (nums[i] == 0) sum++;
        }
        max = sum;
        int in = zeroTotal;
        while(in != zeroTotal - 1) {
            if (nums[in] == 0) sum++;
            int out = (in - zeroTotal + nums.length) % nums.length;
            if (nums[out] == 0) sum--;
            max = Math.max(max, sum);
            in = (in + 1) % nums.length;
        }

        return zeroTotal - max;
    }
}
