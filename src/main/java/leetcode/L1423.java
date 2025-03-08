package leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1423 {
    @Test
    public void test(){
        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1}, 3));
        System.out.println(maxScore(new int[]{2,2,2}, 2));
        System.out.println(maxScore(new int[]{9,7,7,9,7,7,9}, 7));
        System.out.println(maxScore(new int[]{1,1000,1}, 1));
    }

    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        int sum = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        ans = sum;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
            sum -= cardPoints[cardPoints.length - k + i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
