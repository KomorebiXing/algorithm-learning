package com.algorithm.komorebi.basicalgorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * <p>基本算法</p>
 * <p>1.时间复杂度{@link BasicAlgorithmsTest#timeComplexity()}<p/>
 * <p>2.空间复杂度{@link BasicAlgorithmsTest#spaceComplexity()}<p/>
 * <p>3.选择排序{@link BasicAlgorithmsTest#selectionSort()}<p/>
 * <p>4.冒泡排序{@link BasicAlgorithmsTest#bubbleSort()}<p/>
 */
@Slf4j
public class BasicAlgorithmsTest {


    /**
     * <p>时间复杂度</p>
     * <p>常数时间的操作</p>
     * <p>一个操作如果和样本的数据量没有关系,每次都是固定时间完成的操作,叫做常数操作</p>
     * <p>时间复杂度为一个算法流程中,常数操作数量的一个指标,常用0来表示,具体来说,先要对一个算法流程非常熟悉,然后去些出这个算法流程中,发送了多少常数操作,进而总结出常数操作数据量的表达式</p>
     * <p>在表达式中,只要高阶项,不要低阶项的系数,剩下的部分如果为f(n),那么时间复杂度就是0(f（n）)</p>
     * <p>表达方式：
     * <ol>O表示最差情况</ol>
     * <ol>ol表示最好情况</ol>
     * </p>
     */
    @Test
    public void timeComplexity() {
        // TODO document why this method is empty
    }


    /**
     * <P>空间复杂度</P>
     * <p>需要额外的空间,其实就是空间复杂度</p>
     */
    @Test
    public void spaceComplexity() {
        // TODO document why this method is empty
    }


    /**
     * <p>选择排序</p>
     * <p>选择排序的精髓就是,缩小长度,可以简单理解为从 0 ~ n-1找最小值然后放到0位置上去，依次类推</p>
     * <p>n-1 + n-2 + n-3 ... + n-n 算出的时间复杂度是O(N)</p>
     */
    @Test
    public void selectionSort() {
        int[] ints = {1, 3, 4, 5, 6, 3};
        selectionSort(ints);
        log.info("选择排序结果：{}", Arrays.stream(ints).toArray());
    }

    private void selectionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        // i ~ n-1
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // i ~ n - 1 上找最小值的下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 进行交换
            swap(arr, i, minIndex);
        }

    }


    /**
     * 数组交换方法
     *
     * @param arr 数组
     * @param i   坐标i
     * @param j   坐标j
     */
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * <p>冒泡排序</p>
     */
    @Test
    public void bubbleSort() {

    }


}
