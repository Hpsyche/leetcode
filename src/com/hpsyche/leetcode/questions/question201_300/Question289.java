package com.hpsyche.leetcode.questions.question201_300;

import org.junit.Test;

/**
 * @author hpsyche
 * Create on 2020/4/2
 *
 * 遍历 board 中的细胞。
 * 根据数组的细胞状态计算新一轮的细胞状态，这里会用到能同时代表过去状态和现在状态的复合状态。
 *
 * 具体的计算规则如下所示：
 * 规则 1：如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡。这时候，将细胞值改为 -1，代表这个细胞过去是活的现在死了；
 * 规则 2：如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活。这时候不改变细胞的值，仍为 1；
 * 规则 3：如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡。这时候，将细胞的值改为 -1，代表这个细胞过去是活的现在死了。可以看到，因为规则 1 和规则 3 下细胞的起始终止状态是一致的，因此它们的复合状态也一致；
 * 规则 4：如果死细胞周围正好有三个活细胞，则该位置死细胞复活。这时候，将细胞的值改为 2，代表这个细胞过去是死的现在活了。
 * 根据新的规则更新数组；
 * 现在复合状态隐含了过去细胞的状态，所以我们可以在不复制数组的情况下完成原地更新；
 * 对于最终的输出，需要将 board 转成 0，1 的形式。因此这时候需要再遍历一次数组，将复合状态为 2 的细胞的值改为 1，复合状态为 -1 的细胞的值改为 0。
 *
 */
public class Question289 {
    public static final int[] DX={0,0,1,-1,-1,1,1,-1};
    public static final int[] DY={1,-1,0,0,-1,1,-1,1};

    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=0;
                for(int k=0;k<DX.length;k++){
                    int row=i+DX[k];
                    int col=j+DY[k];
                    if(row<0||row>=m||col<0||col>=n){
                        continue;
                    }
                    if(Math.abs(board[row][col])==1){
                        count++;
                    }
                }
                if((board[i][j]==1)&&(count<2||count>3)){
                    board[i][j]=-1;
                }
                if(board[i][j]==0&&count==3){
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]>0){
                    board[i][j]=1;
                }else{
                    board[i][j]=0;
                }
            }
        }
    }


    @Test
    public void test1(){
        int[][] res=new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(res);
    }

}