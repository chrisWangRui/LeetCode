import java.util.HashSet;
import java.util.Set;

public class Q3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String testString1 = "abcabcbb";
        String testString2 = "bbbbb";
        String testString3 = "pwwkew";
        String testString4 = "dvdf";

        testing(testString1, 1);
        testing(testString2, 1);
        testing(testString3, 1);
        testing(testString4, 1);

        testing(testString1, 2);
        testing(testString2, 2);
        testing(testString3, 2);
        testing(testString4, 2);
    }

    public static int lengthOfLongestSubstring1(String s) {
        String x = "";
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x.contains(s.substring(i, i + 1))) {
                if (x.length() > length) {
                    length = x.length();
                }
                x = x.substring(x.indexOf(s.substring(i, i + 1)) + 1) + s.substring(i, i + 1);
            } else {
                x = x.concat(s.substring(i, i + 1));
                if (x.length() > length) {
                    length = x.length();
                }
            }
        }
        return length;
    }

    // Better one!
    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    public static void testing(String s, int i) {
        if (i == 1) {
            System.out.println("Test Case " + s + ": Length of the longest substring is " + lengthOfLongestSubstring1(s));
        } else {
            System.out.println("Test Case " + s + ": Length of the longest substring is " + lengthOfLongestSubstring2(s));
        }
    }
}
