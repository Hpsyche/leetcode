package com.hpsyche.leetcode.questions.question201_300;

import java.util.Stack;

/**
 * @author hpsyche
 * Create on 2020/3/9
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 */
public class Question207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack=new Stack<>();
        int[] count=new int[numCourses];
        //1.获取入度为0的课程，将他们压入栈中
        for(int i=0;i<prerequisites.length;i++){
            count[prerequisites[i][1]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(count[i]==0){
                stack.push(i);
            }
        }
        int exceptCount=0;
        //2.当栈不为空时，取出栈顶元素，将其临界结点的入度减1,
        while (!stack.isEmpty()){
            exceptCount++;
            Integer item = stack.pop();
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][0]==item){
                    count[prerequisites[i][1]]--;
                    if(count[prerequisites[i][1]]==0){
                        stack.push(prerequisites[i][1]);
                    }
                }
            }
        }
        return exceptCount==numCourses;
    }
}
