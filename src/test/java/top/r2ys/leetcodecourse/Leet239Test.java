package top.r2ys.leetcodecourse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Leet239Test {

    @Test
    void maxSlidingWindow() {
        Leet239 leet239 = new Leet239();
//        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] arr = {2,3,-1,-3,5,3,6,7};
        int[] result = leet239.maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(result));;
    }

}
