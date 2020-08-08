package com.cheerway.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <pre>
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 *
 * @author : 曹威
 * @since : 2020-07-28  20:39
 */
public class valid_anagram_242 {

    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> chars = new HashMap<>(s.length());
        char[] arr1 = s.toCharArray();
        for (char c : arr1) {
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c)+1);
            } else {
                chars.put(c, 1);
            }
        }
        char[] arr2 = t.toCharArray();
        for (char c : arr2) {
           if (!chars.containsKey(c)) {
               return false;
           } else if (chars.get(c) != 1) {
               chars.put(c, chars.get(c)-1);
           } else {
               chars.remove(c);
           }
        }
        return chars.isEmpty();
    }

    public boolean isAnagram_2(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return String.valueOf(arr1).equals(String.valueOf(arr2));
    }
}
