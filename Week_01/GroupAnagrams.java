import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//20.23~20.57
//49. 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
public class GroupAnagrams {

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy(new Function<String, String>() {
            @Override
            public String apply(String s) {
                int[] countArr = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    countArr[s.charAt(i) - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
//                for (int count : countArr) {
//                    if (count != 0) {
//                        sb.append((char) ('a' + count)).append(count);
//                    }
//                }
                for (int i = 0; i < 26; i++) {
                    // 这里的 if 是可省略的，但是加上 if 以后，生成的 sb 更短，后续 groupingBy 会更快。
                    if (countArr[i] != 0) {
                        sb.append((char) ('a' + i));
                        sb.append(countArr[i]);
                    }
                }

                return sb.toString();
            }
        }));

        System.out.println("map = " + map);
        return new ArrayList<>(map.values());
    }
}
