//在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。 
//
// 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成： 
//
// 
// 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角） 
// C_1 位于 (0, 0)（即，值为 grid[0][0]） 
// C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]） 
// 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0） 
// 
//
// 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：[[0,1],[1,0]]
//
//输出：2
//
// 
//
// 示例 2： 
//
// 输入：[[0,0,0],[1,1,0],[1,1,0]]
//
//输出：4
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.5 第一遍
 - 思路：BFS。这实际上是个图的问题，图中的最短路径，一般就要用 bfs 来求：
 1. 将第一个起点放入 queue，同时将其值从 0 改成 1，然后往八个方向走，遇到所有的 0 都替换成 1，然后走完之后 step + 1；
 2. 能这么做的原因是从起点出发，往八个方向各走一步，总会有一个最短路径，能最快到达终点。这就类似于往湖里面扔石头，水波纹不断扩散，到达岸边（终点）的时候，就是最短路径。
 - 复杂度分析：O(N^2)
 */

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        queue.add(new int[]{0,0});
        grid[0][0] = 1;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size -= 1;
                int[] curPos = queue.poll();
                int x = curPos[0], y = curPos[1];
                if (x == m - 1 && y == n - 1) return step;
                for (int[] d : dir) {
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if (!inGird(grid, newX, newY) || grid[newX][newY] == 1)
                        continue;
                    queue.add(new int[]{newX,newY});
                    grid[newX][newY] = 1;
                }
            }
            step += 1;
        }
        return -1;
    }

    private boolean inGird(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 )
            return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
