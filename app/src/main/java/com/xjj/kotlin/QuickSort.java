package com.xjj.kotlin;

/**
 * Describe: 快速排序
 *
 * @author xujingjing
 * @date 2018/10/26 0026
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {2,10,5,7,6,5};
       quicksort(a,0,a.length-1);
       // MaopaoSort(a);
        for (int i:a){
            System.out.println("i = [" + i + "]");
        }
    }

    /**
     * 快速排序
     * @param array
     * @param start
     * @param end
     */
    private static void quicksort(int[] array, int start, int end){
        if (start<end){
            int i = start;
            int j = end;
            int temp = array[i];
            while (i<j){
                while (i<j && array[j]>temp){
                    j--;
                }
                array[i] = array[j];
                while (i<j && array[i]<=temp){
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = temp;
            quicksort(array,start,i-1);
            quicksort(array,j+1,end);
        }
    }

    /**
     * 冒泡排序
     * @param array
     */
    private static void MaopaoSort(int[] array){
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j <array.length-i-1 ; j++) {
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
