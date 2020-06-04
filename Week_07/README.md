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
|  |  |   |    | [](#) |



<h3 id = "1.1">周一</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道

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

主题：；技巧：；题数：新题 道，复习 道



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




<h3 id = "1.3">周三</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.4">周四</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道

#### 复习 [Leetcode 22：括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
4.30 第一遍，5.12 第二遍，6.4 第三遍
- 思路：递归。这道题是超哥在视频中详细讲解的。对我的启发有两点：自顶向下编程与结构化思维。
  1. 递归都是四个步骤：terminator, process logic, drill down, restore status
  2. 对于题目的要求，要作以下几个考虑：第一、left < n；第二、right < left，以这两个为判断递归的标准即可
  3. terminator 为 `left == n && right == n`，它代表的意思是已经完成了整个过程，这时候将 s 加到 ans 中就可以了
  4. 如果`left < n`，代表的是左括号还没用完，因此需要在 s 后面加上左括号，同时递归的时候 `left + 1`
  5. 如果 `right < left`，代表的是右括号还没有用完，因此在 s 后加上右括号，同时 `right + 1`，在这里不用 `right < n` 的原因是括号必须有效，也就是到任意一个状态，左括号的数量都必须大于等于右括号，因此必须是 `right < left`
- 注意：递归函数不能用 List<String>，要传入 String s，然后将 s 加到全局变量 List<String> 中

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

#### [Leetcode 130：被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)
6.4 第一遍
- 思路：DFS。这道题思路和 200.岛屿数量 非常相似，具体而言：
  1. 先遍历四条边，然后和岛屿题一样，找到所有与边界上 `O` 相连的内部`O`，将其改为`'.'`
  2. 而后遍历整个区域，将所有的`'O'` 变成 `'X'`,所有的`'.'` 变为 `'O'`
  3. 在判断 `board[row][col]`是否合法的时候，不能仅仅只判断 row 和 col 值的大小，还要判断 `borad[row][col] == 'O' or not`，如果为否，则 return
- 复杂度分析：O(M*N)


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


#### [Leetcode 37：解数独](https://leetcode-cn.com/problems/sudoku-solver/)
6.4 第一遍
- 思路：回溯。这道题其实是 36.有效的数独 + 51.N皇后，先用 36 题的方法，将出现过的数字标记为真，


#### [Leetcode 208：实现 Trie](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
6.3 第一遍
- 思路：字典树的实现。

<h3 id = "1.5">周五</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.6">周六</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.7">周日</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道







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



<h3 id = "2.3">3. 红黑树和 AVL 树</h3>

[返回目录](#0)



















