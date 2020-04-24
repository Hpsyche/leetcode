package com.hpsyche.leetcode.questions.question801_900;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/4/11
 */
public class Question887 {
    private Map<String,Integer> map=new HashMap<>();
    public int superEggDrop(int K, int N) {
        return helper(K,N);
    }

    /**
     * 超出时间复杂度
     * @param K
     * @param N
     * @return
     */
//    private int helper(int K, int N) {
//        if(K==1){
//            return N;
//        }
//        if(N==0){
//            return 0;
//        }
//        if(map.containsKey(K+":"+N)){
//            return map.get(K+":"+N);
//        }
//        int res=Integer.MAX_VALUE;
//        for(int i=1;i<= N;i++) {
//            res=Math.min(res,
//                    Math.max(
//                            helper(K, N-i), helper(K-1,i-1)
//                    )+1
//            );
//        }
//        map.put(K+":"+N,res);
//        return res;
//    }


    private int helper(int K, int N) {
        if(K==1){
            return N;
        }
        if(N==0){
            return 0;
        }
        if(map.containsKey(K+":"+N)){
            return map.get(K+":"+N);
        }
        int low=1;
        int high=N;
        int res=Integer.MAX_VALUE;
        while (low<=high){
            int mid=(low+high)>>1;
            //碎
            int broken=helper(K-1,mid-1);
            //没碎
            int noBroken=helper(K,N-mid);
            if(broken>noBroken){
                high=mid-1;
                res=Math.min(res,broken+1);
            }else{
                low=mid+1;
                res=Math.min(res,noBroken+1);
            }
        }
        map.put(K+":"+N,res);
        return res;
    }

    @Test
    public void test1(){
        System.out.println(superEggDrop(1,2));
        System.out.println(superEggDrop(2,6));
        System.out.println(superEggDrop(3,14));
    }
}
