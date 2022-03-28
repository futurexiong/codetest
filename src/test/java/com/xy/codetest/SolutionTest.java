package com.xy.codetest;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void removeDuplicatesStage1() {
        Solution solution = new Solution();
        Assert.assertEquals("ad", solution.removeDuplicatesStage1("ad", 3));
        Assert.assertEquals("d", solution.removeDuplicatesStage1("aabcccbbad", 3));
        Assert.assertEquals("", solution.removeDuplicatesStage1("atttbcccbbaa", 3));
        Assert.assertEquals("b", solution.removeDuplicatesStage1("buuyyyaabbbau", 3));
        Assert.assertEquals("", solution.removeDuplicatesStage1("buuyyyaabbbaubbbb", 3));
    }

    @Test
    public void removeDuplicatesStage2() {
        Solution solution = new Solution();
        Assert.assertEquals("d", solution.removeDuplicatesStage2("abcccbad", 3));
        Assert.assertEquals("a", solution.removeDuplicatesStage2("a", 3));
        Assert.assertEquals("aa", solution.removeDuplicatesStage2("aa", 3));
        Assert.assertEquals("a", solution.removeDuplicatesStage2("bbb", 3));
        Assert.assertEquals("jgkkfiuiiffdscsgfgj", solution.removeDuplicatesStage2("jhhhkkfiuiiffdtttcsgfgj", 3));
        Assert.assertEquals("etnsb", solution.removeDuplicatesStage2("abcccbaaetpppoottuuuaabbbbccdddd", 3));
    }
}