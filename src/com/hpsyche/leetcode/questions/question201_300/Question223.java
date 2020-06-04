package com.hpsyche.leetcode.questions.question201_300;

/**
 * @author hpsyche
 * Create on 2020/6/4
 */
public class Question223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA=(C-A)*(D-B);
        int areaB=(G-E)*(H-F);
        // 没有重叠的情况
        if (E >= C || G <= A || F >= D || H <= B) {
            return areaA+areaB;
        }
        //右
        int xR = Math.min(C, G);
        //左
        int xL = Math.max(E, A);
        int width = xR - xL;
        //上
        int yT = Math.min(D, H);
        //下
        int yB = Math.max(F, B);
        int height=yT-yB;
        return areaA+areaB-width*height;
    }
}
