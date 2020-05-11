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
| 预习 | 动态规划 | Leetcode 198：打家劫舍 |  :ok:  | [周一](#1.1) |
|  |  |   |    | [](#) |



<h3 id = "1.1">周一(5.11)</h3>

[返回目录](#0)

主题：二叉树、动态规划；技巧：递归；题数：新题 1 道，复习 3 道


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

#### 复习[1.2. Leetcode 236：二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/)/[面试题68-II](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/submissions/)
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

#### 复习[1.3. Leetcode 116：填充每个结点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)
5.8 第一遍，5.11 第二遍
 - 思路一：递归。递归非常简洁，是必须要会的一个技巧。简单来说，将 node 指向右侧节点有三种情况：
   - 第一，node 本身为空，那么返回 null 就好了
   - 第二，node 的左子节点不为空，那么直接 `node.left.next = node.right`，将左子节点指向右子节点
   - 第三，node 的右子节点不为空，那么就需要判断 node.next 是否为空，如果是，说明右边没有节点了，将 node.right = null 就行；如果不是，则将其指向 node.next 的左子节点。`node.right.next = node.next.left`
- 复杂度分析：O（N）
- 思路二：迭代。题目要求空间复杂度为 O（1)。所以采用迭代来达到这个要求。
  - 在这里我们设置三个指针：第一个 level，指向每一层的最左边的节点；第二个 prev，指向要延伸出 next 指向右边的节点；第三个是 cur， 指向 prev 右边一个节点。所以 cur 可以为 null，代表的是 prev 已经到达了这一层的最右端。
  - 连接的关键在于通过 level 来控制在哪一层进行操作，通过 cur 来控制是否到达最右端、是否需要下移三个指针，通过 prev 来将 prev 的子节点连接起来：`prev.left.next = prev.right` 以及 `prev.right.next = cur.left`


#### 复习[1.4. Leetcode 117：填充每个结点的下一个右侧节点指针II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/)
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





<h3 id = "1.2">周二(5.12)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.3">周三(5.13)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.4">周四(5.14)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.5">周五(5.15)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道




<h3 id = "1.6">周六(5.16)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道



<h3 id = "1.7">周日(5.17)</h3>

[返回目录](#0)

主题：；技巧：；题数：新题 道，复习 道


<h2 id = "2">二、数据结构与算法笔记</h2>


<h3 id = "2.1">1. 深度优先搜索</h3>

[返回目录](#0)



<h3 id = "2.2">2. 广度优先搜索</h3>

[返回目录](#0)



<h3 id = "2.3">3. 贪心算法</h3>

[返回目录](#0)


<h3 id = "2.4">4. 二分查找</h3>

[返回目录](#0)


<h3 id = "2.5">5. </h3>

[返回目录](#0)


<h3 id = "2.6">6. </h3>

[返回目录](#0)













