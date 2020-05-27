package com.hpsyche.leetcode.questions.question101_200;

/**
 * @author hpsyche
 * Create on 2020/5/27
 */
public class Question165 {
    public static int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        for(int i=0;i<Math.max(v1.length,v2.length);i++){
            int int1=i<v1.length?Integer.parseInt(v1[i]):0;
            int int2=i<v2.length?Integer.parseInt(v2[i]):0;
            if(int1==int2){
                continue;
            }
            return int1<int2?-1:1;
        }
        return 0;
    }
}
