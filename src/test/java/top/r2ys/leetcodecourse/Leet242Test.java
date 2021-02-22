package top.r2ys.leetcodecourse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Leet242Test {

    @Test
    void isAnagram() {
        Leet242 main = new Leet242();
        boolean validAnagram = main.isAnagram("anagram", "nagaram");
        System.out.println(validAnagram);
        validAnagram = main.isAnagram("anagrams", "nagaramt");
        System.out.println(validAnagram);
    }
}