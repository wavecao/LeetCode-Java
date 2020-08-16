package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.List;

public class game24 {

    public boolean judgePoint24(int[] nums) {
        //加油
        List<Double> nowNums = new ArrayList<>();
        for(int num:nums)
            nowNums.add((double)num);
        return dfs(nowNums);
    }
    public boolean dfs(List<Double>nowNums)
    {   
        /*
        if(nowNums.size()==0)
            return false;
            */
        if(nowNums.size()==1)
            //浮点数有问题
            return (Math.abs(nowNums.get(0)-24)<1e-6);
        //当四个的时候，第一次选两个数时有4*3种，之后选运算符为12*4=48，
        //然后3个选两个为3*2种，之后选运算符：6*4 = 24；
        //最后2个选运算符：2*4种（有先后顺序之分哦）
        //不过+和*满足交换律
        for(int i=0;i<nowNums.size();i++)
        {
            for(int j=0;j<nowNums.size();j++)
            {
                if(i==j)
                    continue;
                List<Double>newNums = new ArrayList<>();
                for(int k=0;k<nowNums.size();k++)
                {
                //不能添加i，j因为i和j所在位置的数接下里我们要进行计算，
                    if(k!=i&k!=j)
                    {
                        newNums.add(nowNums.get(k));
                        }
                }
                //+*-/
                for(int times = 0;times<4;times++)
                {
                    //加和乘满足交换律
                    if(times<2&&j>i)
                        continue;
                    if(times==0) newNums.add(nowNums.get(i)+nowNums.get(j));
                    if(times==1) newNums.add(nowNums.get(i)*nowNums.get(j));
                    if(times==2) newNums.add(nowNums.get(i)-nowNums.get(j));
                    if(times==3)
                        {
                            if(nowNums.get(j)!=0)
                                newNums.add(nowNums.get(i)/nowNums.get(j));
                            else
                                continue;
                        }
                    //一路递归找到了结果
                    if(dfs(newNums)) return true;
                    //之前添加的那个运算符不行，扔了之前那个结果吧,回溯到之前选择运算符
                    newNums.remove(newNums.size()-1);
                }
            }
        }
        //一个都不行
        return false;
    }
}
