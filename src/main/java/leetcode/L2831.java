package leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class L2831 {
    @Test
    public void test(){
        System.out.println(longestEqualSubarray(Lists.newArrayList(1,3,2,3,1,3), 3));
        System.out.println(longestEqualSubarray(Lists.newArrayList(1,1,2,2,1,1), 2));
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer>[] idxLists = new ArrayList[n + 1];
        Arrays.setAll(idxLists, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            idxLists[nums.get(i)].add(i);
        }

        int ret = 1;
        for (int i = 0; i < idxLists.length; i++){
            List idxList = idxLists[i];
            int size = idxList.size();
            if (size < ret) continue;
            for (int start = 0, end = 0; end < size; end++) {
                while ((Integer)idxList.get(end) - (Integer)idxList.get(start) - (end - start) > k) {
                    start++;
                }
                ret = Math.max(ret, end - start + 1);
            }
        }
        return ret;
    }
}
