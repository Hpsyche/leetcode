package com.hpsyche.leetcode.questions.question801_900;

import java.util.*;

/**
 * @author hpsyche
 * Create on 2020/3/28
 */
public class Question820 {
    /**
     * 解法1
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int count = 0;
        for (String temp : set) {
            count += temp.length() + 1;
        }
        return count;
    }

    /**
     * 解法2
     * @param words
     * @return
     */
    public int minimumLengthEncoding2(String[] words) {
       TrieTree trie=new TrieTree();
       Map<TrieTree,Integer> map=new HashMap<>();
       for(String word:words){
           TrieTree curr=trie;
           for(int j=word.length()-1;j>=0;j--){
               curr=curr.get(word.charAt(j));
           }
           map.put(curr,word.length());
       }
       int res=0;
       for(TrieTree trieTree:map.keySet()){
           //字典树的叶子节点（没有孩子的节点）就代表没有后缀的单词，
           // 统计叶子节点代表的单词长度加一的和即为我们要的答案。
           if(trieTree.count==0){
               res+=map.get(trieTree)+1;
           }
       }
       return res;
    }

    class TrieTree{
        int count;
        TrieTree[] children;
        TrieTree(){
            count=0;
            children=new TrieTree[26];
        }
        public TrieTree get(char c){
            if(children[c-'a']==null){
                children[c-'a']=new TrieTree();
                count++;
            }
            return children[c-'a'];
        }
    }
}