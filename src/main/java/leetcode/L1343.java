package leetcode;

import org.junit.Test;

public class L1343 {
    @Test
    public void test() {
        int[] arr  = new int[8];
        arr[0] = 2;
        arr[1] = 2;
        arr[2] = 2;
        arr[3] = 2;
        arr[4] = 5;
        arr[5] = 5;
        arr[6] = 5;
        arr[7] = 8;
        System.out.println(numOfSubarrays(arr, 3, 4));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        double sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i];
            if (i  < k - 1) {
                i++;
                continue;
            }
            if (sum / k >= threshold) ans++;
            sum -= arr[i - k + 1];
            i++;
        }
        return ans;
    }
}
