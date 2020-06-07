# 第四周学习记录(6.1-6.7)

<span id ="0">
 
## [一、刷题记录](#1)

| [周一](#1.1)  |[周二](#1.2)  | [ 周三](#1.3) |[周四](#1.4) | [周五](#1.5) |[周六](#1.6) | [周日](#1.7) |
| :---: | :----: | :---: | :----: | :----: | :----: | :----: |



 
## [二、数据结构与算法笔记](#2)
  * [1. 字典树和并查集](#2.1)
  * [2. 高级搜索](#2.2)
  * [3. 红黑树和 AVL 树](#2.3)



<h2 id = "1">一、刷题记录</h2>


| 题目类型 | 知识点 | 题目 | 完成情况 | 地址 |
| --- | --- | --- | --- | --- |
| 实战 | 字典树 | Leetcode 208：实现Trie  |  :ok:  | [周四](#1.4) |
|  | 字典树+回溯+dfs | Leetcode 212：单词搜索II  | :ok:   | [周日](#1.7) |
|  | 并查集/dfs | Leetcode 200：岛屿数量  |  :ok:  | [周三](#1.3) |
|  | 并查集 | Leetcode 547：朋友圈  |  :ok:  | [周二](#1.2) |
|  | 并查集/dfs |  Leetcode 130：被围绕的区域 | :ok:   | [周四](#1.4) |
|  | 动态规划 | Leetcode 70：爬楼梯 | :ok: | [周四](#1.4) |
|  | 递归 | Leetcode 22：括号生成 | :ok: | [周四](#1.4) |
|  | 回溯 | Leetcode 51：N 皇后 | :ok: | [周三](#1.3) |
|  | 遍历 | Leetcode 36：有效的数独| :ok: | [周四](#1.4) |
|  | 遍历+回溯 | Leetcode 37：解数独 | :ok: | [周四](#1.4) |
|  | BFS | Leetcode 127：单词接龙 | :ok: | [周四](#1.4) |
|  | BFS | Leetcode 433：最小基因变化| :ok: | [周四](#1.4) |
|  | BFS | Leetcode 1091：二进制矩阵中的最短路径| :ok: | [周五](#1.5) |



<h3 id = "1.1">周一</h3>

[返回目录](#0)

主题：二叉树；技巧：dfs；题数：新题 0 道，复习 2 道

#### 复习 [Leetcode 94：二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
4.24 第一遍，5.4 第二遍，6.1 第三遍
- 思路一：递归中序遍历，二叉树经典算法。
  1. 递归左树
  2. append root value
  3. 递归右树
- 复杂度分析：O（N），空间复杂度：O（logN）~ O（N），取决于 root 的形态
- 思路二：使用 Stack 来辅助完成。考虑到 stack 的特征是后进先出：
  1. 先将 root 放入到 satck 中，然后当 root != null 的时候，不断将 root 左移，并将其放入 stack，最终会导致最左侧的子节点位于 stack 最上端
  2. 当 `cur == null` 但是 stack 不为空的时候，说明已经走到最左边了，这时候就将其从 stack 中取出，并加入到 ans 中；
  3. 同时，将取出的节点重新赋值给 cur，并令 `cur = cur.right`，这样，当下一次循环的时候，就会发现 `cur != null`，于是会将右节点也放入 satck，并在下一次循环中继续放入 ans
- 复杂度分析：O（N）

#### 复习 [Leetcode 144：二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
4.24 第一遍，5.4 第二遍，6.1 第三遍
- 思路一：前序遍历，经典算法。
  1. append root value
  2. 递归左树
  3. 递归右树
- 复杂度分析：O（N），空间复杂度：O（logN）~ O（N），取决于 root 的形态
- 思路二：与 94 题一样，用 stack 来辅助进行递归，步骤如下：
  1. 把根结点加入stack中。
  2. 开始遍历 while(!stack.isEmpty()) 执行下面的3、4步
  3. 从stack中取出栈顶的TreeNode node结点，把它加入到结果集res中
  4. 依次加入node的右孩子、左孩子（如果存在的话）
  5. 得到结果集res，返回


<h3 id = "1.2">周二</h3>

[返回目录](#0)

主题：遍历；技巧：bfs、dfs、并查集；题数：新题 1 道，复习 1 道



#### 复习 [Leetcode 102：二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
4.28 第一遍，4.29 第二遍，5.4 第三遍，5.11 第四遍，6.2 第五遍
思路：使用 BFS 对树进行层间遍历。每次都用一个队列来接受root，然后将其放入答案链表即可。
注意：在判定当前子节点等级与 ans size 的关系的时候，要写 >= 而非 >，因为在一开始的时候，二者都是 0，如果不加 =，整个循环就无法开始。
注意：往队列里添加的应该是 curNode.left 而不是 root.left
复杂度分析：O（N） 空间复杂度：O（N）

#### [Leetcode 547：朋友圈](https://leetcode-cn.com/problems/friend-circles/)
6.2 第一遍
- 思路一：dfs。类似于岛屿数量题的思路
  1. 因为有 n 名学生，所以 isVisted 数组就可以设置为 n 的大小，它代表的是某一个人是否属于某一个朋友圈；
  2. 具体而言，我们从第一个人出发，通过 dfs helper 函数，找到所有与他相连接的人，直到找不到为止，然后 count++；
  3. 找所有相连的人的方式，类似于不仅仅有很多个岛屿，而且每个岛屿下面还有隧道相连，所以一旦遇到值为 1 且之前没有访问过的人，那么我们立即跳到它那里，以它为起点再次出发去寻找，实现方式就是对 dfs 的再调用
复杂度分析：O(N^2)
- 思路二：Union-Find 算法。算法4 第一章1.5节出现过的算法，也是 cs61b 中 lab 题要实现的算法之一。

```Java
    // Solution One: DFS
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int m = M.length, n = M[0].length;
        int count = 0;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count += 1;
            }
        }       
        return count;
    }
    private void dfs(int[][] M, int row, boolean[] visited) {
        for (int j = 0; j < M[0].length; j++) {
            if (!visited[j] && M[row][j] == 1) {
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }
  
    // Solution Two: Weighted Union-Find
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int m = M.length, n = M[0].length;
        UF uf = new UF(n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.connect(i,j);
                }
            }
        }
        return uf.count();
    }
    class UF {
        private int[] size;
        private int[] parent;
        private int count;

        public UF(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            this.count = n;
        }
        public void connect(int one, int two) {
            int rootOne = find(one);
            int rootTwo = find(two);
            if (rootOne == rootTwo) return;
            if (size[rootOne] > size[rootTwo]) {
                parent[rootTwo] = rootOne;
                size[rootOne] += size[rootTwo];
            } else {
                parent[rootOne] = rootTwo;
                size[rootTwo] += size[rootOne];
            }
            this.count -= 1;
        }

        public int find(int one) {
            while (parent[one] != one) {
                parent[one] = parent[parent[one]];
                one = parent[one];
            }
            return one;
        }

        public boolean isConnected (int one, int two) {
            return find(one) == find(two);
        }

        private int count() {
            return count;
        }

    }
```


<h3 id = "1.3">周三</h3>

[返回目录](#0)

主题：dfs；技巧：回溯；题数：新题 0 道，复习 2 道

#### 复习 [Leetcode 51：N 皇后](https://leetcode-cn.com/problems/n-queens/)
5.9 第一遍，6.3 第二遍
- 思路：回溯。模板和 46 题很相似，不同的地方在于剪枝函数的设置。
- 注意：剪枝函数中，我们需要排除同一列是否有其他皇后、右上方、左上方是否有皇后。不用搜寻其他方向的原因在于，我们的放置 Q 是从左上角开始的，意味着 isValid 的搜寻也只需要扫描已经放置了 Q 的地方。
- 注意：在 isValid 函数中，只需进行列的搜索，因为主函数里面，row就已经是个变量，这里只要改变 col 就可以了

#### 复习 [Leetcode 200：岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
5.14 第一遍，6.3 第三遍
- 思路：核心步骤在于先找到第一个值为 1 的点，然后找到所有与之相邻（四个方向，上下左右）的值为 1 的点，如果找不到了，则将 count + 1，然后继续循环。同时为了避免出现重复循环的问题以及数组越界的问题，我们需要两个措施：
  1. 将已经走过的地方从 1 -> 2，防止多次循环。`grid[i][j] = 2`
  2. 右方和下方都不能超过二维数组的边界。`if (i < 0 || j < 0 || i < grid.length - 1 || j < grid[0].length - 1 || grid[i][j] != '1')`
  3. 注意判断附近格子内容的时候， `grid[i][j] !='1'` 应该放在最后，否则就会造成数组越界问题。
- 注意：给定的是 char 数组，而不是 int 数组。
- 注意：此题也可以用并查集来做

<h3 id = "1.4">周四</h3>

[返回目录](#0)

主题：dfs；技巧：dfs+回溯；题数：新题 4 道，复习 4 道


#### [Leetcode 36：有效的数独](https://leetcode-cn.com/problems/valid-sudoku/)
6.4 第一遍
- 思路：三次判定：
1. 首先，设置 boolean 矩阵，第一个对应的是对于每一行中是否出现重复元素的判定，row 代表的是 board 的 0 - 8 行，col 中的 0 - 8 代表的是九个数字是否曾经出现；
2. 同理，第二个矩阵是对于每一列中是否有重复元素的判定，row 代表的是每一行；第三个矩阵是对于每一个小 block 中是否有重复元素的判定；
3. 将 `board[i][j]` 对应到第一、二个矩阵很简单，但是对应到每一个 block 需要一番心思，具体而言能找到如下规律：
   - 从左到右、从上到下依次给 block 编号为 0 - 8，每一层有三个 block，所以第 0 层序号为：0-2，第 1 层为 3-5，第 2 层为 6-8；
   - 如果 `0 <= i <= 2`，说明 `board[i][j]`在第一层的三个 block 之中，因为 9 个 block 实际上的排列为 3x3，所以其对应的 block 的层级为 `i / 3 * 3`（`*3`是因为每一层有三个 block）
   - 在这一层中，block 又位于第几个呢？这就需要 j 来判定，即 `j/3`
   - 所以，最终的 block 的序号，即为`blockIndex = i / 3 * 3 + j / 3`
- 复杂度分析：O(N^2)

```Java
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][value] == true || col[j][value] == true || block[blockIndex][value] == true) {
                        return false;
                    } else {
                        row[i][value] = true;
                        col[j][value] = true;
                        block[blockIndex][value] = true;
                    }
                }
            }
        }
        return true;
    }
```

#### [Leetcode 37：解数独](https://leetcode-cn.com/problems/sudoku-solver/)
6.4 第一遍
- 思路：回溯。这道题其实是 36.有效的数独 + 51.N皇后，先用 36 题的方法，将出现过的数字标记为真，

#### [Leetcode 130：被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)
6.4 第一遍
- 思路：DFS。这道题思路和 200.岛屿数量 非常相似，具体而言：
  1. 先遍历四条边，然后和岛屿题一样，找到所有与边界上 `O` 相连的内部`O`，将其改为`'.'`
  2. 而后遍历整个区域，将所有的`'O'` 变成 `'X'`,所有的`'.'` 变为 `'O'`
  3. 在判断 `board[row][col]`是否合法的时候，不能仅仅只判断 row 和 col 值的大小，还要判断 `borad[row][col] == 'O' or not`，如果为否，则 return
- 复杂度分析：O(M*N)


#### [Leetcode 208：实现 Trie](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
6.3 第一遍
- 思路：字典树的实现。


#### 复习 [Leetcode 22：括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
4.30 第一遍，5.12 第二遍，6.4 第三遍
- 思路：递归。这道题是超哥在视频中详细讲解的。对我的启发有两点：自顶向下编程与结构化思维。
  1. 递归都是四个步骤：terminator, process logic, drill down, restore status
  2. 对于题目的要求，要作以下几个考虑：第一、left < n；第二、right < left，以这两个为判断递归的标准即可
  3. terminator 为 `left == n && right == n`，它代表的意思是已经完成了整个过程，这时候将 s 加到 ans 中就可以了
  4. 如果`left < n`，代表的是左括号还没用完，因此需要在 s 后面加上左括号，同时递归的时候 `left + 1`
  5. 如果 `right < left`，代表的是右括号还没有用完，因此在 s 后加上右括号，同时 `right + 1`，在这里不用 `right < n` 的原因是括号必须有效，也就是到任意一个状态，左括号的数量都必须大于等于右括号，因此必须是 `right < left`
- 注意：递归函数不能用 List<String>，要传入 String s，然后将 s 加到全局变量 List<String> 中

```Java
    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        int left = 0, right = 0;
        dfs(left, right, n, "");
        return ans;
    }
    private void dfs(int left, int right, int n, String s) {
        if (left == n && right == n)  
            ans.add(s);
        if (left < n ) 
            dfs(left + 1, right, n, s+"(");
        if (right < left)  
            dfs(left, right + 1, n, s + ")");
    }
```


#### 复习 [Leetcode 70：爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
4.10 第一遍，4.22 第二遍，5.4 第三遍，5.16 第四遍，6.4 第五遍
思路一：递归。将到达第 n 级台阶拆解为到达第 n-1 和 n-2，然后再往前走 1 or 2 步。就能完成任务。
步骤：先写停止递归条件（数学归纳法里面的首步条件，然后写递归公式
注意：如果用斐波那契数列的写法，会造成时间过长，在这里我们要保存每一步的内容，需要用到动态规划
思路二：递推。与递归不同，递推是从底向上的思维。我们先考虑 `f(1) = 1, f(2) = 2`，然后根据公式 `f(3) = f(2) + f(1)`，并依次进行，直到 f(n) 
注意：循环的起始位置应该为 i = 2，代表从第二季台阶开始爬楼梯
复杂度分析：O（N）

#### 复习 [Leetcode 433：最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)
5.13 第一遍，5.21 第二遍，6.4 第三遍
- 思路：这道题的思路其实和 127 题单词接龙非常一致。这道题要求的是从 start 到 end 经过了几次变化。那么就可以理解为假设每一步仅变化一个基因，变化到目标基因需要几步。整个代码在 127 的思路上稍微改改就行了。
- 注意：bank 是 String 数组，不好判断是否包含某一个字符串，因此将其转为 set 然后再用 contains() 方法
- 注意：最终返回 count 而不是 count + 1。

#### 复习 [Leetcode 547：朋友圈](https://leetcode-cn.com/problems/friend-circles/)
6.2 第一遍，6.4 第二遍
- 思路见[前节](#1.2)






<h3 id = "1.5">周五</h3>

[返回目录](#0)

主题：BFS；技巧：双向 BFS；题数：新题 1 道，复习 2 道




#### [Leetcode 1091：二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/)
6.5 第一遍
- 思路：BFS。这实际上是个图的问题，图中的最短路径，一般就要用 bfs 来求：
  1. 将第一个起点放入 queue，同时将其值从 0 改成 1，然后往八个方向走，遇到所有的 0 都替换成 1，然后走完之后 step + 1；
  2. 能这么做的原因是从起点出发，往八个方向各走一步，总会有一个最短路径，能最快到达终点。这就类似于往湖里面扔石头，水波纹不断扩散，到达岸边（终点）的时候，就是最短路径。
- 复杂度分析：O(N^2)

#### 复习 [Leetcode 127：单词接龙](https://leetcode-cn.com/problems/word-ladder/) 
5.13 第一遍，5.14 第二遍，5.20 第三遍，5.21 第四遍，6.4 第五遍，6.5 第六遍
- 思路：双向BFS。步骤如下：
1. 将第一个单词节点加入队列，depth 设置为 0，在最后返回的时候 再 +1；
2. 方法是层序遍历，那么关键就在于如何讲每一层顺序放入queue中。在这个题目中，我们采用的是两个 while 循环的形式：
   1. 第一个`while(!queue.isEmpty())` 用来判断整个遍历是否完成
   2. 第二个`while(size > 0)`用来判断某一层是否完成。这里的 `size = queue.size()`，之所以要用一个新的参数来判定是因为 queue 在第二个while中会发生变化，所以需要一个固定的值来保证不会超出这一层的范围。
      - 例如，刚开始的时候只有一个 beginWord，那么 size 就是 1. 而后在第二个while 中每次都会 size -= 1；所以对于这一层而言，只会循环一次便跳出循环，来到最外层的 while 循环。
3. 在两个while 循环之内，还需要一个 for-loop，这个循环的对象是题目给定的 wordList 数组，也是我们的核心代码部分。需要在这里判断：
   1. word 是否已经在 visitedOne 中出现过？如果是，continue；
   2. 两个 string 相差是否超过了一个 char 字符？如果是，continue。对比相差是否超过一个 char 的方式，为新建一个 for-loop，从 `'a' - 'z'`，依次替换 word 中的第 i 个字符，然后再从 charArray 转换为 String 进行对比；
   3. 是否到达了 endWord？即是否在 visitedTwo 中出现过？如果是，直接 return depth + 1；
   4. 如果都没有，且这个新的 string 是能够在 allWords 中找到的，那么将这个字符标记为出现过，同时将 wordList 中剩下的元素全都加入 queue。此时第二层循环如果结束了，再次进入的时候 size 就变大了;
- 复杂度分析：`O（N*26^L），L = len(beginword)`
```Java
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> allWords = new HashSet<>(wordList);
        if (!allWords.contains(endWord)) return 0;
        Queue<String> queueOne = new LinkedList<>();
        Queue<String> queueTwo = new LinkedList<>();
        Set<String> visitedOne = new HashSet<>();
        Set<String> visitedTwo = new HashSet<>();
        queueOne.offer(beginWord);
        queueTwo.offer(endWord);
        visitedOne.add(beginWord);
        visitedTwo.add(endWord);
        int count = 0;
        while (!queueOne.isEmpty() && !queueTwo.isEmpty()) {
            count += 1;
            if (queueOne.size() > queueTwo.size()) {
                Queue<String> tmpQueue = queueOne;
                queueOne = queueTwo;
                queueTwo = tmpQueue;
                Set<String> tmpSet = visitedOne;
                visitedOne = visitedTwo;
                visitedTwo = tmpSet;
            }
            int size = queueOne.size();
            while (size > 0) {
                size -= 1;
                String word = queueOne.poll();
                char[] wordChar = word.toCharArray();
                for (int i = 0; i < wordChar.length; i++) {
                    char save = wordChar[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChar[i] = c;
                        String newWord = String.valueOf(wordChar);
                        if (visitedOne.contains(newWord)) continue;
                        if (visitedTwo.contains(newWord)) return count + 1;
                        if (allWords.contains(newWord)) {
                            visitedOne.add(newWord);
                            queueOne.offer(newWord);
                        }
                    }
                    wordChar[i] = save;
                }
            }
        }
        return 0;
    }
```


#### 复习 [Leetcode 36：有效的数独](https://leetcode-cn.com/problems/valid-sudoku/)
6.4 第一遍，6.5 第二遍
思路见[前节](#1.4)




<h3 id = "1.6">周六</h3>

[返回目录](#0)

主题：Hashing；技巧：遍历；题数：新题 1 道，复习 1 道


#### [LeetCode 217：存在重复元素](https://leetcode-cn.com/problems/contains-duplicate/)
6.6 第一遍
思路：set。将每一个元素放入 set，最终的 `set.size()` 如果小于数组的长度，说明有重复的元素，返回 true，否则返回 false。
复杂度分析：O(N)


#### 复习[LeetCode 350：两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)
6.6 第二遍
- 思路：HashMap.
  1. 判断 nums1 与 nums2 的长度，将较短的放入 HashMap 中，遇到相同的key则将value += 1，在放入的过程中，更新value的方式就是重新put一次，在《算法4》234页有类似的操作。
  2. 然后循环 nums2，判断nums2 中的元素是否在 HashMap 中，若是，则将其放入 ArrayList，然后vale -= 1
  3. 采用 Arraylist 存放交集的原因，是数组长度固定，但是我们并不知道交集的大小，所以先存放到一个临时的容器里面，然后最后将其装入最终的数组
- 复杂度：O（m+n），空间复杂度：O（n）


<h3 id = "1.7">周日</h3>

[返回目录](#0)

主题：dfs；技巧：dfs + 回溯；题数：新题 2 道，复习 0 道

#### [Leetcode 79：单词搜索](https://leetcode-cn.com/problems/word-search/)
6.7 第一遍
- 思路：dfs + 回溯。没有用 visited 矩阵来识别是否访问了某个元素，而是类似于岛屿问题，直接将访问过的元素更改，然后在回溯之后再改回来
  1. 将 word 转换为 charArray，方便进行下标访问；
  2. 从 board[0][0] 开始，进行 dfs，先将 board[i][j] 的元素保存，将其改为 '.'，然后往四个方向分别进行 dfs，如果 dfs == true，就 return true；
  3. 四个方向都 dfs 之后，进行回溯，board[i][j] = tmp；
- 注意：如果采用 visited 数组的方式，就不能简单的 `if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != wordArray[len]) return false;`，这会造成数组越界，应该分别对每一种情况去 dfs，例如 `if (i > 1) {if (dfs(..., i - 1, j, ...)) return true;}`，分别对四种情况进行 dfs
```Java
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        int m = board.length, n = board[0].length;
        char[] wordArray = word.toCharArray();
        if (m * n < wordArray.length) return false;
        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordArray[0]) {
                    if (dfs(board, i, j, wordArray, len)) {
                        return true;
                    }
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
        if (dfs(board, i, j + 1, wordArray, len + 1)) return true;
        else if (dfs(board, i + 1, j, wordArray, len + 1)) return true;
        else if (dfs(board, i - 1, j, wordArray, len + 1)) return true;
        else if (dfs(board, i, j - 1, wordArray, len + 1)) return true;
        board[i][j] = tmp;
        return false;
    }
```

#### [Leetcode：212:单词搜索II](https://leetcode-cn.com/problems/word-search-ii/)
6.7 第一遍
- 思路一：对于每一个 word in words，用 79 题单词搜索的方法去判断。要注意的是，对于每一次 dfs，如果为 true，要直接将 board[i][j] = tmp，而不能在回溯的阶段做这件事。否则相当于棋盘被改变了，在 79 题中无所谓，因为只需要判断一个 String，但在这里是 Stirng[]，因此会造成棋盘被改变，符合要求的 String 也检查不出来。
- 思路二：构建一个字典树。然后同样用 dfs 的方式，往四个方向进行搜索，如果 `isEnd == true`，将 root.val 加入 ans。

```Java
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

``






<h2 id = "2">二、数据结构与算法笔记</h2>


<h3 id = "2.1">1. 字典树和并查集</h3>

[返回目录](#0)

Trie 模板：
```Java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```

并查集代码模板：
```Java
  class UnionFind { 
    private int count = 0; 
    private int[] parent; 
    public UnionFind(int n) { 
      count = n; 
      parent = new int[n]; 
      for (int i = 0; i < n; i++) { 
        parent[i] = i;
      }
    } 
    public int find(int p) { 
      while (p != parent[p]) { 
        parent[p] = parent[parent[p]]; 
        p = parent[p]; 
      }
      return p; 
    }
    public void union(int p, int q) { 
      int rootP = find(p); 
      int rootQ = find(q); 
      if (rootP == rootQ) return; 
      parent[rootP] = rootQ; 
      count--;
    }
  }

```



<h3 id = "2.2">2. 高级搜索</h3>

[返回目录](#0)

双向 BFS 模版
```
int openLock(String[] deadends, String target) {
    Set<String> deads = new HashSet<>();
    for (String s : deadends) deads.add(s);
    // 用集合不用队列，可以快速判断元素是否存在
    Set<String> q1 = new HashSet<>();
    Set<String> q2 = new HashSet<>();
    Set<String> visited = new HashSet<>();

    int step = 0;
    q1.add("0000");
    q2.add(target);

    while (!q1.isEmpty() && !q2.isEmpty()) {
        if (q1.size() > q2.size()) {
            // 交换 q1 和 q2
            temp = q1;
            q1 = q2;
            q2 = temp;
        }
        // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
        Set<String> temp = new HashSet<>();

        /* 将 q1 中的所有节点向周围扩散 */
        for (String cur : q1) {
            /* 判断是否到达终点 */
            if (deads.contains(cur))
                continue;
            if (q2.contains(cur))
                return step;
            visited.add(cur);

            /* 将一个节点的未遍历相邻节点加入集合 */
            for (int j = 0; j < 4; j++) {
                String up = plusOne(cur, j);
                if (!visited.contains(up))
                    temp.add(up);
                String down = minusOne(cur, j);
                if (!visited.contains(down))
                    temp.add(down);
            }
        }
        /* 在这里增加步数 */
        step++;
        // temp 相当于 q1
        // 这里交换 q1 q2，下一轮 while 就是扩散 q2
        q1 = q2;
        q2 = temp;
    }
    return -1;
}
```

<h3 id = "2.3">3. 红黑树和 AVL 树</h3>

[返回目录](#0)



















