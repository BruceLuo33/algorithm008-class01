
# 第三周学习记录(4.27-5.10)

<span id ="0">
 
## [一、刷题记录](#1)

| [周一(4.27)](#1.1)  |[周二(4.28)](#1.2)  | [ 周三(4.29)](#1.3) |[周四(4.30)](#1.4) | [周五(5.1)](#1.5) |[周六(5.2)](#1.6) | [周日(5.3)](#1.7) |
| :---: | :----: | :---: | :----: | :----: | :----: | :----: |
| [周一(5.4)](#1.8)  |[周二(5.5)](#1.9)  | [ 周三(5.6)](#1.10) |[周四(5.7)](#1.11) | [周五(5.8)](#1.12) |[周六(5.9)](#1.13) | [周日(5.10)](#1.14) |


 
## [二、数据结构笔记](#2)
  * [1. 优先队列](#2.1)
  * [2. 堆（二叉堆）](#2.2)
  * [3. 二叉搜索树](#2.3)
  * [4. 散列表（Hashing）](#2.4)
  * [5. 递归](#2.5)
  * [6. 回溯](#2.6)


<h2 id = "1">一、刷题记录</h2>

总结：课内课外共计刷题52道，其中作业题18道。主题集中于链表、二叉树等数据结构，回溯、递归、DFS、BFS、双指针、HashMap 与字符串处理等技巧。为期两周，其中三天集中复习，保证大部分有价值的题目都做了 2~4 遍。其中课内作业总结如下：

| 题目类型 | 知识点 | 题目 | 完成情况 | 地址 |
| --- | --- | --- | --- | --- |
| 实战 | 回溯、字符串 | Leetcode 17：电话号码的字母组合 |  :ok:  | [周六(5.9)](#1.13) |
| 实战 | 递归、字符串 | Leetcode 22：括号生成 |  :ok:  | [周四](#1.4) |
| 实战/作业 | 回溯 | Leetcode 46：全排列 |  :ok:  | [周五(5.8)](#1.12) |
| 实战/作业 | 回溯、剪枝 | Leetcode 47：全排列II |  :ok:  | [周六(5.9)](#1.13) |
| 实战 | 递归、快速幂 | Leetcode 50：Pow(x,n) |  :ok:  | [周日(5.10)](#1.14) |
| 实战 | 回溯、剪枝 | Leetcode 51：N皇后 |  :ok:  | [周六(5.9)](#1.13) |
| 实战 | 动态规划 | Leetcode 70：爬楼梯 |  :ok:  | [周一(5.4)](#1.8) |
| 实战/作业 | 回溯 | Leetcode 77：组合 |  :ok:  | [周六(5.9)](#1.13) |
| 实战 | 回溯 | Leetcode 78：子集 |  :ok:  | [周六(5.9)](#1.13) |
| 实战 | 二叉树、递归 | Leetcode 98：验证二叉搜索树 |  :ok:  | [周一](#1.1) |
| 预习 | 二叉树、BFS | Leetcode 102：二叉树的层序遍历|  :ok:  | [周二](#1.2)|
| 实战 | 二叉树、递归 | Leetcode 104：二叉树最大深度|  :ok:  | [周四](#1.4)|
| 实战/作业 | 二叉树、DFS、HashMap | Leetcode 105：从前序与中序遍历序列构造二叉树|  :ok:  | [周三](#1.3)|
| 实战 | 二叉树、递归 | Leetcode 111：二叉树最小深度|  :ok:  | [周四](#1.4)|
| 实战 | 数学、Hashing | Leetcode 169：多数元素 | :ok:  | [周四(5.7)](#1.11) |
| 实战 | 二叉树、递归 | Leetcode 226：翻转二叉树|  :ok:  | [周一](#1.1)|
| 实战/作业 | 二叉树、递归 | Leetcode 236：二叉树的最近公共祖先 |  :ok:  | [周日](#1.14) |
| 实战 | 二叉树、BFS、字符串 | Leetcode 297：二叉树的序列化与反序列化|  :ok:  | [周四](#1.4)|


<h3 id = "1.1">周一(4.27)</h3>

[返回目录](#0)

主题：二叉树；技巧：递归、中序遍历；题数：新题5道，复习2道

#### [1.1. Leetcode 98：验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)。
4.27 第一遍
- 思路一：中序遍历。题目的要求是判断二叉树值得大小是否为从小到大排列。因此用中序遍历得 左-->根-->右，就可以比较好的解决这个问题。只要相邻两个元素不满足前项小于后项的关系，就返回false。
  - 注意：在存储树的 val 时，数据结构可以用 stack 或者是 arraylist。
  - 注意：判断左子节点的 value（已经存入 ans）与 root.val 关系的时候，要判断是否 >=，而不仅仅是 >
  - 复杂度分析：O（N），空间复杂度：O（N）

- 思路二：递归。对于每一个节点，正确的范围应该是小于右子树中的最小值 + 大于左子树中的最大值。
因此，我们可以设置递归，每次都已上一个节点作为左/右的一个边界，如果越界，代表出错。如下图所示。
  - 从下图，我们可以总结出结论：如果是左子节点，那么应该以父节点为右边界，以父节点的左边界为左边界；如果是右子节点，应该以父节点为左边界，以父节点的右边界为右边界。
  - 注意：设置max/min 的时候，要将其再扩大一个位置，MAX_VALUE + 1 和 MIN+VALUE - 1
  - 注意：判定是否越界的时候，要用`node.val >= max` 而不能用 `node.left.val >= node.val`，因为我们的 terminator 条件只判定了 `node ！= null`，但没有检查 node.left，所以会出现空指针错误。正确的做法应该是 `if (node.val >= max)`
  - 复杂度分析：O（N），空间复杂度：O（1）
    ```Java
                  10 (-inf, inf)
                   /          \
           5(-inf, 10)      17(10, inf)
            /     \          /       \
      3(-inf, 5)  7(5,10)  13(10, 17)   20(17, inf)
    ```
#### [1.2. Leetcode 99：恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/)
4.27 第一遍
- 思路：采用中序遍历。从 98 题中我们知道，对一个二叉树进行中序遍历，得到的数组将会从小到大排列。因为题中已经说明，仅有两个节点被错误的交换，因此我们可以使用双指针来遍历。对于两个节点被交换，会产生以下几种情况：
  - case 1：[1,2,3,4,5] 中，1和2被交换，因此会产生一个错误数值对。交换后是[2,1,3,4,5]，{2，1}是错误数值对
  - case 2：[1,2,3,4,5] 中，2和5被交换，此时会产生两个错误数值对。[1,5,3,4,2]中，{5，3}与{4，2}都是。
- 所以我们可以将前后节点互相比较，如果前节点大于后节点，就违反了二叉树的定义，也就是我们要找的一种情况，用first 和 second 来分别保存；然后继续递归，找到第二组逆序的数字，则将second 赋值为第二组逆序中的后一个数字（case two 的2），然后交换first 和 second 即可。
- 注意：判断前后结点的值的时候，应该是 pre.val > root.val，即前节点的值大于现节点的值。
- 注意：赋值的时候，first 应该指向 pre，second 应该指向 root。对应着上面的case 2，将第一个逆序对的第一个元素和第二个逆序对的第二个元素，交换。
- 注意：在寻找第一个逆序对的时候，`second = root` 的这个将 second 指向 root 的步骤不能省略。如果省略，就默认了只有 case 2 会出现，忽略了 case 1 的情况。
- 注意：中序遍历的时候，`pre = root` 和用 if 语句寻找逆序对的顺序不能交换
- 复杂度分析：O（N）

#### [1.3. Leetcode 100：相同的树](https://leetcode-cn.com/problems/same-tree/)
4.27 第一遍
- 思路：递归。代码很简洁，粘贴于下。
- 复杂度：O（N），空间复杂度：O（k）k为树的高度
  ```Java
      public boolean isSameTree(TreeNode p, TreeNode q) {
          if (p == null && q == null) return true;
          if (p == null || q == null) return false;
          if (p.val != q.val) return false;
          return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
      }
  ```

#### [1.4. Leetcode 101：对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)
4.27 第一遍
- 思路：递归。和100题比较相似，都是递归的应用。要注意的是，最终的return项应该是 left.right 、 right.left，因为题目要求的是对称，所以就是往两边走要想等。
- 复杂度分析：O（N），空间复杂度：O(K)，k为树的高度。
```Java
     1
   /  \
  2    2
 / \   / \
3  4  4   3
```

#### [1.5. Leetcode 226：翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)
4.27 第一遍
- 思路：结构和101题，相同的树非常相似。递归的过程也是比较相似，不同之处就在于不是判断左右节点是否相等了，而是直接交换最左和最右节点的值就可以了。
- 注意：一开始想的是交换 val，后面发现直接交换node，会让整个结构更简单。


#### 复习[1.6. Leetcode 1：两数之和](https://leetcode-cn.com/problems/two-sum/)
4.25 第二遍，4.27第三遍
- 思路一：很早之前做过这道题。直接用的两遍循环。暴力破解，复杂度O（N^2)
- 思路二：降低复杂度，使用 HashMap。
- 步骤：1、将nums 放入 HashMap；2、对于每一个元素 i，找出 target - i 是否在 map中；3、如果在，返回下标；如果不在，返回空数组。
- 注意：判断map 是否有key 的时候，因为题目要求同一个元素不能使用两次，所以还需要判定 map.get(target - nums[i]) != i。

#### 复习[1.7. Leetcode 264：丑数II](https://leetcode-cn.com/problems/ugly-number-ii/) / [面试题 17.09：第 K 个数](https://leetcode-cn.com/problems/get-kth-magic-number-lcci/)
4.25 第一遍，4.27 第二遍，5.4 第三遍。一开始还有点没想出来。后面看了之前写的代码，立刻就回忆起来了。复习还是很有必要的。具体思路如下。
- 思路：先分析每一个丑数，设丑数为 y，则其符合这个公式 y = a·2 + b·3 + c·5. 自然而然，一开始会想到，是不是需要将 a/b/c 都求出来，但这样是陷入了误区，且看下面三个数组：
```Java
Array 1: 1x2, 2x2, 3x2, 4x2, 5x2, 6x2, 7x2……
Array 2: 1x3, 2x3, 3x3, 4x3, 5x3, 6x3, 7x3……
Array 3: 1x5, 2x5, 3x5, 4x5, 5x5, 6x5, 7x5……
```
- 从上面的数组，我们可以很明显的看到，假设数组长度无限，那么每一个数组其实都全部包含了余下的两个数组。但这会引发一个新的问题，那就是有的数字，例如7x2就不属于丑数。因此我们不需要三个数组，只能在同一个丑数数组上进行操作。设置三个指针，分别乘以对应的系数，然后将较小的数放入丑数数组中，并将其指针后移一位。依此类推，直到第 k 个数。
- 可以这么进行计算的原因基于以下两个基本假设：
  - 第一，每一个丑数都是由之前的丑数乘 2 or 3 or 5而来；
  - 第二，如果一个丑数已经乘了 2 or 3 or 5，那它就不能再用了，因为会与之前相同的丑数，产生重复计算
- 所以，根据这两个假设，我们只需要将指针指向丑数数组，并且每次将 2 or 3 or 5 的指针后移一位即可

```Java
Step 1:
UglyArray：  1 ...
            ^^^
指针：      235
因为三个因素分别相乘 1，得到的积 Math.min(1x2, 1x3, 1x5) = 2. 所以将 2 的指针往后移

Step 2:
UglyArray：1，1x2 ...
          ^^   ^
指针：    35   2 
再次计算 Math.min(1x3, 1x5, 2x2) = 3，所以将 3 的指针后移

Step 3:
UglyArray：1，1x2, 1x3 ...
           ^   ^    ^
指针：     5   2    3
依次类推

```





<h3 id = "1.2">周二(4.28)</h3>

[返回目录](#0)

主题：二叉树宽度优先搜索（BST）；技巧：宽度优先、队列；题数：新题2道

#### [2.1. Leetcode 102: 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
4.28 第一遍
- 思路：使用 BFS 对树进行层间遍历。每次都用一个队列来接受root，然后将其放入答案链表即可。
- 注意：在判定当前子节点等级与 `ans.size()` 的关系的时候，要写 `>=` 而非 `>`，因为在一开始的时候，二者都是 0，如果不加 `=`，整个循环就无法开始。
- 复杂度分析：O（N） 空间复杂度：O（N）

#### [2.2. Leetcode 103: 二叉树的锯齿状层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
4.28 第一遍
- 思路：这道题和102题几乎一样，唯一的不同之处在于如果 level 为奇，就是从左往右，如果是偶数，就是从右往左。因此对 curLevel 增加一个奇偶判断就可以了
- 复杂度分析：O（N），空间复杂度：O（N）
```Java

Codes in 102::
    ans.get(curLevel).add(curNode.val);

Codes in 103::
    if (curLevel % 2 == 0 ) {
        ans.get(curLevel).add(curNode.val);
    } else {
        ans.get(curLevel).add(0, curNode.val);
    }
```


<h3 id = "1.3">周三(4.29)</h3>

[返回目录](#0)

主题：二叉树；技巧：递归、深度优先搜索(DFS)，广度优先搜索（BFS)，字符串处理；题数：新题5道，复习2道

#### [3.1. Leetcode 105: 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
4.29 第一遍
- 思路一：回顾一下，前序遍历指的是 root --> left --> right，中序遍历指的是 left --> root --> right。根据两个遍历的特征，我们可以知道，前序遍历数组的第一个元素，即为根节点，再由这个根节点与中序遍历匹配，找到中序遍历中的根节点，则其左边就是左子树，右边就是右子树。然后再次回到前序遍历数组剩下的部分，第一个元素为右子树的根节点，以此类推。
  - 由上述分析可以看出，递归非常适合这道题目。
  - 注意：找 root 节点的时候，下标应该为 p_start 而不是 0
  - 注意：helper 函数 return null 的条件应该是 preorder 数组的 start == end
  - 注意：helper 函数的输入参数中，p_end 和 i_end 都不用 -1
  - 注意：在递归的过程中，p_start 更新应该要 +1. 因为将 preorder 的根节点拿出来后，左子树要从根节点之后开始计算。

- 复杂度分析：O（N），空间复杂度：O（N)
- 思路二：在上一个思路中，我们发现每一次从 inorder 数组中去找 root 节点，都需要用 for 循环去遍历，这样就无疑增加了复杂度。
  - 基于此，考虑加入一个 Map 来降低复杂度，将 inorder 的每一个数字和位置都输入 map，可以将复杂度降低很多

```Java
preorder = [3, 9, 20, 15, 7]
               ^
             root
inorder   = [9, 3, 15, 20, 7]
            Left  |   Right

根据根节点分割后：
左子树：
preorder = [9]
inorder  = [9]

右子树：
preorder = [20, 15, 7]
inorder  = [15, 20, 7]

现在只需构造左子树和右子树即可，成功把大问题化成了小问题
不断迭代，直到 preorder 和 inorder 都为空，返回 null 
```

#### [3.2. Leetcode 106: 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
4.29 第一遍
- 思路：这道题和 105 题基本思路一样。不同之处在于将前序遍历换成了后序遍历。所以在找 root 的时候换一下位置，其他不变就可以了

#### [3.3. Leetcode 107: 二叉树的层序遍历II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
4.29 第一遍
- 思路：这道题和102基本一样，同样用到 BFS 来解题
- 稍微不同的地方在于，102 是从根节点往下遍历，但是这里是从叶子节点往上遍历。所以只需要将一个地方更改，即将每一层的元素插入到 ans 数组的第一个位置，就可以了，见下：

```Java
codes in 102: 
ans.get(curLevel).add(node.val);

codes in 107
ans.get(0).add(node.val);
```

#### [3.4. 面试题05：替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)
4.29 第一遍
- 思路：一开始想这道题似乎很简单，后面才发现难点在于在 JAVA 中，String 被设置为不可改变的类型，所以需要额外设置一个字符串来进行操作。
- 复杂度分析：O（N），空间复杂度：O（N）

#### [3.5. 面试题06：从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
4.29 第一遍
- 思路：很简单的一道题。两个循环，第一个遍历链表，得到数组的大小。第二个反向将链表的值放入数组。
- 思路二：用递归来做，多设置一个 ArrayList，然后设置 recursive 函数，在递归调用到了最底层之后，再往 ArrayList 中添加值就可以了。
```Java
        private void recursive(ListNode head) {
            if (head == null) return;
            recursive(head.next);
            tmpArray.add(head.val);
        }
```
- 注意：要设置额外的指针来指向链表，因为不能改动原来的 head 链表。
- 复杂度分析：O（N），空间复杂度：O（N）


#### 复习 [3.6. Leetcode 102: 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
4.28 第一遍，4.29 第二遍

#### 复习 [3.7. Leetcode 103: 二叉树的锯齿状层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
4.28 第一遍，4.29 第二遍




<h3 id = "1.4">周四(4.30)</h3>

[返回目录](#0)

主题：二叉树；技巧：递归、深度优先搜索(DFS)，广度优先搜索（BFS)，字符串处理；题数：新题6道，复习2道

#### [4.1. Leetcode 22: 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
4.30 第一遍
- 思路：这道题是超哥在视频中详细讲解的。对我的启发有两点：自顶向下编程与结构化思维。
- 结构化思维：递归都是四个步骤：terminator, process logic, drill down, restore status
- 对于题目的要求，要作以下几个考虑：第一，`left < n`；第二，`right < left`，以这两个为判断递归的标准即可
- 注意：递归函数不能用 `List<String>`，要传入 String s，然后将 s 加到全局变量 `List<String>` 中



#### [4.2. Leetcode 297: 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
4.30 第一遍
- 思路一：一开始看这个题目，感觉这不就是 94 和 105 的综合吗？先将一个二叉树前序/中序遍历完成 serialize，然后用它的前序和中序遍历来重建二叉树。这个思路没有太大问题，但是忽略了一个很重要的点，那就是给定序列的元素是可能重复的！
  - 例如 `[3, 2, 4, 3]`，这里有了重复的元素，那么用 105 的方法来重建的时候，就会出现在 inorder 数组中找不到 root 位置的情况
- 思路二：既然 DFS works bad，那么就用 BFS。按照 102 题的方式来层序遍历，要注意的点是遇到 null 就记录 null。在还原的函数中，输入的是 String，所以首先我们要将其转换为 String 数组，然后再将其转换为 Integer，同时 null 也要判断与记录
- 注意：在 serialize 函数中，因为返回的值是 String 而非 `List<List<String>>`，所以不再需要用 level 来控制 return 的维度
- 注意：在 serialize 函数中，因为 node.val 是 Integer，所以用一个整型 List 去接收答案会比较好
- 注意：在 deserialize 函数中，有一个小 bug 找了很久才找出来，那就是要记得在 String 数组转换为 Integer 数组的时候，使用 trim() 将空格切掉。
- **总结**：这道题的难点，不在于 serialize，而是如何重建二叉树。因为之前在 105 题中的经验不管用，所以需要用其他的方法来做。在这里我们使用了队列来保存即将访问的 `root.left` 和 `root.right`，并且根据二叉树的特征，即只有左子树和右子树，使用了两个 if 来往最终的二叉树中添加 node。并在每一个 node 之后将位置指针 `curPos + 1`
 - 复杂度分析：O（N）


#### [4.3. Leetcode 108：将有序数组转化为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)
4.30 第一遍
- 思路一：一开始的时候想到了能否用 `weighted-Union Find` 算法，但是对于一道算法题，应该不需要这么复杂。
- 思路二：联想到之前做过的题目：
  - 从 98 和 99 题我们可以知道，一个二叉树的中序遍历刚好就是一个升序的数组；
  - 从 105 和 106 我们知道，如果有了中序遍历与前序 or 后序遍历的数组，我们就能重建一个二叉树。
  - 而还原二叉树的关键，就在于找到根节点。那么这道题也就做出来了：因为给定的是有序数组，且要求我们实现一个高度平衡的二叉树，所以我们找根节点也就很简单了：直接用中间的数字当作根节点即可。
- 注意：数组的 End 应该是 nums.length，不需要 -1，如果 -1，则相当于丢掉了数组的最后一项
- 注意：求中间位置索引的时候，用 Math.floor 方法会超时，直接 /2 就可以了
- 复杂度分析：O（N）

#### [4.4. Leetcode 109: 将有序链表转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/)
4.30 第一遍
- 分析：这道题和 108 题非常相似，区别在于链表不支持随机访问，所以获取根节点的坐标会相对困难。在此我们可以提出三种解法思路。
- 思路一：既然链表无法随机访问，我改成一个可以随机访问的不就行了吗？于是可以新建一个 `ArrayList<Integer>` 用来接收给定 List 中的元素，其他的步骤和 108 题一模一样，时间/空间复杂度为 O（N）
- 注意：对于线性表 ArrayList，随机访问的方式为 `listValue.get(mid)`，mid 为中间位置的 index，关键代码如下：
```Java
    private TreeNode helper(ArrayList<Integer> listValue, int start, int end) {
        if (start == end) return null;
        int mid = (int) (start + end) / 2;
        TreeNode root = new TreeNode(listValue.get(mid));
        root.left = helper(listValue, start, mid);
        root.right = helper(listValue, mid + 1, end);
        return root;
    }
```

- 思路二：如果不设立数组，我们怎么找链表的中点？双指针。双指针有前后指针和快慢指针，在这里我们才用快慢指针来找到中点，然后其余步骤与 108 题一样。
  - 但是这个方法的问题在于，由于我们并没有改变数据结构，所以每次递归都需要重新跑一边快慢指针。所以最终复杂度反而会升高，变成了O（NlogN），空间复杂度O（logN）
- 思路三：参考了答案，得到了一种最佳的解法。这种做法是模仿中序遍历。在中序遍历中，我们采用的方式是将一个二叉树按顺序赋值给一个数组，在这里，我们可以采用相似的办法，但是不同的点在于这一次是利用中序遍历赋值给二叉树。
- 注意：要设置一个全局变量的指针指向head，设置全局变量的原因是递归加入指针的参数会很麻烦
- 注意：在遍历右子树之后，cur不再需要后移，关键代码如下：
```Java
    private TreeNode helperThree(int start, int end) {
        if (start == end) return null;
        int mid = (int) (start + end) / 2;

        // 遍历左子树，找到左子根节点，此时 start == null，会返回 null
        TreeNode left = helperThree(start, mid);
        TreeNode root = new TreeNode(curNode.val);
        root.left = left;

        curNode = curNode.next;
        
        // 遍历右子树，找到右子根节点，此时 start == null，会返回 null
        TreeNode right = helperThree(mid + 1, end);
        root.right = right;
        
        return root;
    }
```

#### [4.5. Leetcode 112：路径总和](https://leetcode-cn.com/problems/path-sum/)
4.30 第一遍
- 思路：这道题和 111 求最小深度的题很相似。同样的要注意的问题也很相似，那就是要避免出现 spindly 树，导致过早的结束递归所带来的误判
- 复杂度分析：O（N），空间复杂度：O（logN）~ O（N）


#### [4.6. Leetcode 145：二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/)
4.30 第一遍
- 思路：简单的后序遍历

#### 复习 [4.7. Leetcode 104：二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
4.24 第一遍，4.30 第二遍
- 思路：递归。从 root 出发，最大的深度等于 1+ 左/右 的node 最大深度。
- 复杂度分析：O（N），空间复杂度：O（1）



#### 复习 [4.8. Leetcode 111：二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
4.24 第一遍，4.30 第二遍
- 思路：一开始的时候，想着和 104 题很相似，那是不是直接将 return 的项由 Math.max 转换成 Math.min 就可以呢？明显不是。因为如果某一个子节点为 null，则这个方法就会选择这个子节点。但事实上这样算出来对于 spindly 的case，也就是 worst case，会出现明显的误判。
- 因此需要加两行判断，即如果左子节点为 null，就 `return minDepth(root.left) + 1`，如果右子节点为 null，则返回左子节点。
- 注意：判断左右子节点为 null，return 的项要 +1. 这表示循环往下走了一层。否则循环往下走，但是 height 没有记录，就会出错。
- 复杂度分析：O(N)






<h3 id = "1.5">周五(5.1)</h3>

[返回目录](#0)

主题：二叉树；技巧：递归、回溯、；题数：新题 2 道

#### [5.1. Leetcode 113：路径之和 II](https://leetcode-cn.com/problems/path-sum-ii/)
5.1 第一遍
- 思路一：这道题和 112 很相似。不同之处在于 112 题只要求返回一个路径之和是否等于 target，这个题目还要求返回整个路径上的元素。
  - 有一点不同的是，因为 List 传入的并不是值，而是对值的地址的引用，所以要 `ans.add(new ArrayList<>(tmp))` 而不是简单的 `ans.add(tmp)`，否则在之后 tmp 值变化的时候，ans 中之前传入的 tmp 也会发生变化。
- 思路二：在第一个方法中，我们传入的参数是 `ArrayList<Integer> tmp` 和 `List<List<Integer>> ans`，但实际上我们也可以将 ans 设计为全局变量，不再作为参数传入，而是传入另一个 `int curSum`，这样可以方便将 sum 分开看。同时判断空叶子节点的时候也可以选择 `if (root.left != null)`，这样方便思考。
- 复杂度分析：O(N)
- 运行结果：
  - 执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户
  - 内存消耗 :40.3 MB, 在所有 Java 提交中击败了5.26%的用户

#### [5.2. Leetcode 114：二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)
5.1 第一遍
- 思路：观察最终需要的目标链表，实际上就是原二叉树的前序遍历。又因为题目要求我们原地展开，所以不能新建链表，而是应该将 `root.left` 指向 `root.right` 或者是反过来。
  - 然而如果直接按照从根节点出发，我们会发现右子树会丢失。原因是将 `root.right` 指向 `root.left`的时候，右子树丢失了。既然正向走行不通，那么能否自底向顶走？即：
  - 递归到 6，然后将 5 的指针指向6：`6 <- 5 4 3 2 1`
  - 递归到 5，然后将 4 的指针指向5：`6 <- 5 <- 4 3 2 1`
  - 综合起来，这就是一个变形的后序遍历：
  - 原后序遍历：左 -> 右 -> 根
  - 现后序遍历：右 -> 左 -> 根
  - 然后利用一个暂时的指针指向要移动的node，不停递归就可以了。代码也很简单，如下：
- 复杂度分析：O（N）
- 运行结果：
  - 执行用时 :0 ms, 在所有 Java 提交中击败了 100.00%的用户
  - 内存消耗 :39.4 MB, 在所有 Java 提交中击败了6.67%的用户
```Java
    TreeNode tmp = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);            
        root.right = tmp;
        root.left = null;
        tmp = root;
    }

```
<h3 id = "1.6">周六(5.2)</h3>

[返回目录](#0)

休息


<h3 id = "1.7">周日(5.3)</h3>

[返回目录](#0)

主题：复习、二叉树；技巧：递归；题数：复习 3 道

#### 复习 [7.1. Leetcode 242：有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
4.23 第一遍，5.3 第二遍
- 思路一：暴力破解。将string sort，然后比较每一个元素。
- 思路二：HashMap。第一个循环将 s 中的所有char 放入map，然后再去检查 t 中每一个元素是否在里面
  - 在这道题中，因为比较的元素只有 26 个字母，所以我们事实上可以用数组来充当 HashMap，0-25 分别代表 a-z
  - 遍历两个字符串， String s 中出现的字母，将其对应数组值 +1，String t 中出现的字母，将其对应数组值 -1， 最后判断这个数字是否为空即可。
- 复杂度分析：1、O（NlogN）；2、O（N）
- 注意：不要将 s/t 转换为 charArray，直接用 charAt 来做就可以了

#### 复习 [7.2. Leetcode 110：平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)
4.24 第一遍，5.3 第二遍
- 思路一：最简单的思路，利用104题已经做出来的计算 height，来判断左右节点的height 之差是否大于一
  - 但是这会造成一个问题，那就是大量的重复计算。
- 思路二：直接在计算 height 的函数中，判断左右 node 的 height 相差是否大于 1.
- 注意：如果左右子树都不是平衡的，则 `Math.abs(leftHeight - rightHeight) == 0` 将会成立，为了避免这个情况，需要对height 进行判断，是否为 -1
- 复杂度分析：O（N）
```Java
思路二代码：直接判断左右 node 高度差是否大于一，递归：

int leftHeight = helper(root.left);
int rightHeight = helper(root.right);
if (Math.abs(leftHeight - rightHeight)) > 1 return false;
return 1 + Math.max(leftHeight, rightHeight);

```
- 上述代码会出现一个问题，那就是当左右返回的 height 都是 -1 的时候，判定会失效。所以需要提前加一个判定，这样我们的最终结果才是完备的。
```Java
int leftHeight = helper(root.left);
if (leftHeight == -1) return false;

int rightHeight = helper(root.right);
if (rightHeight == -1) return false;

if (Math.abs(leftHeight - rightHeight)) > 1 return false;
return 1 + Math.max(leftHeight, rightHeight);
```
- 执行用时 :1 ms, 在所有 Java 提交中击败了99.80%的用户
- 内存消耗 :39.9 MB, 在所有 Java 提交中击败了23.53%的用户


#### 复习 [7.3. Leetcode 559: N叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/)
4.24 第一遍，5.3 第二遍
- 思路：这道题的解法其实和 104 一样。不同之处在于 104 只有两个node，这里有很多个node，所以只需要对整个 children 的 list 进行遍历就可以了。简单来说，一棵树的最大高度，就是所有子树中的最大高度 + 1
- 注意：递归调用的位置，应该在 children 节点。
- 复杂度分析：O（N）
```Java
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxVal = 0;
        for (Node child : root.children) {
            int tmp = maxDepth(child);
            maxVal = Math.max(maxVal, tmp);
        }
        return maxVal + 1;
    }
```
- 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
- 内存消耗 :40 MB, 在所有 Java 提交中击败了13.33%的用户




<h3 id = "1.8">周一(5.4)</h3>

[返回目录](#0)

主题：复习、二叉树；技巧：递归；题数：复习 11 道

#### 复习 [8.1. Leetcode 144：二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
4.24 第一遍，5.4 第二遍
- 思路：前序遍历，经典算法。
  - 第一步：append root value
  - 第二步：递归左树
  - 第三步：递归右树
- 复杂度分析：O（N），空间复杂度：O（logN）~ O（N），取决于 root 的形态

#### 复习 [8.2. Leetcode 94：二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
4.24 第一遍，5.4 第二遍
- 思路：前序遍历，经典算法。
  - 第一步：递归左树
  - 第二步：append root value
  - 第三步：递归右树
- 复杂度分析：O（N），空间复杂度：O（logN）~ O（N），取决于 root 的形态


#### 复习[8.3. Leetcode 264：丑数II](https://leetcode-cn.com/problems/ugly-number-ii/) / [面试题 17.09：第 K 个数](https://leetcode-cn.com/problems/get-kth-magic-number-lcci/)
4.25 第一遍，4.27 第二遍，5.4 第三遍。
思路见[前节 1.7题](#1.1)

#### 复习 [8.4. Leetcode 543：二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)
4.25 第一遍，5.4 第二遍
- 思路：递归。一开始想的是树的直径就是root 往两边走的叶子节点最大深度之和。
  - 然而问题在于，叶子节点是对的，但是不一定经过 root。在这里采用递归，可以比较好的避免这个问题：
  - 遍历每一个节点，将这一个节点当作root，求出它的深度，则左子树加右子树的深度，就是当前节点作为 root 的直径；
  - 然后存入 maxDepth，以后的每一个节点都和 maxDepth 比较，如果大于则放入。直到完成循环。
- 注意：递归 return 的项是 leftDepth 和 rightDepth 中较大值 +1，相当于在这里选定了只走较长边。
- 注意：maxDepth 要设置为全局变量，否则只能当作参数输入 depth，会在递归的时候造成麻烦
- 复杂度分析：O（N），空间复杂度：O（k），k为树的深度


#### 复习 [8.5. Leetcode 75：颜色分类](https://leetcode-cn.com/problems/sort-colors/)
4.26 第一遍，5.4 第二遍
- 思路：双指针。第一个指针之前全都是0；第二个指针之后全都是2；二者中间全都是1.
- 注意：在移动 twoLoc 的时候，交换了 twoLoc 与 i 的位置，此时for循环将会令 i++，但是这是不正确的。因为我们并不知道 `nums[twoLoc]` 到底值是多少，所以还需要将 i--，来判断交换了位置之后的 `num[twoLoc]`，或者说新的 `nums[i]` 的大小。
- 注意：因为在 twoLoc 处将 i 往前移了一位，所以不再需要将循环条件设置为 i < nums.length-1, 设置为 i < twoLoc 即可。否则 twoLoc 将会进一步翻转，将 1 翻到后面。
- 复杂度分析：O（N），空间复杂度：O（1）

#### 复习 [8.6. Leetcode 98：验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)
4.27 第一遍, 5.4 第二遍
思路见[前节 1.1 题](#1.1)

#### 复习 [8.7. Leetcode 99：恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/)
4.27 第一遍, 5.4 第二遍
思路见[前节 1.2题](#1.1)

#### 复习 [8.8. Leetcode 100：相同的树](https://leetcode-cn.com/problems/same-tree/)
4.27 第一遍, 5.4 第二遍
思路见[前节 1.3 题](#1.1)

#### 复习 [8.9. Leetcode 102：二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
4.28 第一遍，4.29 第二遍，5.4 第三遍
思路见[前节 2.1 题](#1.2)

#### 复习 [8.10. Leetcode 103：二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
4.28 第一遍，4.29 第二遍，5.4 第三遍
思路见[前节 2.2 题](#1.2)


#### 复习 [8.11. Leetcode 70：爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
4.10 第一遍，4.22 第二遍，5.4第三遍
- 思路一：递归。将到达第 n 级台阶拆解为到达第 n-1 和 n-2，然后再往前走 1 or 2 步。就能完成任务。
  - 步骤：先写停止递归条件（数学归纳法里面的首步条件，然后写递归公式
  - 注意：如果用斐波那契数列的写法，会造成时间过长，在这里我们要保存每一步的内容，需要用到动态规划
- 思路二：递推。与递归不同，递推是从底向上的思维。在递归中我们考虑`f(n) = f(n-1) + f(n-2)`，而在这里我们先考虑 `f(1) = 1, f(2) = 2`，然后根据公式计算 `f(3) = f(2) + f(1)`，并依次进行，直到 f(n) 
  - 注意：循环的起始位置应该为 i = 2，代表从第二季台阶开始爬楼梯
- 复杂度分析：O（N）

<h3 id = "1.9">周二(5.5)</h3>

[返回目录](#0)

今天接昨天，主要复习的还是二叉树。二叉树的结构使得递归算法尤其适合它。
主题：复习、二叉树；技巧：递归；题数：复习 4 道


#### 复习 [9.1. Leetcode 105：从前、中序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
4.29 第一遍，5.5 第二遍
思路见[前节 3.1 题](#1.3)

#### 复习 [9.2. Leetcode 106：从中、后序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
4.29 第一遍，5.5 第二遍
思路见[前节 3.2 题](#1.3)

#### 复习[9.3. Leetcode 108：将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)
4.30 第一遍，5.5 第二遍
思路见[前节 4.3 题](#1.4)

#### 复习 [9.4. Leetcode 109: 将有序链表转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/)
4.30 第一遍，5.5 第二遍
思路见[前节 4.4 题](#1.4)


<h3 id = "1.10">周三(5.6)</h3>

[返回目录](#0)

今天主要复习的内容是链表。和二叉树一样，链表的数据结构使得它也天生适合递归。不过我的理解还不是很到位，大多数题目目前都是用的迭代法。即各种指针指来指去，遇到不理解的地方画图就好。
主题：复习、链表；技巧：迭代、指针、图像法；题数：复习 4 道

#### 复习 [10.1. Leetcode 26：删除排序数组重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
4.13 第一遍，4.22 第二遍，5.6 第三遍
- 思路：和移动数组中的零项思路差不多。双指针来做。
- 注意：first 指针应该指向最后一项不相等的元素。例如 1，1，2，3；则first应该指向第一个 1.
- 注意：最后返回项应该为 first + 1 而不是 first
- 复杂度：O（N），空间复杂度O（1）

#### 复习 [10.2. Leetcode 88：合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)
4.15 第一遍，4.22 第二遍，5.6 第三遍
- 思路：双指针，一个指向 nums1 末尾，一个指向 nums2 末尾。比较两个指针指向元素的大小，将较大者放到数组末尾，依次遍历整个数组。
- 注意：最后还需要用 arraycopy 将 nums2 数组复制到 nums1 数组中。因为当出现这种情况时：
  - `nums1 = [0], m = 0; nums2 = [1], n = 1`，因为我们的指针是指向末尾，即 `oneEnd = m - 1`，此时就不会进入到 `while(oneEnd >= 0 && twoEnd >= 0)` 的循环，导致最终报错。
- 复杂度：O（min（m，n）），空间复杂度：O（1）
```Java
        int oneEnd = m - 1, twoEnd = n - 1, len = m + n - 1;
        while (oneEnd >= 0 && twoEnd >= 0) {
            if (nums1[oneEnd] > nums2[twoEnd]) {
                nums1[len--] = nums1[oneEnd--];
            } else {
                nums1[len--] = nums2[twoEnd--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, twoEnd + 1);
```

#### 复习 [10.3. Leetcode 24：两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
4.16 第一遍，4.22 第二遍，5.6 第三遍
- 思路：1. 如果是空节点 or 单节点，直接返回 head；2. 设置 sentinel 节点指向初始的 head，方便最终结果返回；3. 设置 nextMove 节点，保证 nextMove.next 一直指向 head
- 注意：在循环的最后，要记得将 head 也指向tmp，亦即之前的 head.next.next，否则会出现以下情况
```Java
  Original:    1 -> 2 -> 3 -> 4
  First swap:  2 -> 1 -> 3 -> 4
  Second swap: 2 -> 3 -> 1 -> 4 (×)
               2 -> 1 -> 4 -> 3 (√)
 ```
- 复杂度分析：O（N），空间复杂度：O（1）

#### 复习 [10.4. Leetcode 25：K个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)
- 4.17 第一遍，5.6第二遍
- 思路：整个待翻转的链表分为三个部分：已经翻转的，正要翻转的，还未翻转的。因此我们要做的主要工作就是将其分隔开。所以我们需要五个指针：
  - 一个 sentinel，方便最终返回项；
  - 第二个是 subHead，正要翻转的链表的子头节点；
  - 第三个是 toNull，即正要翻转的链表的最后一个节点，在这里将其断开；
  - 第四个是 tmp，用来暂时保存还未翻转的链表；
  - 最后一个是 tail，用来指向已经翻转后的链表的尾部
- 注意：将子链表断开后，需要一个 reverseHelper 函数来将其翻转
- 注意：将子链表翻转后，会得到一个 newSubHead，这时候不能用 `sentinel.next = newSubHead` 来指向它，因为这会丢失掉前面已经翻转过的子链表，需要用 toNull 来指向它。
- 注意：将 tail 指向翻转后的子链表尾部的时候，要指向 subHead 而不是 head。因为 head 在整个过程中没有动，如果指向 head 就会丢失很多内容。
- 注意：寻找长度为 k 的子链表的过程中，要用 for 循环而不能用 while。因为 `while(toNull != null)` 的判定条件会使得最终结束循环的条件为 `toNull == null`，缺少了 `n < k` 这个条件的约束。造成空指针错误
- 注意：for 循环的时候，结束循环的条件应该是 `count < k - 1`，不是小于 k 的原因在于，toNull 指针设置的是指向 head，相当于 k 的长度小了 1. 
- 复杂度分析：O（N）
```Java
核心代码：
        while (subHead != null) {
            for (int count = 0; count < k - 1; count++) {
                toNull = toNull.next;
                if (toNull == null) return sentinel.next;
            }

            ListNode tmp = toNull.next;
            toNull.next = null;
            ListNode newSubHead = reverse(subHead);
            tail.next = newSubHead;
            tail = subHead;
            subHead = tmp;
            toNull = tmp;
            tail.next = tmp;

        }
        return sentinel.next;
```


<h3 id = "1.11">周四(5.7)</h3>

[返回目录](#0)

主题：复习、链表；技巧：迭代、指针、图像法；题数：复习 4 道，新题 1 道

#### [11.1. Leetcode 169：多数元素](https://leetcode-cn.com/problems/majority-element/)
5.7 第一遍
- 思路一：数学方法。因为多数元素表示的是在整个数组中占比超过 1/2，那么将数组排序后 n/2 位置的元素一定就是多数元素
- 复杂度分析：O（NlogN）
- 思路二：HashMap。将元素都放入 HashMap，并判断个数是否 >= n/2。如果是，则返回该元素
- 复杂度分析：O（N）
- 思路三：投票法。我们假设这样一个场景，在一个游戏中，分了若干个队伍，有一个队伍的人数超过了半数。所有人的战力都相同，不同队伍的两个人遇到就是同归于尽，同一个队伍的人遇到则战力值+1。


#### 复习 [11.2. Leetcode 92：反转链表II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)
4.20 第一遍，5.7 第二遍
- 思路：分析题目，因为整体分为三个部分：0 - (m - 1) 部分 和 n - end 部分不动，m - n 部分翻转。根据这个结构，我们解题分为三步走。
  - 第一步，遍历到 m - 1 的位置。因为题目给定了 m, n 都是小于链表长度，所以不用考虑超出的情况；
  - 第二步，将 m - n 的整个子链表进行翻转，与206题一致；
  - 第三步，将三个链表连接起来
```Java
m = 2, n = 5
Start:
     0    -->   1   -->   2   -->   3   -->   4    -->   5    -->   6    -->   7
     ^          ^
 sen|move      head


First Stage:

                        prev --> null
     0    -->   1   -->   2   -->   3   -->   4    -->   5    -->   6    -->   7
     ^          ^         ^                              ^
 sentinel    move/left   m/cur                           n


Second Stage:
            
                         null
                          |
     0    -->   1   -->   2   <--   3   <--   4    <--   5          6    -->   7
     ^          ^         ^                              ^          ^
 sentinel    move/left    m                             n/prev      cur
 
 
 Third Stage: left.next.next = cur （在这里 left.next 就是节点2）：
 
                          >----------------------------------------->
                          |                                         |
     0    -->   1   -->   2   <--   3   <--   4    <--   5          6    -->   7
     ^          ^         ^                              ^          ^
 sentinel    move/left    m                             n/prev      cur


 Last Stage: left.next = prev （在这里 left.next 是指针，指向 prev 节点）：

          move/left      >----------------------------------------->
                ⬇        ^                                         |
     0    -->   1        2   <--   3   <--   4    <--   5          6    -->   7
     ^          ⬇         ^                             ^          ^
 sentinel       |         m                            n/prev      cur
                |                                       ^     
                >---------------------------------------^

```
- 复杂度分析：O（N）

#### 复习 [11.3. Leetcode 19：删除链表倒数第 n 个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)
4.20 第一遍，5.7 第二遍
- 思路一：先翻转整个链表，然后从头节点（原来的尾节点）开始计数，删除 nth 节点，然后再翻转一次
- 复杂度分析：O(2L-1) = O(2N-1)=O(N), 空间复杂度 O（1）
- 思路二：双指针，一遍实现。 先让第一个指针走 n 步，这时候开始让第二个指针也开始走。保证两个指针距离为 n。则当第一个指针到达尾节点的时候，第二个指针刚好到达距离尾节点 n 的位置
- 复杂度分析：O（2L-n）= O(N)，空间复杂度：O（1）


#### 复习 [11.4. Leetcode 82：删除有序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)
4.20 第一遍，5.7 第二遍
- 思路：双指针。第一个指针指向没有重复的上一个节点，第二个指针用来移动判断，如果第二个指针的值和第三个（second.next）相等，则加一个while循环，一直到不相等的node。
- 注意：first 移动有两种情况：
  - 1、second 和 second.next 不相等，则 first 和 second 同时后移一位
  - 2、second 和 second.next 相等，first 指向 second.next.next
  - 基于以上判断，新建一个布尔变量 isEqual 来判断是二者中的哪个情况
- 注意：second 指针的移动要放在else之后，以保证无论如何，第二个指针都会移动，或者在 if 和 else 语句中都加入 second = second.next，以保证second指针的移动
- 注意：移动 second 判断是否有连续相等 node 的时候，要先判断 second.next 不为空，即：`while (second.next != null && second.val == second.next.val ) ` 
  - 举例来说，当提供数组是 [1,1] 的时候，如果 second 移动到了第二个 1，这时候如果先判断 `second.val == second.next.val`。因为 second.next 是 null，所以就不存在 value，就会出现空指针错误。而先判断 second.next 是否为空就可以避免这个情况
- 复杂度分析：O（N）

#### 复习 [11.5. Leetcode 86：分隔链表](https://leetcode-cn.com/problems/partition-list/submissions/)
4.20 第一遍，5.7 第二遍
- 思路：先找到第一个大于等于 x 的node，然后将 tail节点指向它，然后不停的往后循环，遇到val 小于 x 的node，就将其移动到 tail 之前
- 注意：一定要将 move 的初始位置设置在 sentinel。否则就会跳过对第一个元素的判断，从而造成错误。
- 复杂度： O（N），空间复杂度：O（1）
```Java
寻找大于等于 x 的代码：

        while (move != null && move.next != null) {
            if (move.next.val >= x) {
                subStart = move;
                move = move.next;
                break;
            } else {
                move = move.next;
            }
        }
        
可见每次判断的都是 move.next，如果不将 move 设置在 sentinel，就会跳过第一个元素没有判断。
```
        
        
<h3 id = "1.12">周五(5.8)</h3>

[返回目录](#0)

#### [12.1. Leetcode 116：填充每一个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)
5.8 第一遍
- 思路一：递归。递归非常简洁，是必须要会的一个技巧。简单来说，将 node 指向右侧节点有三种情况：
  - 第一，node 本身为空，那么返回 null 就好了
  - 第二，node 的左子节点不为空，那么直接 `node.left.next = node.right`，将左子节点指向右子节点
  - 第三，node 的右子节点不为空，那么就需要判断 node.next 是否为空，如果是，说明右边没有节点了，将 node.right = null 就行；如果不是，则将其指向 node.next 的左子节点。`node.right.next = node.next.left`
  - 复杂度分析：O（N）
- 思路二：迭代。题目要求空间复杂度为 O（1)。所以采用迭代来达到这个要求。
  - 在这里我们设置三个指针：第一个 level，指向每一层的最左边的节点；第二个 prev，指向要延伸出 next 指向右边的节点；第三个是 cur， 指向 prev 右边一个节点。所以 cur 可以为 null，代表的是 prev 已经到达了这一层的最右端。
  - 连接的关键在于通过 level 来控制在哪一层进行操作，通过 cur 来控制是否到达最右端、是否需要下移三个指针，通过 prev 来将 prev 的子节点连接起来：`prev.left.next = prev.right` 以及 `prev.right.next = cur.left`
- 思路三：BFS。其实观察题目的要求，就会发现这其实就是层序遍历的一个绝佳案例。虽然题目要求使用常数空间，但我们也可以用这道题来练习 BFS 的技巧。
```Java
递归法：
    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left != null) root.left.next = root.right;
        if (root.right != null) root.right.next = root.next == null? null : root.next.left;
        connect(root.left);
        connect(root.right);
        return root; 
    }
```


#### [12.2. Leetcode 117：填充每个节点的下一个右侧节点指针II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/)
5.8 第一遍
- 思路：和116题比较类似，但是区别在于这里不再是完美二叉树，而是一棵普通的二叉树，那么就可能存在空子节点，所以在连接next 的时候就需要增加一些判断。
  - 依旧使用递归，不过在这里，因为需要判断每一层的空子节点数，所以需要一个 hasNext 来遍历整层，相当于 BFS 的层序遍历。
  - 复杂度分析：O（N）
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
        connect(root.left);
        connect(root.right);
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

#### [12.3. Leetcode 46：全排列](https://leetcode-cn.com/problems/permutations/)
5.8 第一遍
- 思路：回溯法。对于回溯法的思路讲解，见[笔记2.7](#2.7)
- 注意：在往ans数组中添加值得时候，要注意不能写 `ans.add(track)`，因为添加的事实上是一组指向值的地址，所以会随着track 每次路径的不同而改变。而最终track 会回到起始点，也就是空集，这样就会造成最后的所有subset都是空集。
  - 解决方法：`ans.add(new LinkedList<Integer>(track))` 即可
- 复杂度：O（N）
代码如下：
```Java
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        helper(nums, track);
        return ans;
    }

    private void helper(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            ans.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;

            track.add(nums[i]);
            helper(nums, track);
            track.removeLast();
        }
    }
```


#### 复习 [12.4. 面试题 49：丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)
4.25 第一遍，4.27 第二遍，5.4 第三遍，5.8 第四遍
思路见[前节 1.7题](#1.1)



<h3 id = "1.13">周六(5.9)</h3>

[返回目录](#0)

主题：递归；技巧：回溯；题数：新题 5 道，复习 0 道

#### [13.1. Leetcode 47：全排列II](https://leetcode-cn.com/problems/permutations-ii/)
5.9 第一遍
- 思路：这道题与上一题很像，不同之处在于这里需要剪枝。在剪枝之前，需要先对数据进行排序。尽管排序也会花一定的时间，但是与回溯算法本身的复杂度相比还是低很多。同时要注意，这里给定的序列中就有重复元素，所以最终的排列结果，会出现[1,1,2] 和 [1,1,2]，需要去除其中的一个。
  - 1. 在主函数中，将 nums[] 排序
  - 2. 和 46 题相比，多用一个 used[] 的boolean 数组来记录某一个元素是否已经在前面出现过。具体方法为：在 `track.add(nums[i])` 之后，将 `used[i] = true`；同时，在回退状态之后，将 `used[i] = false`
  - 3. 核心的步骤，在于对重复元素的判断。在上一题中，我们使用的是 `if (track.contains(nums[i])) continue`，但是在这里行不通，原因是在给定的数组中就已经有了重复元素。这条语句的适用条件为 [1,2,3] 这样的数组，但是题目给出的是 [1,1,2] 等类似的数组。如果用这条语句来判断是否跳过，则会出现错误。
  - 4. 基于第三点，和之前设置的 used 数组，我们可以用这条语句来判定：`if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;`，它表示了两种情况：第一，used[i] 已经用过了，那么肯定要跳过；第二，used[i-1] 都没用过，但是nums[i] == nums[i-1]，这相当于在判断used[i] 之前，就已经判断了元素是否重复。因为我们事先排序了，所以这个判断才能实现。
    
#### [13.2. Leetcode 77：组合](https://leetcode-cn.com/problems/combinations/)    
5.9 第一遍
- 思路：回溯算法。和 46 题的思路非常相似，都是需要利用到回溯。
  - 1. track 要创建为 LinkedList<>() 对象，这样在回退状态的时候可以用 removeLast 方法，如果不创建为这个对象，需要改写成这样：`track.remove(track.size() - 1);`
  - 2. for 循环的判断，i <= n 而不仅仅是 <。因为 start 是从 1 开始取并且 n 是可以取得到的。


#### [13.3. Leetcode 78：子集](https://leetcode-cn.com/problems/subsets/)
5.9 第一遍
- 思路：回溯算法。套模板就可以了。
- 注意：模板中不再需要 if 来判断结束条件，因为这道题求子集，相当于决策树上的每一个节点的路径数组都要访问到。

#### [13.4. Leetcode 17：电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/comments/)
5.9 第一遍
- 思路：回溯算法。不过和之前不同之处在于，这里可选择的路径并非直接从节点到节点，而是需要先找到数字，每个数字提供三个可以选择的子节点，再在这三个子节点里面选择。对于这种情况，可以设置一个函数，输入数字，然后 return 对应的字符。
  - 在回溯的语句 `backtrack(digits, index + 1);` 中，是 index + 1 而不是 i + 1 的原因在于，i 只是在某一个数字的选择，数字和它所包含的三个字母实际上还是视为一个节点，但 backtrack 的东西应该是回到上一个节点，而这个节点就是由 index 来控制的，它代表的是第多少个数字。
- 注意：时刻都要注意一些边界情况，例如输入为空，则应该返回的也是空 List。

#### [13.5. Leetcode 51：N皇后](https://leetcode-cn.com/problems/n-queens/)
5.9 第一遍
- 思路：回溯。模板和 46 题很相似，不同的地方在于剪枝函数的设置。
- 注意：剪枝函数中，我们需要排除同一列是否有其他皇后、右上方、左上方是否有皇后。不用搜寻其他方向的原因在于，我们的放置 Q 是从左上角开始的，意味着 isValid 的搜寻也只需要扫描已经放置了 Q 的地方。
- 注意：在 isValid 函数中，只需进行列的搜索，因为主函数里面，row就已经是个变量，这里只要改变 col 就可以了


<h3 id = "1.14">周日(5.10)</h3>

[返回目录](#0)

#### [14.1. Leetcode 50：Pow(x,n)](https://leetcode-cn.com/problems/powx-n/)
5.10 第一遍
 - 思路：递归，快速幂。一开始的时候想着直接乘就完事了，但这样的话复杂度是 O（N），参考了解答，看到了一个很漂亮的递归代码。
   - 1. 列出三个 basic terminator，分别是 n = 0, 1, -1
   - 2. 根据快速幂的定义，当幂次为偶数的时候，将幂次 n 分解成 n/2 与 n/2；当幂次为奇数，则将其 -1 后再除 2
   - 3. 最后 `return rest * half * half` 即可
- 复杂度分析：O（logN）

```Java
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if ( n == -1) return 1/x;
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }
```


#### [14.2. Leetcode 236：二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/)/[面试题 68-II：二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)
5.10 第一遍
- 思路：递归。关键问题在于对参数 `left` 和 `right` 的理解，因为这是递归，所以在写递归语句的时候，可以认为左右子树都已经算出来了结果。
1. 如果当前节点 root 为 null，那么就直接返回 null；
2. 如果 root 等于 p 或者是 q，那么就返回 p or q；
3. 接着往下递归。如上所述，递归的时候可以直接认为我们已经求出来了 left 和 right，用它们来表示即可；
4. 对于返回值，有以下几种情况：
   - 第一，left 和 right 同时为空，说明左右子树都不包含p、q，返回null；
   - 第二，同时不为空，说明在root 的两侧，返回root；
   - 第三，left 为空，right不为空，说明p、q都在右边；
   - 第四，right 为空，left不为空，说明都在左边
-  复杂度分析：O（N）







<h2 id = "2">二、数据结构笔记</h3>



<h3 id = "2.1">1. 优先队列</h3>

[返回目录](#0)

在讨论优先队列之前，我们先谈一谈什么情况下会用到它，即我们为什么会需要它。考虑这样一个场景：我们需要处理有序的元素，但是又不要求所有的元素全部有序，或者不一定要一次性就全部排序，那么要怎么做？

很简单，我们可以收集一些元素，处理当前键值最大的元素。然后再收集更多的元素，再去处理当前键值最大的元素，如此这般。

在这种情况下，我们需要一个合适的数据结构来完成我们需要的功能，它应该具备这两个操作：**删除最大元素和插入元素**，这个数据结构就是**优先队列**。




参考文献：算法（第4版）

<h3 id = "2.2">2. 堆（二叉堆）</h3>

[返回目录](#0)




<h3 id = "2.3">3. 二叉搜索树</h3>

[返回目录](#0)



<h3 id = "2.4">4. 散列表（Hashing）</h3>

[返回目录](#0)



<h3 id = "2.5">5. 递归</h3>

[返回目录](#0)

维特根斯坦说，“语言的界限，就是世界的界限”。因此，对于一个名词的定义，就格外重要。那么什么是递归？

- WikiPedia: **Recursion** is the process of repeating items in a self-similar way. （递归是重复自相似步骤的过程）
- L.Peter Deutsc: To iterate is Human, to **Recursive**, devine. （循环是人性，递归是神性）
- 超哥：**递归**就是“过去来兮”
- 比喻：**递归**就是看 WikiPedia，你在第一个页面中看到不认识的名词，然后点击超链接取查看定义，然后看到了又一个新名词，于是继续查看。直到查找到最后一个名词，你明白了它的意思，于是逐步返回，最终的意思也明白了。

1. 递归思想的内涵

如上所述，递归思想的关键，就在于**递**与**归**，也可以理解为有去有回。**“有去”**指的是递归问题必须可以分解为若干个规模较小，与原问题形式相同的子问题，并且这些子问题可以用相同的解题思路来解决；**“有回”**指的是这些子问题并不能无限延伸下去，他们一定有一个 `Basic Terminator`，这个终点（临界点）会阻止程序的无限循环，并让程序从这里开始往回走，逐步地解决问题。如下所示：
```Java

     |      -----------       ^ 
     |     |  递归条件  |      | 
     |      -----------       | 
     |        ⬇    ⬆          | 
 有  |      -----------       |  有
     |     |  递归条件  |      |
     |      -----------       |
     |        ⬇    ⬆          |
 去  |      -----------       |  回
     |     |  递归条件  |      |
     |      -----------       |
     |        ⬇    ⬆          |
     |      -----------       |
     |     |  非递归条件  |    |
     |     |  开始返回    |    |
     |      -----------       |
     ⬇

```

2. 递归的三要素
   - 明确递归终止条件(Terminator)
   - 给出递归终止时的处理办法(Process)
   - 提取逻辑，通过递归语句来找到子问题(Drill Down)

3. 递归的模板

课堂上给出的模板如下。其中最后一个步骤restore status 看情况来判断是否需要，例如在递归的另一个类型回溯而言，就需要通过最后一个步骤来回退状态。
```Java
public void recursive(int level, in para) {
   
   // terminator
   if (level > MAX_LEVEL) {
      // process result
      return;
   }
   
   // process current logic
   process(level, para);
   
   // drill down
   recursive(level: level+1, newPara);
   
   // restore current status

}

```
更具体而言，递归有两种处理思路：一种实在递去的过程中解决问题，另一种是在归来的问题中解决问题。

情景一：在递去的过程中解决问题：
```Java
def recursion(大规模){
    if (end_condition){      // 明确的递归终止条件
        end;   // 简单情景
    }else{            // 在将问题转换为子问题的每一步，解决该步中剩余部分的问题
        solve;                // 递去
        recursion(小规模);     // 递到最深处后，不断地归来
    }
}
```

情景二：在归来的过程中解决问题
```Python

def recursion(大规模){
    if (end_condition){      // 明确的递归终止条件
        end;   // 简单情景
    }else{            // 先将问题全部描述展开，再由尽头“返回”依次解决每步中剩余部分的问题
        recursion(小规模);     // 递去
        solve;                // 归来
    }
}
```

4. 递归的场景
主要用于三类场景：
   1. 问题的定义是递归的。例如阶乘、斐波那契数列；
   2. 数据结构本身是递归的。例如链表和树的定义，就是典型的递归结构，所以会很适合用递归算法来解决问题；
   3. 问题的解法是递归的。例如汉诺塔问题。

5. 典型例题：
   - Leetcode 50: Pow(x,n)
   - Leetcode 22：括号生成
   - Leetcode 98：验证二叉搜索树
   - Leetcode 104、111：二叉树的最大、最小深度
   - Leetcode 226：翻转二叉树
   - Leetcode 105/106：从前序+中序/中序+后序遍历序列构造二叉树
   

<h3 id = "2.6">6. 回溯</h3>

[返回目录](#0)

回溯其实就是一种特殊的递归，不同的地方在于，**解决一个回溯问题，实际上就是解决一个决策树的遍历过程**。在这里，有三个概念需要厘清：
1. 路径：已经走过的路，已经做过的选择；
2. 选择列表：还可以走的路径，还可以去做的选择；
3. 结束条件：到达了决策树的底层，无法再去做选择的条件。
回溯算法的框架模板：
```Python
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
  
```
核心在于 `for` 循环里面的代码，事实上还可以将其扩展：
```Python
for 选择 in 选择列表:
    # 做选择
    将该选择从选择列表移除
    路径.add(选择)
    backtrack(路径, 选择列表)
    # 撤销选择
    路径.remove(选择)
    将该选择再加入选择列表
```
举例来说，如下的决策树：
```Java
             O
        /    |     \
      1/     |2     \3
     o       o       o  
   2/ \3   1/ \3   2/ \1 
   o   o   o   o   o   o
  3|  2|  3|  1|  1|  2|
   o   o   o   o   o   o     
```
每一个原点 o 都代表节点，站在这个节点上需要**做决策**，决定往哪一个路径去走。所以对于每一个节点而言，都具有两个属性：**选择列表**和**路径**。
- 例如对于最上层的节点，它的两个属性分别为：选择列表[1,2,3]，路径[]。分别代表从这个结点出发，它可以选择走三条路中的一条，但是因为事实上它还没有做出决策，所以记录的路径为空。
- 对于最右下角的节点，它的两个属性分别为：选择列表[]，路径[3,1,2]。分别代表从这个结点出发，往下做决策，已经无路可走，没有选择可以选了，所以它的选择列表为空。又因为它是从最顶层的节点一路沿着最右侧的路径走下来，所以它所记录的路径就应该是[3,1,2]。
- 当无路可走的时候，代表我们已经得到了一组解，将其加入到 ans 数组，然后回退到上一层节点，因为对于上一层节点而言，它不仅能往右走，还能往左走。退到上一层节点，即为删掉最后一个路径值，两个属性分别变成了：选择列表[2]，路径[3]。这时候只能往左走，最终得到的路径即为[3,2,1]。

理解了这些概念，那么回溯就很简单了。一言以蔽之：“**在递归之前做出选择，在递归之后撤销刚才的选择**”

参考资料：labuladong blog























