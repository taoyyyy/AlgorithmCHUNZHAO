//20.12~20.22
//242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/description/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] ret = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ret[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            ret[t.charAt(i) - 'a']--;
        }

        for (int i : ret) {
            if (i != 0) return false;
        }
        return true;
    }
}
