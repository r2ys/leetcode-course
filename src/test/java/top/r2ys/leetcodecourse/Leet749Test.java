package top.r2ys.leetcodecourse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Leet749Test {

    @Test
    void dailyTemperatures() {
        Leet749 leet749 = new Leet749();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = leet749.dailyTemperatures(arr);
        System.out.println(Arrays.toString(result));;
    }
}