//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.13 第一遍
 思路：BFS。步骤如下：
 1. 将第一个单词节点加入队列，depth 设置为 0，在最后返回的时候 再 +1；
 2. 方法是层序遍历，那么关键就在于如何讲每一层顺序放入queue中。在这个题目中，我们采用的是两个 while 循环的形式：
 第一个`while(!queue.isEmpty())` 用来判断整个遍历是否完成
 第二个`while(size > 0)`用来判断某一层是否完成。这里的 `size = queue.size()`，之所以要用一个新的参数来判定是因为 queue 在第二个while中会发生变化，所以需要一个固定的值来保证不会超出这一层的范围。
 例如，刚开始的时候只有一个 beginWord，那么 size 就是 1. 而后在第二个while 中每次都会 size -= 1；所以对于这一层而言，只会循环一次便跳出循环，来到最外层的 while 循环。
 3. 在两个while 循环之内，还需要一个 for-loop，这个循环的对象是题目给定的 wordList 数组，也是我们的核心代码部分。需要在这里判断：
 word 是否已经出现过？如果是，continue；
 两个 string 相差是否超过了一个 char 字符？如果是，continue；
 是否到达了 endWord？如果是，直接 return depth + 1；
 如果都没有，将这个字符标记为出现过，同时将 wordList 中剩下的元素全都加入 queue。此时第二层循环如果结束了，再次进入的时候 size 就变大了。
 复杂度分析：O（N*26^l），l = len(beginword)

 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[wordList.size()];
        int depth = 0;
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            isVisited[idx] = true;
        }
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth += 1;
            while (size > 0) {
                String start = queue.poll();
                size -= 1;
                for (int j = 0; j < wordList.size(); ++j) {
                    if (isVisited[j]) {
                        continue;
                    }
                    String tmp = wordList.get(j);
                    if (!convert(start, tmp)) {
                        continue;
                    }
                    if (tmp.equals(endWord)) {
                        return depth + 1;
                    }
                    isVisited[j] = true;
                    queue.offer(tmp);
                }
            }
        }
        return 0;
    }

    private boolean convert(String one, String two) {
        // if (one.length() != two.length()) return false;
        int count = 0;
        for (int i = 0; i < one.length(); ++i) {
            if (one.charAt(i) != two.charAt(i)) {
                // count += 1;
                ++ count;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
