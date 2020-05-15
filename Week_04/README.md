# 第四周学习记录(5.11-5.17)

<span id ="0">
 
## [一、刷题记录](#1)

| [周一](#1.1)  |[周二](#1.2)  | [ 周三](#1.3) |[周四](#1.4) | [周五](#1.5) |[周六](#1.6) | [周日](#1.7) |
| :---: | :----: | :---: | :----: | :----: | :----: | :----: |



 
## [二、数据结构与算法笔记](#2)
  * [1. 深度优先搜索](#2.1)
  * [2. 广度优先搜索](#2.2)
  * [3. 贪心算法](#2.3)
  * [4. 二分查找](#2.4)
  * [5. ](#2.5)
  * [6. ](#2.6)


<h2 id = "1">一、刷题记录</h2>


| 题目类型 | 知识点 | 题目 | 完成情况 | 地址 |
| --- | --- | --- | --- | --- |
| 实战 | 递归，DFS | Leetcode 22：括号生成  | :ok:   | [周二](#1.2) |
|  | 二分查找 | Leetcode 69：x的平方根  | :ok:   | [周二](#1.2) |
|  | 二叉树、BFS | Leetcode 102：二叉树的层序遍历  | :ok:   | [周一](#1.1) |
|  | 图、BFS | Leetcode 433：最小基因变化  | :ok:   | [周三](#1.3) |
|  | 二叉树、BFS | Leetcode 515：在每个树行中找最大值 | :ok:   | [周三](#1.3) |
| 课后作业 | 二分查找 | Leetcode 33：搜索旋转排序数组  |  :ok:  | [周四](#1.4) |
|  | 贪心算法 | Leetcode 45：跳跃游戏II  | :ok:   | [周五](#1.5) |
|  | 贪心算法 | Leetcode 55：跳跃游戏  | :ok:   | [周五](#1.5) |
|  | 贪心算法 | Leetcode 122：买卖股票的最佳时机II  | :ok:   | [周五](#1.5) |
|  | 图、BFS | Leetcode 127：单词接龙  | :ok:   | [周三](#1.3) |
|  | 图、BFS | Leetcode 200：岛屿数量  | :ok:   | [周四](#1.4) |
|  | 双指针 | Leetcode 455：分发饼干  | :ok:   | [周三](#1.3) |
|  |  | Leetcode 529：扫雷游戏  | :question:   | [](#) |
|  | 贪心算法 | Leetcode 860：柠檬水找零  | :ok:   | [周五](#1.5) |
| 预习 | 动态规划 | Leetcode 198：打家劫舍 |  :ok:  | [周一](#1.1) |
|  |  |   |    | [](#) |



<h3 id = "1.1">周一(5.11)</h3>

[返回目录](#0)

主题：二叉树、动态规划；技巧：递归；题数：新题 1 道，复习 4 道


#### [1.1. Leetcode 198：打家劫舍](https://leetcode-cn.com/problems/house-robber/)
5.11 第一遍
- 思路：一开始想的很简单，认为就是求奇数项和偶数项哪个大。这个读题太不仔细了。后面发现这是个动态规划问题，找到状态转移方程就可以了。
  - 代码中的变量，如果我们比较的是第 k 个位置的大小，prev 实际上是 k-2 位置上的最大值，cur 是 k - 1 位置上的最大值。
- 复杂度分析：O（N），因为要遍历整个数组
```JaVA
      int prev = 0, cur = 0;
      for (int i : nums) {
          int tmp = cur;
          cur = Math.max(prev + i, cur);
          prev = tmp;
      }
      return cur;
```

#### 复习 [1.2. Leetcode 236：二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/)/[面试题68-II](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/submissions/)
5.10 第一遍，5.11 第二遍
- 思路：递归。关键问题在于对参数 `left` 和 `right` 的理解，因为这是递归，所以在写递归语句的时候，可以认为左右子树都已经算出来了结果。
  - 1. 如果当前节点 root 为 null，那么就直接返回 null；
  - 2. 如果 root 等于 p 或者是 q，那么就返回 p or q；
  - 3. 接着往下递归。如上所述，递归的时候可以直接认为我们已经求出来了 left 和 right，用它们来表示即可；
  - 4. 对于返回值，有以下几种情况：
       - 第一，left 和 right 同时为空，说明左右子树都不包含p、q，返回null；
       - 第二，同时不为空，说明在root 的两侧，返回root；
       - 第三，left 为空，right不为空，说明p、q都在右边；
       - 第四，right 为空，left不为空，说明都在左边
- 复杂度分析：O（N）

#### 复习 [1.3. Leetcode 116：填充每个结点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)
5.8 第一遍，5.11 第二遍
 - 思路一：递归。递归非常简洁，是必须要会的一个技巧。简单来说，将 node 指向右侧节点有三种情况：
   - 第一，node 本身为空，那么返回 null 就好了
   - 第二，node 的左子节点不为空，那么直接 `node.left.next = node.right`，将左子节点指向右子节点
   - 第三，node 的右子节点不为空，那么就需要判断 node.next 是否为空，如果是，说明右边没有节点了，将 node.right = null 就行；如果不是，则将其指向 node.next 的左子节点。`node.right.next = node.next.left`
- 复杂度分析：O（N）
- 思路二：迭代。题目要求空间复杂度为 O（1)。所以采用迭代来达到这个要求。
  - 在这里我们设置三个指针：第一个 level，指向每一层的最左边的节点；第二个 prev，指向要延伸出 next 指向右边的节点；第三个是 cur， 指向 prev 右边一个节点。所以 cur 可以为 null，代表的是 prev 已经到达了这一层的最右端。
  - 连接的关键在于通过 level 来控制在哪一层进行操作，通过 cur 来控制是否到达最右端、是否需要下移三个指针，通过 prev 来将 prev 的子节点连接起来：`prev.left.next = prev.right` 以及 `prev.right.next = cur.left`


#### 复习 [1.4. Leetcode 117：填充每个结点的下一个右侧节点指针II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/)
- 5.8 第一遍，5.11 第二遍 
- 思路：和116题比较类似，但是区别在于这里不再是完美二叉树，而是一棵普通的二叉树，那么就可能存在空子节点，所以在连接next 的时候就需要增加一些判断。依旧使用递归，不过在这里，因为需要判断每一层的空子节点数，所以需要一个 hasNext 来遍历整层，相当于 BFS 的层序遍历。
- 遍代码见下：
  ```Java
      public Node connect(Node root) {
        if (root == null) return root;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.left != null && root.right == null) {
            root.left.next = getNext(root.next);
        }
        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node root) {
        if (root == null) return null;
        if (root.left != null) return root.left;
        if (root.right != null) return root.right;
        if (root.next != null) return getNext(root.next);
        return null;
    }
  ```
  
- 注意：递归的顺序应该是先右子树再左子树。即先 `connect(root.right)` 再 `connect(root.left)`
- 复杂度分析：O（N）

#### 复习 [1.5. Leetcode 102：二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description)
4.28 第一遍，4.29 第二遍，5.4 第三遍，5.11 第四遍
- 思路：使用 BFS 对树进行层间遍历。每次都用一个队列来接受root，然后将其放入答案链表即可。
- 注意：在判定当前子节点等级与 ans size 的关系的时候，要写 >= 而非 >，因为在一开始的时候，二者都是 0，如果不加 =，整个循环就无法开始。
- 注意：往队列里添加的应该是 curNode.left 而不是 root.left
- 复杂度分析：O（N） 空间复杂度：O（N）


<h3 id = "1.2">周二(5.12)</h3>

[返回目录](#0)

主题：二叉树、二分法；技巧：递归；题数：3。新题 2 道，复习 1 道.

#### [2.1. Leetcode 69：x 的平方根](https://leetcode-cn.com/problems/sqrtx/)
5.12 第一遍
 - 思路：二分法。设置左边界为 0，右边界为 x。判断中点平方与x的大小关系：
   - 如果 mid^2 > x；就将右边界移动到 mid 左边；
   - 如果 mid^2 <= x，就将左边界移动到 mid 右边，并令 ans = mid（因为最终的答案是往下取整）然后不停迭代就好。
- 注意，mid * mid 要 cast 成 long 的格式
- 复杂度分析：O（logX）

#### [2.2. Leetcode 124：二叉树的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
5.12 第一遍
- 思路：递归。首先审题，因为题目没有说节点值不能为负，所以我们首先需要考虑这个情况：如果只有一个 node，那么返回它就是了，如果所有节点就是负数，那么久只返回根节点的值。将其他路径上的所有值都仅仅返回 0；如果最终的路径包含了某个 node，那么只有两种情况：
  - `maxValue = node.val + maxHelper(node.left) + maxHelper(node.right);`即最大路径包含了该节点，以及该节点的两个子树
  - `maxValue = node.val + Math.max(node.left.val, node.right.val) + root.val`，即该节点仅仅是路径上的一个点，因为路径不能两次分叉，所以最大的路径为穿过该节点的左 or 右子树(`max(node.left, node.right)`) 加上该节点的值 `node.val`，再加上该节点父节点之后的路径。
代码如下：
```Java
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return ans;
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int sum = left + right + root.val;
        ans = Math.max(sum, ans);
        return Math.max(left, right) + root.val;
    }
```


#### 复习 [2.3. Leetcode 22：括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
4.30 第一遍，5.12 第二遍
- 思路：这道题是超哥在视频中详细讲解的。对我的启发有两点：自顶向下编程与结构化思维。
  - 结构化思维：递归都是四个步骤：terminator, process logic, drill down, restore status. 对于题目的要求，要作以下几个考虑：
    - 第一、left < n，那么就将 left + 1，并且在 string s 后面再加一个 (；
    - 第二、right < left，同上，不过将left换成right。
- 注意：因为题目要求“有效的”括号，意味着每一个时刻而言，都要求 `left >= right`，所以判断条件不能是 right < n
- 注意：递归函数不能用 List<String>，要传入 String s，然后将 s 加到全局变量 List<String> 中






<h3 id = "1.3">周三(5.13)</h3>

[返回目录](#0)

主题：图；技巧：BFS；题数：4。新题 4 道，复习 0 道。

#### [3.1. Leetcode 127：单词接龙](https://leetcode-cn.com/problems/word-ladder/comments/)
5.13 第一遍
- 思路：BFS。步骤如下：
1. 将第一个单词节点加入队列，depth 设置为 0，在最后返回的时候 再 +1；
2. 方法是层序遍历，那么关键就在于如何讲每一层顺序放入queue中。在这个题目中，我们采用的是两个 while 循环的形式：
   - 第一个`while(!queue.isEmpty())` 用来判断整个遍历是否完成
   - 第二个`while(size > 0)`用来判断某一层是否完成。这里的 `size = queue.size()`，之所以要用一个新的参数来判定是因为 queue 在第二个while中会发生变化，所以需要一个固定的值来保证不会超出这一层的范围。 
     - 例如，刚开始的时候只有一个 beginWord，那么 size 就是 1. 而后在第二个while 中每次都会 size -= 1；所以对于这一层而言，只会循环一次便跳出循环，来到最外层的 while 循环。
3. 在两个while 循环之内，还需要一个 for-loop，这个循环的对象是题目给定的 wordList 数组，也是我们的核心代码部分。需要在这里判断：
   1. word 是否已经出现过？如果是，continue；
   2. 两个 string 相差是否超过了一个 char 字符？如果是，continue；
   3. 是否到达了 endWord？如果是，直接 return depth + 1；
   4. 如果都没有，将这个字符标记为出现过，同时将 wordList 中剩下的元素全都加入 queue。此时第二层循环如果结束了，再次进入的时候 size 就变大了。


#### [3.2. Leetcode 433：最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)
5.13 第一遍
- 思路：这道题的思路其实和 127 题单词接龙非常一致。这道题要求的是从 start 到 end 经过了几次变化。那么就可以理解为假设每一步仅变化一个基因，变化到目标基因需要几步。整个代码在 127 的思路上稍微改改就行了。
- 注意：bank 是 String 数组，不好判断是否包含某一个字符串，因此将其转为 set 然后再用 contains() 方法




#### [3.3. Leetcode 455：分发饼干](https://leetcode-cn.com/problems/assign-cookies/submissions/)
5.13 第一遍
- 思路：贪心算法。步骤如下：
1. 先将两个数组排序，然后设置两个指针分别指向两个数组的首位置；
2. 设置 while 循环，当两个指针中某一个到达终点就结束。在 while 中做如下判断：
   - 如果满足 s>= g 的条件，就可以分配饼干，同时两个指针都往下走；
   - 如果不满足，则说明饼干尺寸小了，将 s 的指针后移

#### [3.4. Leetcode 515：在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
 5.13 第一遍
- 思路：BFS。递归每一层，找到每一层的最大值，将其放入ans 数组即可。
- 注意：
   1. max 的初始化 `int max = Integer.MIN_VALUE` 要放在第一个 while 循环中
   2. 对 queue 首元素的提取，要放在第二个 while 里面
   3. 继续往 queue 中添加的是 node 的左右子节点


<h3 id = "1.4">周四(5.14)</h3>

[返回目录](#0)

主题：图、二叉树；技巧：BFS、DFS；题数：新题 5 道，复习 1 道

#### [4.1. Leetcode 200：岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
 5.14 第一遍
- 思路：核心步骤在于先找到第一个值为 1 的点，然后找到所有与之相邻的值为 1 的点，如果找不到了，则将 count + 1，然后继续遍历。同时为了避免出现重复循环的问题以及数组越界的问题，我们需要两个措施：
  1. 将已经走过的地方从 1 -> 2，防止多次循环。`grid[i][j] = 2`
  2. 右方和下方都不能超过二维数组的边界。`if (i < 0 || j < 0 || i < grid.length - 1 || j < gird[0].length - 1 || grid[i][j] != '1')`
- 注意：给定的是 char 数组，而不是 int 数组。



#### [4.2. Leetcode 33：搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
5.14 第一遍
- 思路：二分查找。乍一看会想到是不是需要先找出旋转的基点，但是这样的话时间复杂度就不符合要求。如果用二分查找就可以比较好的解决问题：
  1. 先拿出中间的数，与最右边的数字比较，如果大于，说明左半段是有序的，而后比较 target 与左半段第一个与最后一个数字的大小，判断是否在这段区间内；
  2. 如果不在，则舍弃掉左半边的部分，继续取剩下的部分的中间值判断，每次都在有序的半部分进行判断。以此类推。
- 注意：判断 target 和 nums[start]/nums[end] 的关系时，等号是否取很重要。

#### [4.3. Leetcode 129：求根到叶子节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)
5.14 第一遍
- 思路：DFS。一开始的时候直接用了`count += root.val`，然后发现这是将每一个结点的值累加了，但是没有进行进位。因此，我们不能仅用 count 一个参数来控制，应该还需要另一个参数与一个helper 函数。
- 复杂度分析：O（N）
```Java
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // int sum = 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int val) {
        if (root == null) return;
        val= (root.val + val * 10);
        if (root.left == null && root.right == null) {
            sum += val;
        }
        helper(root.left, val);
        helper(root.right, val);
    }

```


#### [4.4. Leetcode 156：上下翻转二叉树](https://leetcode-cn.com/problems/binary-tree-upside-down/comments/)
5.14 第一遍
- 思路：递归。这道题的关键还是先要搞懂题目的意思。主要的变化在于：
  1. 左子节点会变成当下节点的根节点
  2. 右子节点会变成新根节点的左子节点
  3. 根节点会变成左子节点所形成的新根节点的右子节点。
- 注意：basic terminator 应该是 `root == null || root.left == null`，不需要判断 root.right == null，因为我们需要的是左子节点来建立新的根节点
- 复杂度分析：O（N）

```Java
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode left = root.left, right = root.right;
        TreeNode ans = upsideDownBinaryTree(root.left);
        root.left = null;
        root.right = null;
        left.left = right;
        left.right = root;

        return ans;
    }

```
#### [4.5. Leetcode 199：二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)
- 5.14 第一遍
- 思路：BFS。套模板就行了，注意当 size == 0 的时候将 curNode.val 加入ans。
- 复杂度分析：O（N）



#### 复习 [4.6. Leetcode 127：单词接龙](https://leetcode-cn.com/problems/word-ladder/)
5.13 第一遍，5.14 第二遍
思路见[前节 3.1. 题](#1.3)






<h3 id = "1.5">周五(5.15)</h3>

[返回目录](#0)

主题：贪心算法、二叉树；技巧：递归、贪心算法；题数：新题 6 道，复习 3 道

#### [5.1. Leetcode 122：买卖股票的最佳时机II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
5.15 第一遍
- 思路：贪心算法。这是超哥课程上的例题，采用的算法就是低买高卖，求得累加最大值。美股市场才能T+0。
- 复杂度分析：O（N）
```Java
    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        if (len == 0 || len == 1) return profit;
        int pos = 0;
        while (pos < len - 1) {
            int substract = prices[pos+1] - prices[pos];
            if (substract > 0) {
                profit += substract;
            }
            pos += 1;
        }
        return profit;
    }
```


#### [5.2. Leetcode 55：跳跃游戏](https://leetcode-cn.com/problems/jump-game/)
5.15 第一遍
- 思路一：贪心算法，反向贪心。这道题是超哥在视频中讲到了的。解题思路并不是完全和题目给定的一致，而是从最后一项往前走，如果从当前格子可以跳到最后(`nums[i] + i > lastPos`)，就将最后一项更新为当前格子，依次循环，直到第一项。
- 思路二：从起点出发，设置其为起跳点：
  1. 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
  2. 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
  3. 如果可以一直跳到最后，就成功了。
- 复杂度分析：O（N）
```Java
    public boolean canJump(int[] nums) {
        int min = nums.length - 1;
        for (int i = nums.length - 2; i > 0; i--) {
            if (i + nums[i] >= min) {
                min = i;
            }
        }
        return nums[0] >= min;
    }
```

#### [5.3. Leetcode 45：跳跃游戏II](https://leetcode-cn.com/problems/jump-game-ii/)
5.15 第一遍
- 思路：贪心算法，和 55 题思路还是比较相似，
  1. 以第一个位置为起跳点，例如 `nums[0] = 3`，说明第一个格子能跳三格，nums[3] 为第二个节点，count = 2；
  2. 然后，找到这三格中的最大数值，代表的即为这三个格子中最远能达到的距离，它即为下一个节点。
- 复杂度分析：O（N）
```Java
    public int jump(int[] nums) {
        int pos = 0, nextPos = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextPos = Math.max(i + nums[i], nextPos);
            if (nextPos >= nums.length - 1) {
                return count + 1;
            }
            if (i == pos) {
                count += 1;
                pos = nextPos;
            }

        }
        return 0;
    }
```


#### [5.4. Leetcode 860：柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/)
5.15 第一遍
- 思路：贪心算法。需要两个变量记录五元和十元的张数，并遵循以下步骤：
  1. 如果顾客给 5 元，找 0 元；
  2. 如果顾客给 10 元，找 5 元；
  3. 如果顾客给 20 元，找 10 + 5 元；如果没有，找 3x5 元。
- 复杂度分析：O（N），空间复杂度：O（1）


#### [5.5. Leetcode 222：完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/)
5.15 第一遍
思路：简单的递归。两行代码实现。
复杂度：O（N）
```Java
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
```


#### [5.6. Leetcode 235：二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
- 5.15 第一遍
- 思路：236题的弱化版本。在236题中，因为二叉树并非有序，所以需要对递归之后的 left、 right 与 p、q 的相对关系做许多的判断。但是在这里就不需要，因为根据二叉搜索树的特征，当 `p.val > root.val && q.val > root.val`的时候，就 `return lowestCommonAncestor(root.right, p, q)`；反之亦然。
- 复杂度分析：O（N），空间复杂度：O（N）
```Java
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
```

#### 复习 [5.7. Leetcode 236：二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
5.10 第一遍，5.11 第二遍，5.15 第三遍
- 思路：递归。关键问题在于对参数 `left` 和 `right` 的理解，因为这是递归，所以在写递归语句的时候，可以认为左右子树都已经算出来了结果。
  1. 如果当前节点 root 为 null，那么就直接返回 null；
  2. 如果 root 等于 p 或者是 q，那么就返回 p or q；
  3. 接着往下递归。如上所述，递归的时候可以直接认为我们已经求出来了 left 和 right，用它们来表示即可；
  4. 对于返回值，有以下几种情况：
     - 第一，left 和 right 同时为空，说明左右子树都不包含p、q，返回null；
     - 第二，同时不为空，说明在root 的两侧，返回root；
     - 第三，left 为空，right不为空，说明p、q都在右边；
     - 第四，right 为空，left不为空，说明都在左边
- 复杂度分析：O（N）


#### 复习 [5.8. Leetcode 226：翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/submissions/)
4.27 第一遍，5.15 第二遍
- 思路：结构和101题，相同的树非常相似。递归的过程也是比较相似，不同之处就在于不是判断左右节点是否相等了，而是直接交换最左和最右节点的值就可以了。
- 注意：一开始想的是交换 val，后面发现直接交换node，会让整个结构更简单。

#### 复习 [5.9. Leetcode 455：分发饼干](https://leetcode-cn.com/problems/assign-cookies/submissions/)
5.13 第一遍，5.15 第二遍
思路：贪心算法。见[前节 3.3 题](#1.3)

<h3 id = "1.6">周六(5.16)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道



<h3 id = "1.7">周日(5.17)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道


<h2 id = "2">二、数据结构与算法笔记</h2>


<h3 id = "2.1">1. 深度优先搜索</h3>

[返回目录](#0)

代码模板如下：
递归写法：
```Python
   visited = set() 

   def dfs(node, visited):
       if node in visited: # terminator
        # already visited 
        return 

    visited.add(node) 

    # process current node here. 
    ...
    for next_node in node.children(): 
     if next_node not in visited: 
      dfs(next_node, visited)
```
非递归写法：
```Python
   def DFS(self, tree): 

    if tree.root is None: 
     return [] 

    visited, stack = [], [tree.root]

    while stack: 
     node = stack.pop() 
     visited.add(node)

     process (node) 
     nodes = generate_related_nodes(node) 
     stack.push(nodes) 

    # other processing work 
	...
```


<h3 id = "2.2">2. 广度优先搜索</h3>

[返回目录](#0)

代码模板：
```Python
   def BFS(graph, start, end):
       visited = set()
    queue = [] 
    queue.append([start]) 

    while queue: 
     node = queue.pop() 
     visited.add(node)

     process(node) 
     nodes = generate_related_nodes(node) 
     queue.push(nodes)

    # other processing work 
    ...
```
同时，[labuladong](https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/bfs-kuang-jia)对于 BFS 及其框架也给出了很 nice 的代码。
```Java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列 */
            for (Node x : cur.adj())
                if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
        }
        /* 划重点：更新步数在这里 */
        step++;
    }
}
```
同时，在[Leetcode 127：单词接龙](#3.1)问题中，同样的使用到了BFS，但是还有一种很巧妙的方法，它不单单是从头走到尾，而是从头尾同时往中间走，这样就可以让复杂度大大减少，类似于下面的图解：




而它的代码模板也比较相似，如下：
```Java
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

<h3 id = "2.3">3. 贪心算法</h3>

[返回目录](#0)


<h3 id = "2.4">4. 二分查找</h3>

[返回目录](#0)


<h3 id = "2.5">5. </h3>

[返回目录](#0)


<h3 id = "2.6">6. </h3>

[返回目录](#0)













