package leetcode;

import org.junit.Test;

public class L904 {
    @Test
    public void test() {
        System.out.println(totalFruit(new int[]{1, 2, 2}));
        System.out.println(totalFruit(new int[]{0,1,2,2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;
        int ret = 2;
        int[] cnt = new int[fruits.length];
        int total = 0;
        for (int start = 0, end = 0; end < fruits.length; end ++) {
            if (cnt[fruits[end]] == 0) total++;
            cnt[fruits[end]]++;
            while (total > 2) {
                if (cnt[fruits[start]] <= 1) total--;
                cnt[fruits[start]]--;
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}
