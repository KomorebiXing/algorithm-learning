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
 * <p>5.位运算两个题目{@link BasicAlgorithmsTest#bitOne()} {@link BasicAlgorithmsTest#bitTwo()}<p/>
 */
@Slf4j
public class BasicAlgorithmsTest {


    /**
     * <p>时间复杂度</p>
     * <p>常数时间的操作</p>
     * <p>一个操作如果和样本的数据量没有关系,每次都是固定时间完成的操作,叫做常数操作</p>
     * <p>时间复杂度为一个算法流程中,常数操作数量的一个指标,常用0来表示,具体来说,先要对一个算法流程非常熟悉,然后去些出这个算法流程中,发送了多少常数操作,进而总结出常数操作数据量的表达式</p>
     * <p>在表达式中,只要高阶项,不要低阶项的系数,剩下的部分如果为f(n),那么时间复杂度就是0(f（n）),可以理解为等差数列</p>
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
     * <p>位运算的交互</p>
     * <P>异或（^）：不同为1,相同为0,异或运算还可理解为无进位相加</P>
     * <p>具体例子：0 ^ N = N, N ^ N = 0,满足交换率和结合率</p>
     * <p>这个时候就可以推算出下方为什么 i 和 j 为什么会交换了</p>
     * <p>弊端：i位置和j位置的值不能相等,不建议这么用</p>
     *
     * <p>论证</p>
     * <p>i 在中间赋值的时候只有第一次发生了改变,第三次使用了第一次的值</p>
     * <p>1. arr[i] = arr[i] ^ arr[j]</p>
     * <p>2. arr[j] = (arr[i] ^ arr[j]) ^ arr[j]</p>
     * <p>3. arr[j] = arr[i] ^ 0 </p>
     * <p>4. arr[j] = arr[i]</p>
     * <p>3. arr[i] = (arr[i] ^ arr[j]) ^ arr[i]</p>
     * <p>4. arr[i] = arr[j]</p>
     *
     * @param arr 数组
     * @param i   坐标i
     * @param j   坐标j
     */
    public void bitSwap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    /**
     * <p>位运算题目</p>
     * <p>在一个整型数组中,已知只有一种数字出现了奇数次,其他数字都出现了偶数次,找到这个奇数,并且时间复杂度在O(n),空间复杂度在O(1)</p>
     */
    @Test
    public void bitOne() {
        int[] arr = {1, 2, 2, 4, 4, 6, 6, 1, 1};
        int ero = 0;
        for (int i : arr) {
            ero ^= i;
        }
        log.info("奇数值为：{}", ero);
    }

    /**
     * <p>位运算题目</p>
     * <p>在数组中有两种数出现了奇数次,其他所有的数都出现了偶数次,怎么找到这两种数字,并且时间复杂度在O(n),空间复杂度在O(1)</p>
     */
    @Test
    public void bitTwo() {
        int[] ints = {1, 2, 2, 4, 4, 6, 6, 1, 1, 3};
        int ero = 0;
        int one = 0;
        boolean flay = true;
        for (int anInt : ints) {
            ero ^= anInt;
            if (ero != 0 && flay) {
                one = ero;
                flay = false;
            }
        }
        ero = ero ^ one;
        log.info("one为：{},two为：{}", one, ero);
    }

    /**
     * <p>冒泡排序</p>
     * <p>冒泡排序：规则你可以理解为,外层循环就是控制次数,内层循环就是找外层次数n的最大值(做比较),找到最大值之后就,外层循环就n-1,依次类推</p>
     */
    @Test
    public void bubbleSort() {
        int[] ints = {1, 8, 8, 8, 6, 0};
        bubbleSort(ints);
        log.info("冒泡排序结果：{}", Arrays.stream(ints).toArray());
    }

    public void bubbleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        // n次
        for (int i = arr.length - 1; i > 0; i--) {
            // 内层,依次找 0 ~ n - 1 通过两个数字比较 找最大,会一直把最大的值交互到最边界
            for (int j = 0; j < i; j++) {
                // 作比较,进行交互,如果每个位置都要交换就是最差的情况也就是 n 次
                if (arr[j] > arr[j + 1]) {
                    bitSwap(arr, j, j + 1);
                }
            }
        }

    }


}
