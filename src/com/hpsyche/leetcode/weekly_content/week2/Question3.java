package com.hpsyche.leetcode.weekly_content.week2;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/12
 */
public class Question3 {
    public String entityParser(String text) {
        text=text.replaceAll("&quot;","\"");
        text=text.replaceAll("&apos;","'");
        text=text.replaceAll("&amp;","&");
        text=text.replaceAll("&gt;",">");
        text=text.replaceAll("&lt;","<");
        text=text.replaceAll("&frasl;","/");
        return text;
    }

    @Test
    public void test1(){
        System.out.println(entityParser("and I quote: &quot;...&quot;"));
    }
}
