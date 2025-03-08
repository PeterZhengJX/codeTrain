package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1297 {
    @Test
    public void test() {
        System.out.println(maxFreq("aababcaab", 2, 3, 4));
        System.out.println(maxFreq("aaaa", 1, 3, 3));
        System.out.println(maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(maxFreq("abcde", 2, 3, 3));
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Map<String, Integer> numMap = new HashMap<>();
        int[] letter = new int[26];
        String maxNumSubString = null;
        int maxNum = 0;
        int letters = 0;
        int i = 0;
        for (; i < minSize; i++) {
            int c = s.charAt(i) - 'a';
            if (letter[c] == 0) letters++;
            letter[c]++;
        }
        if (letters <= maxLetters) {
            maxNumSubString = s.substring(0, minSize);
            maxNum = 1;
            numMap.put(maxNumSubString, maxNum);
        }
        int start = 0;
        for(int end = minSize; end < n; end++) {
            int in = 0;
            in = s.charAt(end) - 'a';
            if (letter[in] == 0) letters++;
            letter[in]++;
            if ((end - start + 1) <= maxSize && letters <= maxLetters) {
                String temp = s.substring(start, end + 1);
                int tempNum = 0;
                if (numMap.containsKey(temp)) tempNum = numMap.get(temp);
                tempNum++;
                numMap.put(temp, tempNum);
                if (tempNum > maxNum) {
                    maxNum = tempNum;
                }
            }

            i = start;
            int out = 0;
            int[] tempLetter = Arrays.copyOf(letter, 26);
            int tempLetters = letters;
            int tempStart = start;
            while((end - i) >= minSize){
                out = s.charAt(i) - 'a';
                letter[out]--;
                if (letter[out] == 0) letters--;
                if (letters <= maxLetters) {
                    String temp = s.substring(i + 1, end + 1);
                    int tempNum = 0;
                    if (numMap.containsKey(temp)) tempNum = numMap.get(temp);
                    tempNum++;
                    numMap.put(temp, tempNum);
                    if (tempNum > maxNum) {
                        maxNum = tempNum;
                    }
                }
                i++;
            }

            start = Math.max(end - maxSize + 1, start);
            letter = Arrays.copyOf(tempLetter, 26);
            letters = tempLetters;
            if (tempStart != start) {
                out = s.charAt(tempStart) - 'a';
                letter[out]--;
                if (letter[out] == 0) letters--;
            }
        }
        return maxNum;
    }
}
