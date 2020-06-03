package com.hpsyche.leetcode.questions.question801_900;

/**
 * @author hpsyche
 * Create on 2020/6/3
 */
public class Question837 {
    /**
     * 在開始進行後，Alice 必須持續抽牌，直到達到終止條件為止，而終止條件為 '總點數大於等於 K'。
     * 每次抽牌時取得的點數為 1 ~ W ，所以在最後一輪結束後，Alice 的點數必定為 K ~ (K+W-1)。
     * 定義 dp[] 陣列，其大小為 K+W ，dp[x] 代表當前點數為 x 的獲勝機率(最終點數小於等於N)。
     * 我們己知最後一輪的點數必為 K ~ (K+W-1)，所以我們可以先在 dp[] 陣列中，將該區段(K~(K+W-1))
     * 的獲勝機率填入(小於等於N為1.0、大於N為0.0)。
     *
     * 另外，我們再思考如何確認非最後一輪點數的獲勝機率， 對當前點數為 x 的 dp[x] 其值可由下一輪抽牌後的點數回算，如下:
     * dp[x] = (1/W)*( dp[x+1]+dp[x+2]+...+dp[x+W]) , x<K ...(1) 由後向前推算 dp[x]
     * dp[x-1] = (1/W)*( dp[x]+dp[x+1]+...+dp[x-1+W]) , x<K ...(2) 由後向前推算 dp[x-1]
     * 將 式(2) 減去 式(1) 得 式(3)
     * dp[x-1] = dp[x]-(1/W)*( dp[x+W]-dp[x] ) , x<K ...(3) 可以由後向前推算 dp[x-1]
     *
     * 須注意到 x<K 故 x 的最大值為 K-1，故 式(3) 可以推導 dp[K-2] 以下(含)的值，但不含 dp[K-1]。
     *
     * 針對 dp[K-1] 則由 式(1) 來推導( (1/W)*( dp[K]+dp[K+1]+...+dp[K+W-1] ))。
     *
     * 至此我們可以推導出 dp 的所有值，而 dp[0] 值則代表一開始抽牌時的 獲勝機率，也是最後的答案。
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        double[] dp=new double[K+W];
        //用來計算 dp[K-1] 的變數
        double sum=0;
        // 先處理最後一輪的獲勝機率
        for(int i=K;i<K+W;i++){
            // 小於等於N為1.0、大於N為0.0
            dp[i]=i<=N?1.0:0.0;
            // sum=dp[K]+dp[K+1]+...+dp[K+W-1]
            sum+=dp[i];
        }
        //  推導 dp[K-1]
        if(K-1>=0 && W>0) {
            dp[K-1]=sum/W;
        }
        // 從 K-2 開始，由後向前推導出所有的值
        for(int i=K-2;i>=0;i--){
            dp[i]=dp[i+1]-(1.0/W)*(dp[i+1+W]-dp[i+1]);
        }
        return dp[0];
    }
}
