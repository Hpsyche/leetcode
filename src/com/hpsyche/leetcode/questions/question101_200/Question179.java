package com.hpsyche.leetcode.questions.question101_200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hpsyche
 * Create on 2020/5/29
 */
public class Question179 {
    public String largestNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i]=nums[i]+"";
        }
        Arrays.sort(strs, (str1, str2) -> (str2+str1).compareTo(str1+str2));
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder largestNumberStr = new StringBuilder("");
        for (String numAsStr : strs) {
            largestNumberStr.append(numAsStr);
        }
        return largestNumberStr.toString();
    }
}


//SELECT
//        Department.NAME AS Department,
//        e1.NAME AS Employee,
//        e1.Salary AS Salary
//        FROM
//        Employee AS e1,Department
//        WHERE
//        e1.DepartmentId = Department.Id
//        AND 3 > (SELECT  count( DISTINCT e2.Salary )
//        FROM	Employee AS e2
//        WHERE	e1.Salary < e2.Salary 	AND e1.DepartmentId = e2.DepartmentId 	)
//        ORDER BY Department.NAME,Salary DESC;

