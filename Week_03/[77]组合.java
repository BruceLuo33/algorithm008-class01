//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 5.9 第一遍
    // 思路：回溯算法。和 46 题的思路非常相似，都是需要利用到回溯。
    // 1. track 要创建为 LinkedList<>() 对象，这样在回退状态的时候可以用 removeLast 方法，如果不创建为这个对象，需要改写成这样：`track.remove(track.size() - 1);`
    // 2. for 循环的判断，i <= n 而不仅仅是 <。因为 start 是从 1 开始取并且 n 是可以取得到的。

    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0) return ans;
        List<Integer> track = new LinkedList<>();
        backtrack(n, track, k, 1);
        return ans;
    }

    private void backtrack(int n, List<Integer> track, int k, int start) {
        if (track.size() == k) {
            ans.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            // if ()
            track.add(i);
            backtrack(n, track, k, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
