package com.hpsyche.leetcode.mianshi;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/6/22
 */
public class Question16_18 {
    public boolean patternMatching(String pattern, String value) {
        if((pattern.equals("")||pattern.length()==1) && value.equals("")){
            return true;
        }
        int aNum=0;
        int bNum=0;
        for(char c:pattern.toCharArray()){
            if(c=='a'){
                aNum++;
            }else if(c=='b'){
                bNum++;
            }
        }
        int aLength;
        int bLength;
        int patternIndex=0;
        for(int i=1;i<value.length();i++){
            patternIndex=0;
            String currValue=value.substring(0,i);
            String aValue = null;
            String bValue = null;
            char patC=pattern.charAt(patternIndex);
            if(patC=='a'){
                aLength=i;
                if(bNum==0){
                    bLength=0;
                }else {
                    int temp = value.length() - aLength * aNum;
                    if (temp % bNum != 0 || temp < 0) {
                        break;
                    }
                    bLength = temp / bNum;
                    aValue = currValue;
                }
            }else{
                bLength=i;
                if(aNum==0){
                    aLength=0;
                }else {
                    int temp = value.length() - bLength * bNum;
                    if (temp % aNum != 0 || temp < 0) {
                        break;
                    }
                    aLength = temp / aNum;
                    bValue = currValue;
                }
            }
            patternIndex++;
            int j=i;
            while (patternIndex<pattern.length()&&j<value.length()){
                if(pattern.charAt(patternIndex)=='a'){
                    if(j+aLength>value.length()){
                        break;
                    }
                    if(aValue==null){
                        aValue=value.substring(j, j+aLength);
                    }else if(!value.substring(j, j+aLength).equals(aValue)){
                        break;
                    }
                    j+=aLength;
                }else{
                    if(j+bLength>value.length()){
                        break;
                    }
                    if(bValue==null){
                        bValue=value.substring(j,j+bLength);
                    }else if(!value.substring(j,j+bLength).equals(bValue)){
                        break;
                    }
                    j+=bLength;
                }
                patternIndex++;
            }
            if(patternIndex==pattern.length()){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1(){
        System.out.println(patternMatching("bbbaa","xxxxxx"));
    }
}
