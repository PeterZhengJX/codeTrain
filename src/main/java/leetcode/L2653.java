package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class L2653 {
    @Test
    public void test(){
        System.out.println(Arrays.toString(getSubarrayBeauty(new int[]{1,-1,-3,-2,3}, 3, 2)));
        System.out.println(Arrays.toString(getSubarrayBeauty(new int[]{-1,-2,-3,-4,-5}, 2, 2)));
        System.out.println(Arrays.toString(getSubarrayBeauty(new int[]{-3,1,2,-3,0,-3}, 2, 1)));
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int MAXNUM = 50;
        int[] cnt = new int[2*MAXNUM + 1];
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            cnt[MAXNUM + nums[i]]++;
        }
        ret[0] = getX(cnt, x, MAXNUM);
        for (int i = k; i < nums.length; i++) {
            cnt[MAXNUM + nums[i]]++;
            cnt[MAXNUM + nums[i - k]]--;
            ret[i - k + 1] = getX(cnt, x, MAXNUM);
        }
        return ret;
    }

    public int getX(int[] cnt, int x, int Max) {
        int ret = 0;
        int i = 0;
        while (i < Max) {
            x-=cnt[i];
            if (x <= 0)
                return i - Max;
            i++;
        }

        return ret;
    }
}
