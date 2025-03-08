package leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class L2841 {
    @Test
    public void test(){
        System.out.println(maxSum(Lists.newArrayList(2,6,7,3,1,7), 3, 4));
        System.out.println(maxSum(Lists.newArrayList(5,9,9,2,4,5,4), 1, 3));
        System.out.println(maxSum(Lists.newArrayList(1,2,1,2,1,2,1), 3, 3));
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        Map<Integer, Integer> diffNums = new HashMap<>();
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Integer num = nums.get(i);
            sum += num;
            if (diffNums.containsKey(num)) diffNums.put(num, diffNums.get(num) + 1);
            else diffNums.put(num, 1);
            if (i + 1 < k) continue;
            if (diffNums.size() >= m) ans = Math.max(ans, sum);
            Integer numBef = nums.get(i - k + 1);
            Integer size = diffNums.get(numBef);
            if (size > 1) diffNums.put(numBef, size - 1);
            else diffNums.remove(numBef);
            sum -= numBef;
        }
        return ans;
    }
}
