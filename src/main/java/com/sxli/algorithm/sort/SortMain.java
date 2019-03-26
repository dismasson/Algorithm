package com.sxli.algorithm.sort;

/**
 * 排序算法练习类
 */
public class SortMain {

    /**
     * 冒泡排序
     *
     * @param source 目标数组
     * @return 正序排序后的数组
     */
    public static int[] bubbleSort(int[] source) {
        if (source == null) return null;
        int lenth = source.length;
        for (int i = 0; i < lenth; ++i) {
            // 判断是否需要交换
            boolean flag = false;
            for (int j = 0; j < lenth - i - 1; ++j) {
                if (source[j] > source[j + 1]) {
                    int tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return source;
    }

    /**
     * 插入排序
     *
     * @param source 目标数组
     * @return 正序排序后的数组
     */
    public static int[] insertSort(int[] source) {
        if (source == null) return null;
        int lenth = source.length;
        for (int i = 1; i < lenth; ++i) {
            int value = source[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j > -1; --j) {
                if (source[j] > value) {
                    source[j + 1] = source[j];  // 数据移动
                } else {
                    break;
                }
            }
            source[j + 1] = value;
        }
        return source;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 3, 9, 4, 7};
        numbers = insertSort(numbers);
        for (int i = 0; i < numbers.length; ++i) {
            System.out.println(numbers[i]);
        }
    }

}
