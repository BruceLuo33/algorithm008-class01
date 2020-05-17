//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干
//的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满
//足越多数量的孩子，并输出这个最大数值。 
//
// 注意： 
//
// 你可以假设胃口值为正。 
//一个小朋友最多只能拥有一块饼干。 
//
// 示例 1: 
//
// 
//输入: [1,2,3], [1,1]
//
//输出: 1
//
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: [1,2], [1,2,3]
//
//输出: 2
//
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
// Related Topics 贪心算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.13 第一遍，5.15 第二遍
 思路：贪心算法。步骤如下：
 1. 先将两个数组排序，然后设置两个指针分别指向两个数组的首位置；
 2. 设置 while 循环，当两个指针中某一个到达终点就结束。在 while 中做如下判断：
 如果满足 s>= g 的条件，就可以分配饼干，同时两个指针都往下走；
 如果不满足，则说明饼干尺寸小了，将 s 的指针后移
 复杂度分析：
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cookies = 0, kids = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        while (kids < g.length && cookies < s.length) {
            if (s[cookies] >= g[kids]) {
                count += 1;
                cookies += 1;
                kids += 1;
            } else {
                cookies += 1;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
