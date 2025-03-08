package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L2461 {
    @Test
    public void test () {
        System.out.println(maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
        System.out.println(maximumSubarraySum(new int[]{4,4,4}, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> diffNums = new HashMap<>();
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            sum += num;
            if (diffNums.containsKey(num)) diffNums.put(num, diffNums.get(num) + 1);
            else diffNums.put(num, 1);
            if (i + 1 < k) continue;
            if (diffNums.size() >= k) ans = Math.max(ans, sum);
            Integer numBef = nums[i - k + 1];
            Integer size = diffNums.get(numBef);
            if (size > 1) diffNums.put(numBef, size - 1);
            else diffNums.remove(numBef);
            sum -= numBef;
        }
        return ans;
    }
}
