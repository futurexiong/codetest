package com.xy.codetest;

public class Solution {

    public String removeDuplicatesStage1(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        // use to count the same letter
        int[] count = new int[sb.length()];
        for (int i = 0; i < sb.length() && i >= 0; ++i) {
            if (i == 0) {
                // the first character always counts 1
                count[i] = 1;
            } else if (sb.charAt(i) == sb.charAt(i - 1)) {
                // if the character equals the previous character, the character counts 1 more.
                count[i] = count[i - 1] + 1;
                if (i == sb.length() - 1 && count[i] >= k) {
                    // if the character is the last character and counts more than k.
                    // we should delete those consecutive characters and reset the index to the right place.
                    sb.delete(i - count[i] + 1, i + 1);
                    i = i - count[i] - 1;
                    System.out.println(sb);
                }
            } else {
                // the character is not equals to the previous character
                // than check the previous character's count.
                if (count[i - 1] >= k) {
                    // if the previous character counts more than k,
                    // we should delete those consecutive characters and reset the index to the right place.
                    sb.delete(i - count[i-1], i);
                    i = i - count[i-1] - 1;
                    System.out.println(sb);
                } else {
                    // if the previous character counts less than k, than the char at index i counts 1.
                    count[i] = 1;
                }
            }
        }
        return sb.toString();
    }

    public String removeDuplicatesStage2(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        // use to count the same letter
        int[] count = new int[sb.length()];
        for (int i = 0; i < sb.length() && i >= 0; ++i) {
            if (i == 0) {
                // the first character always counts 1
                count[i] = 1;
            } else if (sb.charAt(i) == sb.charAt(i - 1)) {
                // if the character equals the previous character, the character counts 1 more.
                count[i] = count[i - 1] + 1;
                // if the character is the last character and counts more than k.
                // we should replace those consecutive characters and reset the index to the right place.
                if (i == sb.length() - 1 && count[i] >= k) {
                    char c = sb.charAt(i - 1);
                    char preChar = (char) (c-1);// char a codepoint 97
                    sb.delete(i + 1 - count[i], i + 1);
                    i = i - count[i];
                    // "bbb" should be replaced by "a", "aaa" should be replaced by "".
                    // so if we just delete "aaa", we would not insert any char here.
                    if (preChar >= "a".charAt(0)) {
                        sb.insert(i + 1, preChar);
                    }
                    System.out.println(sb);
                }
            } else {
                // the character is not equals to the previous character
                // than check the previous character's count.
                if (count[i - 1] >= k) {
                    // if the previous character counts more than k,
                    // we should replace those consecutive characters and reset the index to the right place.
                    char c = sb.charAt(i - 1);
                    char preChar = (char) (c-1);// char a codepoint 97
                    sb.delete(i - count[i-1], i);
                    i = i - 1 - count[i - 1];
                    // "bbb" should be replaced by "a", "aaa" should be replaced by "".
                    // so if we just delete "aaa", we would not insert any char here.
                    if (preChar >= "a".charAt(0)) {
                        sb.insert(i + 1, preChar);
                    }
                    System.out.println(sb);
                } else {
                    // if the previous character counts less than k, than the char at index i counts 1.
                    count[i] = 1;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicatesStage1("atttbcccbbaa", 3));
        System.out.println(new Solution().removeDuplicatesStage1("abcccbaaetpppoottuuuaabbbbccdddd", 3));
        System.out.println("==================");
        System.out.println(new Solution().removeDuplicatesStage2("abcccbaaetpppoottuuuaabbbbccdddd", 3));
    }
}
