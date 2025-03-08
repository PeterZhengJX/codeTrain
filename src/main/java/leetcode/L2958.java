package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class L2958 {
    @Test
    public void test(){
        System.out.println(maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));
        System.out.println(maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 1));
        System.out.println(maxSubarrayLength(new int[]{5,5,5,5,5,5,5}, 4));

    }

    public int maxSubarrayLength(int[] nums, int k) {
        if (nums.length == 1) return 1;
        int ret = 1;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int start = 0, end = 0; end < nums.length; end++) {
            if (cnt.containsKey(nums[end])) cnt.put(nums[end], cnt.get(nums[end]) + 1);
            else cnt.put(nums[end], 1);
            while(cnt.get(nums[end]) > k) {
                if (cnt.containsKey(nums[start]) && cnt.get(nums[start]) <= 1) cnt.remove(nums[start]);
                else cnt.put(nums[start], cnt.get(nums[start]) - 1);
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}
