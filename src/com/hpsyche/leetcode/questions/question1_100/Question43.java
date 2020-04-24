package com.hpsyche.leetcode.questions.question1_100;

/**
 * @author hpsyche
 * Create on 2020/4/19
 */
public class Question43 {
    /**
     num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
     例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中
     index:    0 1 2 3 4

     1 2 3
     *     4 5
     ---------
     1 5
     1 0
     0 5
     ---------
     0 6 1 5
     1 2
     0 8
     0 4
     ---------
     0 5 5 3 5
     这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中
     **/
    public String multiply(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        int[] mul=new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int bitMul=((num1.charAt(i)-'0')*(num2.charAt(j)-'0'));
                // 先加低位判断是否有新的进位
                bitMul+=mul[i+j+1];
                mul[i+j]+=bitMul/10;
                mul[i+j+1]=bitMul%10;
            }
        }
        StringBuilder sb=new StringBuilder("");
        int i=0;
        while (i<mul.length-1&&mul[i]==0){
            i++;
        }
        for(;i<mul.length;i++){
            sb.append(mul[i]);
        }
        return sb.toString();
    }
}
