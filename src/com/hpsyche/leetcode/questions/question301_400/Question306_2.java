package com.hpsyche.leetcode.questions.question301_400;

/**
 * @author hpsyche
 * Create on 2020/6/19
 */
public class Question306_2 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() == 0) {
            return true;
        }
        for (int i = 1; i < num.length(); i++) {
            if(num.charAt(0)=='0'&&i>1){
                return false;
            }
            for (int j = i + 1; j < num.length(); j++) {
                if(num.charAt(i)=='0'&&j-i>1){
                    break;
                }
                long num1=Long.parseLong(num.substring(0,i));
                long num2=Long.parseLong(num.substring(i,j));
                if(helper(num.substring(j),num1,num2)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(String next, long num1, long num2) {
        if(next.length()==0){
            return true;
        }
        for(int i=1;i<=next.length();i++){
            if(next.charAt(i)=='0'&&i>1){
                return false;
            }
            long sum=Long.parseLong(next.substring(0,i));
            if(sum==num1+num2){
                return helper(next.substring(i),num2,sum);
            }else if(num1+num2<sum){
                break;
            }
        }
        return false;
    }
}
