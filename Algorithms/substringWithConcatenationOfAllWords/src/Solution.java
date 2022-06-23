import java.util.*;

public class Solution {
    /**
     * 30. Substring with Concatenation of All Words
     * 解题思路：
     *  - 使用哈希表记录所有单词 `words` 出现的次数；
     *  - 分别以 0,1,2,...,wordLen-1 为起始点，以 wordLen 为长度对字符串进行分组划分；
     *  - 以滑动窗口的方式对划分后的字符子串进行遍历，记录固定窗口内字符子串出现的次数，与 words 出现的次数进行比对。
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(), wordCount = words.length, wordLen = words[0].length(), allWordsLen = wordLen * wordCount;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> temp = new HashMap<>();
            int count = 0;
            for (int j = i; j + wordLen <= sLen; j += wordLen) {
                String current = s.substring(j, j + wordLen);
                if (!map.containsKey(current)) {
                    count = 0;
                    temp.clear();
                    continue;
                }
                ++count;
                temp.put(current, temp.getOrDefault(current, 0) + 1);
                if (count > wordCount) {
                    String prev = s.substring(j - allWordsLen, j - allWordsLen + wordLen);
                    temp.put(prev, temp.getOrDefault(prev, 0) - 1);
                    if (temp.get(prev) <= 0) temp.remove(prev);
                }
                if (count >= wordCount && temp.equals(map)) ans.add(j + wordLen - allWordsLen);
            }
        }
        return ans;
    }
    // public List<Integer> findSubstring(String s, String[] words) {
    //     List<Integer> ans = new LinkedList<>();
    //     Map<String, Integer> map = new HashMap<>();
    //
    //     for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
    //
    //     int strLen = s.length(), wordCount = words.length, wordLen = words[0].length();
    //     for (int i = 0; i <= strLen - wordCount * wordLen; i++) {
    //         String current = s.substring(i, i + wordLen);
    //         if (map.containsKey(current)) {
    //             if (wordCount == 1) ans.add(i);
    //             else {
    //                 Map<String, Integer> temp = new HashMap<>(map);
    //                 temp.put(current, temp.get(current) - 1);
    //                 for (int j = 1; j < words.length; j++) {
    //                     int begin = i + wordLen * j, end = begin + wordLen;
    //                     if (end <= strLen) {
    //                         String word = s.substring(begin, end);
    //                         if (temp.containsKey(word) && temp.get(word) > 0) {
    //                             temp.put(word, temp.get(word) - 1);
    //                             if (j == words.length - 1) ans.add(i);
    //                         } else break;
    //                     } else return ans;
    //                 }
    //             }
    //         }
    //
    //     }
    //     return ans;
    // }
}
