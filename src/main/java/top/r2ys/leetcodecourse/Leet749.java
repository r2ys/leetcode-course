package top.r2ys.leetcodecourse;

import java.util.*;

/**
 * @program: leetcode-course
 * TODO
 * @description: 隔离病毒
 * https://leetcode-cn.com/problems/contain-virus/solution/ge-chi-bing-du-by-leetcode/
 * @author: HU
 * @create: 2021-02-10 14:53
 */
public class Leet749 {

    Set<Integer> seen;
    List<Set<Integer>> regions;
    List<Set<Integer>> frontiers;
    List<Integer> perimeters;
    int[][] grid;
    int row, column;
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    public int containVirus(int[][] matrix) {
        this.grid = matrix;
        row = matrix.length;
        column = matrix[0].length;

        int ans = 0;
        while (true) {
            seen = new HashSet();
            regions = new ArrayList();
            frontiers = new ArrayList();
            perimeters = new ArrayList();

            for (int r = 0; r < row; ++r) {
                for (int c = 0; c < column; ++c) {
                    if (matrix[r][c] == 1 && !seen.contains(r* column + c)) {
                        regions.add(new HashSet());
                        frontiers.add(new HashSet());
                        perimeters.add(0);
                        dfs(r, c);
                    }
                }
            }

            if (regions.isEmpty()) break;
            int triageIndex = 0;
            for (int i = 0; i < frontiers.size(); ++i) {
                if (frontiers.get(triageIndex).size() < frontiers.get(i).size())
                    triageIndex = i;
            }
            ans += perimeters.get(triageIndex);

            for (int i = 0; i < regions.size(); ++i) {
                if (i == triageIndex) {
                    for (int code: regions.get(i))
                        matrix[code / column][code % column] = -1;
                } else {
                    for (int code: regions.get(i)) {
                        int r = code / column, c = code % column;
                        for (int k = 0; k < 4; ++k) {
                            int nr = r + dr[k], nc = c + dc[k];
                            if (nr >= 0 && nr < row && nc >= 0 && nc < column && matrix[nr][nc] == 0)
                                matrix[nr][nc] = 1;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(int r, int c) {
        if (!seen.contains(r* column + c)) {
            seen.add(r* column + c);
            int N = regions.size();
            regions.get(N - 1).add(r* column + c);
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (grid[nr][nc] == 1) {
                        dfs(nr, nc);
                    } else if (grid[nr][nc] == 0){
                        frontiers.get(N - 1).add(nr* column + nc);
                        perimeters.set(N - 1, perimeters.get(N - 1) + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Leet749 leet749 = new Leet749();

        // return 10
        int[][] virusGrid = new int[][]{
                {0,1,0,0,0,0,0,1},
                {0,1,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0}};

        // return 4
        int[][] virusGrid2 = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        // return 13
        int[][] virusGrid3 = new int[][]{
                {1,1,1,0,0,0,0,0,0},
                {1,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,0,0,0,0}
        };
        int i = leet749.containVirus(virusGrid);
        int i2 = leet749.containVirus(virusGrid2);
        int i3 = leet749.containVirus(virusGrid3);
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);

        for (int j = 0; j < 5; j++) {
            System.out.println(j);
        }

        System.out.println("\n");
        for (int j = 0; j < 5; ++j) {
            System.out.println(j);
        }

        int k = 0;
        int k2 = 0;

        System.out.println(k++);
        System.out.println(++k2);
    }

}
