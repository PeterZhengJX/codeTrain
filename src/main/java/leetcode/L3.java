package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class L3 {
    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int ret = 0;
        Map<Character, Integer> nums = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            Character c = s.charAt(end);
            if (!nums.containsKey(c)) {
                nums.put(c, 1);
                ret = Math.max(ret, nums.size());
            } else {
                nums.put(c, nums.get(c) + 1);
            }
            while (nums.get(c) > 1) {
                char out = s.charAt(start);
                if (nums.containsKey(out) && nums.get(out) > 1) {
                    nums.put(out, nums.get(out) - 1);
                } else {
                    nums.remove(out);
                }
                start++;
            }
        }
        return ret;
    }
}
