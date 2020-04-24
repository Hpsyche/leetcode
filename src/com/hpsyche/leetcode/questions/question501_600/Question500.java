package com.hpsyche.leetcode.questions.question501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hpsyche
 * Create on 2020/1/30
 */
class Question500 {
    public String[] findWords(String[] words) {
        if (words == null) {
            return null;
        }

        List<String> res = new ArrayList<>();

        String[] lines = new String[] {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };
        for(String word:words){
            if(judge(word.toLowerCase(),lines)){
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean judge(String toLowerCase, String[] lines) {
        boolean flag=true;
        String find=null;
        for(String line:lines){
            //找到所在行
            if(line.indexOf(toLowerCase.charAt(0))>-1){
                find=line;
                break;
            }
        }
        for(int i=1;i<toLowerCase.length();i++){
            if(find.indexOf(toLowerCase.charAt(i))<0){
                flag=false;
                break;
            }
        }
        return flag;
    }

}
