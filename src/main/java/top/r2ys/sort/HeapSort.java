package top.r2ys.sort;

import java.util.Arrays;

/**
 * @program: leetcode-course
 * @description: 堆排序，利用完全二叉树，大顶数
 * https://www.cnblogs.com/MOBIN/p/5374217.html
 * https://github.com/r2ys/JS-Sorting-Algorithm/blob/master/7.heapSort.md
 * https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484004&idx=1&sn=ecbafdec3c38ac7a13979aace18569e4&chksm=fa0e6de5cd79e4f3b059d507ac0c6bf9ec916711891f0e92377f0d4bcf9d24319d09ed68d990&scene=21#wechat_redirect
 * @author: HU
 * @create: 2021-02-24 11:18
 */
public class HeapSort implements IArraySort {

    private static void heapSort(int[] arr) {
        int len = arr.length -1;
        for(int i = len/2 - 1; i >=0; i --){ //堆构造
            heapAdjust(arr,i,len);
        }
        while (len >=0){
            swap(arr,0,len--);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大
            heapAdjust(arr,0,len);    //再次对堆进行调整
        }
    }

    public static  void heapAdjust(int[] arr,int i,int len){
        int left,right,j ;
        while((left = 2*i+1) <= len){    //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
            right = left + 1;  //右节点
            j = left;   //j"指针指向左节点"
            if(j < len && arr[left] < arr[right])    //右节点大于左节点
                j ++;     //当前把"指针"指向右节点
            if(arr[i] < arr[j])    //将父节点与孩子节点交换（如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点）
                swap(arr,i,j);
            else         //说明比孩子节点都大，直接跳出循环语句
                break;
            i = j;
        }
    }
    public static  void swap(int[] arr,int i,int len){
        int temp = arr[i];
        arr[i] = arr[len];
        arr[len] = temp;
    }
    public static void main(String[] args) {
        int array[] = {20,50,20,40,70,10,80,30,60};
        System.out.println("排序之前:" + Arrays.toString(array));
        heapSort(array);
        System.out.println("排序之后:" + Arrays.toString(array));
    }

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        return new int[0];
    }
}
