package com.sxli.algorithm;

import org.junit.Test;

/**
 * 算法练习测试类
 */
public class AlgorythmTest {
    /**
     *BitMap 位图算法
     */
    @Test
    public void bitmap(){
        System.out.println("问题：假如有一千万条不规则的整数储存在irregular这个数组中，" +
                "并且这些不规则的整数不存在重复的数据，请你写出一个算法来给这些不规则的整数" +
                "进行排序，要求效率越高越好!");
        int[] Irregular = {1,3,4,2,5,10,8,9,6,7};

        int[] rule = new int[Irregular.length];

        for(int i=0;i<Irregular.length;i++)
            rule[Irregular[i]-1] = 1;

        System.out.print("正序排序：");
        for(int i=0;i<rule.length;i++){
            if(rule[i]==1)
                System.out.print("\t"+(i+1));
        }

        System.out.print("\n倒序排序：");
        for(int i=rule.length-1;i>=0;i--){
            if(rule[i]==1)
                System.out.print("\t"+(i+1));
        }
    }
}
