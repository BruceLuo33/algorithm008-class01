//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.14 第一遍
 思路：核心步骤在于先找到第一个值为 1 的点，然后找到所有与之相邻的值为 1 的点，如果找不到了，则将 count + 1，然后继续遍历。同时为了避免出现重复循环的问题以及数组越界的问题，我们需要两个措施：
 1. 将已经走过的地方从 1 -> 2，防止多次循环。`grid[i][j] = 2`
 2. 右方和下方都不能超过二维数组的边界。`if (i < 0 || j < 0 || i < grid.length - 1 || j < gird[0].length - 1 || grid[i][j] != '1')`
 注意：给定的是 char 数组，而不是 int 数组。
 */
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    isIsland(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void isIsland(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1  || j < 0 || j > grid[0].length - 1 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        isIsland(grid, i + 1, j);
        isIsland(grid, i, j + 1);
        isIsland(grid, i - 1, j);
        isIsland(grid, i, j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
