package com.hpsyche.leetcode.questions.question201_300;

/**
 * @author hpsyche
 * Create on 2020/6/12
 */
public class Question273 {
    private String[] low = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private String[] mid = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] high = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        int part1=num%1000;
        num/=1000;
        int part2=num%1000;
        num/=1000;
        int part3=num%1000;
        num/=1000;
        int part4=num;
        StringBuilder res=new StringBuilder("");
        if(part4!=0){
            res.append(buildNumber(part4)).append("Billion ");
        }
        if(part3!=0){
            res.append(buildNumber(part3)).append("Million ");
        }
        if(part2!=0){
            res.append(buildNumber(part2)).append("Thousand ");
        }
        if(part1!=0){
            res.append(buildNumber(part1));
        }
        return res.toString().trim();
    }

    private String buildNumber(int num) {
        int a=num%10;
        num/=10;
        int b=num%10;
        num/=10;
        int c=num;
        StringBuilder res=new StringBuilder("");
        if(c!=0){
            res.append(low[c]).append(" ").append("Hundred ");
        }
        if(b==1){
            res.append(mid[a]);
        }else if(b==0){
            res.append(low[a]);
        }else{
            res.append(high[b]).append(" ").append(low[a]);
        }
        return res.toString().trim()+" ";
    }
}
