package leetcode;

import org.junit.Test;

public class L2024 {
    @Test
    public void test(){
        System.out.println(maxConsecutiveAnswers("TTFF", 2));
        System.out.println(maxConsecutiveAnswers("TFFT", 1));
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
        System.out.println(maxConsecutiveAnswers("FFFTTFTTFT", 3));
        System.out.println(maxConsecutiveAnswers("FFTFTTTFFF", 1));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        if (n == 1) return 1;
        int ret = 1;
        boolean sign = true;
        int diff = 0;
        for (int start = 0, end = 0; end < n; end++) {
            if ((answerKey.charAt(end) == 'F' && sign) || answerKey.charAt(end) == 'T' && !sign) {
                diff++;
            }
            if (end - start + 1 - diff < diff) {
                diff = end - start + 1 - diff;
                sign = !sign;
            }
            while (diff > k) {
                if (end - start + 1 - diff < diff) {
                    diff = end - start + 1 - diff;
                    sign = !sign;
                    continue;
                }
                if ((answerKey.charAt(start) == 'F' && sign) || answerKey.charAt(start) == 'T' && !sign) {
                    diff--;
                }
                start++;
            }
            ret = Math.max(ret, end - start + 1);
        }
        return ret;
    }
}
