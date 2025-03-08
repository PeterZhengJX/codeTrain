package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class L2904 {
    @Test
    public void test(){
        System.out.println(shortestBeautifulSubstring("100011001", 3));
        System.out.println(shortestBeautifulSubstring("1011", 2));
        System.out.println(shortestBeautifulSubstring("000", 1));
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int cnt1 = 0;
        int shortLen = s.length() + 1;
        List<String> shortList = new ArrayList<>();
        for(int start = 0, end = 0; end < n; end++) {
            if (s.charAt(end) == '1') cnt1++;
            while (cnt1 >= k && start <= end) {
                if (shortLen > end - start + 1) {
                    shortLen = end - start + 1;
                    shortList.clear();
                    shortList.add(s.substring(start, end + 1));
                } else if (shortLen == end - start + 1) {
                    shortList.add(s.substring(start, end + 1));
                }
                if (s.charAt(start) == '1') cnt1--;
                start++;
            }
        }
        if (shortList.size() == 0) return "";

        String ret = shortList.get(0);
        for (int i = 1; i < shortList.size(); i++) {
            String cur = shortList.get(i);
            if (cur.compareTo(ret) < 0) ret = cur;
        }

        return ret;
    }
}
