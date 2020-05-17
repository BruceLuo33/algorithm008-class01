//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)

/**
 5.16 第一遍
 思路一：二分查找。一开始的想法很粗暴，先二分找中间行，再二分找中间列，但这样子一来复杂度就很高，而且代码也很难写。看了评论区，找到了一个非常厉害的操作，通过整除和取模运算将一维的坐标转换为二维。
 思路二：迭代。从矩阵的右上角或者左下角开始比较。这个优势在于每一个数值，都是当下行的最大（对应右上角）或者最小值（对应左下）
 复杂度分析：O（logN）
 */
class Solution {
    // Solution 1:
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int start = 0, mid = 0;
        int row = matrix.length, col = matrix[0].length;
        int end = row * col - 1;
        while (start < end) {
            mid = (start + end) / 2;
            if (matrix[mid / col][mid % col] < target) {
                start = mid + 1;
            } else if (matrix[mid / col][mid % col] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return matrix[start / col][start % col] == target;
    }


    // Solution 2:
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row += 1;
            } else if (matrix[row][col] > target) {
                col -= 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
