//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.7 第一遍
 - 思路一：对于每一个 word in words，用 79 题单词搜索的方法去判断。要注意的是，对于每一次 dfs，如果为 true，要直接将 board[i][j] = tmp，而不能在回溯的阶段做这件事。否则相当于棋盘被改变了，在 79 题中无所谓，因为只需要判断一个 String，但在这里是 Stirng[]，因此会造成棋盘被改变，符合要求的 String 也检查不出来。
 - 思路二：构建一个字典树。然后同样用 dfs 的方式，往四个方向进行搜索，如果 `isEnd == true`，将 root.val 加入 ans。
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (words.length == 0 || board == null) return ans;
        Trie dicTree = new Trie();
        TrieNode root = dicTree.root;
        for (String w : words) {
            dicTree.insert(w);
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, ans, visited, root);
            }
        }
        return ans;
    }

    private void dfs(char[][] board, int i, int j, List<String> ans, boolean[][] visited, TrieNode cur) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }
        cur = cur.next[board[i][j] - 'a'];
        if (cur == null) return;
        visited[i][j] = true;
        if (cur.isEnd) {
            ans.add(cur.val);
            cur.isEnd = false;
        }
        dfs(board, i, j + 1, ans, visited, cur);
        dfs(board, i, j - 1, ans, visited, cur);
        dfs(board, i + 1, j, ans, visited, cur);
        dfs(board, i - 1, j, ans, visited, cur);
        visited[i][j] = false;

    }

    class Trie {
        TrieNode root = new TrieNode();
        public void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                int charValue = c - 'a';
                if (cur.next[charValue] == null)
                    cur.next[charValue] = new TrieNode();
                cur = cur.next[charValue];
            }
            cur.isEnd = true;
            cur.val = s;
        }
    }
    class TrieNode {
        boolean isEnd;
        String val;
        TrieNode[] next;
        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
/**
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || words.length == 0) return ans;
        int count1 = 0, count2 = 0;
        for (String word : words) {
            count1 += 1;
            if (exists(word, board)) {
                ans.add(word);
                count2 += 1;
            }
        }
        return ans;
    }

    private boolean exists(String word, char[][] board) {
        char[] wordArray = word.toCharArray();
        char first = wordArray[0];
        int m = board.length, n = board[0].length;
        if (m * n < wordArray.length) return false;
        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == first) {
                    if (dfs(board, i, j, wordArray, len)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] wordArray, int len) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != wordArray[len]) return false;
        if (len == wordArray.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '.';
        if (dfs(board, i, j + 1, wordArray, len + 1)) {
            board[i][j] = tmp;
            return true;
        }
        else if (dfs(board, i + 1, j, wordArray, len + 1)) {
            board[i][j] = tmp;
            return true;
        }
        else if (dfs(board, i - 1, j, wordArray, len + 1)) {
            board[i][j] = tmp;
            return true;
        }
        else if (dfs(board, i, j - 1, wordArray, len + 1)) {
            board[i][j] = tmp;
            return true;
        }
        board[i][j] = tmp;
        return false;

    }
*/
}
//leetcode submit region end(Prohibit modification and deletion)
