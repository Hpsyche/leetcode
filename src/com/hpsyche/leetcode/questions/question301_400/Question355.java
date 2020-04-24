package com.hpsyche.leetcode.questions.question301_400;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author hpsyche
 * Create on 2020/4/13
 */
public class Question355 {
    private Map<Integer,List<Integer>> followMap;
    private List<Integer> publishTweets;
    private List<Integer> publishUsers;
    /** Initialize your data structure here. */
    public Question355() {
        followMap=new HashMap<>();
        publishTweets=new LinkedList<>();
        publishUsers=new LinkedList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        publishTweets.add(tweetId);
        publishUsers.add(userId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = followMap.get(userId);
        if(list==null){
            list=new LinkedList<>();
            list.add(userId);
        }
        List<Integer> res=new LinkedList<>();
        int count=0;
        for(int i=publishUsers.size()-1;i>=0;i--){
            if(list.contains(publishUsers.get(i))){
                count++;
                res.add(publishTweets.get(i));
            }
            if(count==10){
                break;
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            LinkedList<Integer> tempList = new LinkedList<>();
            tempList.add(followerId);
            tempList.add(followeeId);
            followMap.put(followerId,tempList);
        }else{
            List<Integer> list = followMap.get(followerId);
            list.add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            List<Integer> list = followMap.get(followerId);
            list.remove(Integer.valueOf(followeeId));
        }
    }


    public static void main(String[] args) {
        Question355 twitter = new Question355();

    // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 133);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);
        twitter.postTweet(2, 203);
        twitter.postTweet(2, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);
        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);
        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);
        List<Integer> newsFeed = twitter.getNewsFeed(1);
        for(int i:newsFeed){
            System.out.println(i);
        }
        twitter.postTweet(2, 211);

    }
}
