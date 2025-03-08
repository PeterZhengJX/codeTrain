package leetcode;

import org.junit.Test;

public class L1052 {
    @Test
    public void test() {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) total += customers[i];
            if (grumpy[i] == 1) tmp += customers[i];
            if (i + 1 < minutes) continue;
            max = Math.max(max, tmp);
            if (grumpy[i - minutes + 1] == 1) tmp -= customers[i - minutes + 1];
        }
        return total + max;
    }
}
