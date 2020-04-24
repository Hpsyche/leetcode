package com.hpsyche.leetcode.questions.question601_700;

/**
 * @author hpsyche
 * Create on 2020/3/21
 */
public class Question657 {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='R'){
                x++;
            }else if(moves.charAt(i)=='L'){
                x--;
            }else if(moves.charAt(i)=='U'){
                y++;
            }else if(moves.charAt(i)=='D'){
                y--;
            }
        }
        return x==0&&y==0;
    }
}
