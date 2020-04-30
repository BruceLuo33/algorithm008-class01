
# 第三周学习记录
* [一、刷题记录](#1)
  * [周一](#1.1)
  * [周二](#1.2)
  * [周三](#1.3)
  * [周四](#1.4)
  * [周五](#1.5)
  * [周六](#1.6)
  * [周日](#1.7)
* [二、数据结构笔记](#2)
  * [1. 优先队列（堆）](#2.1)
  * [2. 二叉查找树](#2.2)
  * [3. 平衡查找树（红黑树）](#2.3)
  * [4. 散列表（Hashing）](#2.4)
  * [5. 递归](#2.5)
  * [](#2.2)
  * [](#2.2)


<h2 id = "1">一、刷题记录</h2>

| 题目类型 | 知识点 | 题目 | 完成情况 | 地址 |
| --- | --- | --- | --- | --- |
| 实战 | 递归、字符串 | Leetcode 22： 括号生成 |  :v:  | [周四](#1.4) |
| 实战 | 二叉树、递归 | Leetcode 98：验证二叉搜索树 |  :v:  | [周一](#1.1) |
| 实战 | 二叉树、递归 | Leetcode 104：二叉树最大深度|  :v:  | [周四](#1.4)|
| 实战 | 二叉树、递归 | Leetcode 111：二叉树最小深度|  :v:  | [周四](#1.4)|
| 实战 | 二叉树、递归 | Leetcode 226：翻转二叉树|  :v:  | [周一](#1.1)|
| 实战 | 二叉树、递归 | Leetcode 297：二叉树的序列化与反序列化|  :v:  | [周四](#1.4)|


<h3 id = "1.1">周一</h3>
主题：二叉树；技巧：递归、中序遍历；题数：新题5道，复习2道

#### [Leetcode 98：验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)。
4.27 第一遍
- 思路一：中序遍历。题目的要求是判断二叉树值得大小是否为从小到大排列。因此用中序遍历得 左-->根-->右，就可以比较好的解决这个问题。只要相邻两个元素不满足前项小于后项的关系，就返回false。
  - 注意：在存储树的 val 时，数据结构可以用 stack 或者是 arraylist。
  - 注意：判断左子节点的 value（已经存入 ans）与 root.val 关系的时候，要判断是否 >=，而不仅仅是 >
  - 复杂度分析：O（N），空间复杂度：O（N）

- 思路二：递归。对于每一个节点，正确的范围应该是小于右子树中的最小值 + 大于左子树中的最大值。
因此，我们可以设置递归，每次都已上一个节点作为左/右的一个边界，如果越界，代表出错。如下图所示。
  - 从下图，我们可以总结出结论：如果是左子节点，那么应该以父节点为右边界，以父节点的左边界为左边界；如果是右子节点，应该以父节点为左边界，以父节点的右边界为右边界。
  - 注意：设置max/min 的时候，要将其再扩大一个位置，MAX_VALUE + 1 和 MIN+VALUE - 1
  - 复杂度分析：O（N），空间复杂度：O（1）
    ```Java
                  10 (-inf, inf)
                   /          \
           5(-inf, 10)      17(10, inf)
            /     \          /       \
      3(-inf, 5)  7(5,10)  13(10, 17)   20(17, inf)
    ```
#### [Leetcode 99：恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/)
4.27 第一遍
- 思路：采用中序遍历。从 98 题中我们知道，对一个二叉树进行中序遍历，得到的数组将会从小到大排列。因为题中已经说明，仅有两个节点被错误的交换，因此我们可以使用双指针来遍历。对于两个节点被交换，会产生以下几种情况：
  - case 1：[1,2,3,4,5] 中，1和2被交换，因此会产生一个错误数值对。交换后是[2,1,3,4,5]，{2，1}是错误数值对
  - case 2：[1,2,3,4,5] 中，2和5被交换，此时会产生两个错误数值对。[1,5,3,4,2]中，{5，3}与{4，2}都是。
- 所以我们可以将前后节点互相比较，如果前节点大于后节点，就违反了二叉树的定义，也就是我们要找的一种情况，用first 和 second 来分别保存；然后继续递归，找到第二组逆序的数字，则将second 赋值为第二组逆序中的后一个数字（case two 的2），然后交换first 和 second 即可。
- 注意：判断前后结点的值的时候，应该是 pre.val > root.val，即前节点的值大于现节点的值。
- 注意：赋值的时候，first 应该指向 pre，second 应该指向 root。对应着上面的case 2，将第一个逆序对的第一个元素和第二个逆序对的第二个元素，交换。
- 复杂度分析：O（N）

#### [Leetcode 100：相同的树](https://leetcode-cn.com/problems/same-tree/)
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

#### [Leetcode 101：对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)
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

#### [Leetcode 226：翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)
4.27 第一遍
- 思路：结构和101题，相同的树非常相似。递归的过程也是比较相似，不同之处就在于不是判断左右节点是否相等了，而是直接交换最左和最右节点的值就可以了。
- 注意：一开始想的是交换 val，后面发现直接交换node，会让整个结构更简单。


#### 复习[Leetcode 1：两数之和](https://leetcode-cn.com/problems/two-sum/)
4.25 第二遍，4.27第三遍
- 思路一：很早之前做过这道题。直接用的两遍循环。暴力破解，复杂度O（N^2)
- 思路二：降低复杂度，使用 HashMap。
- 步骤：1、将nums 放入 HashMap；2、对于每一个元素 i，找出 target - i 是否在 map中；3、如果在，返回下标；如果不在，返回空数组。
- 注意：判断map 是否有key 的时候，因为题目要求同一个元素不能使用两次，所以还需要判定 map.get(target - nums[i]) != i。

#### 复习[Leetcode 264：丑数II](https://leetcode-cn.com/problems/ugly-number-ii/) / [面试题 17.09：第 K 个数](https://leetcode-cn.com/problems/get-kth-magic-number-lcci/)
4.25 第一遍，4.27第二遍。一开始还有点没想出来。后面看了之前写的代码，立刻就回忆起来了。复习还是很有必要的。具体思路如下。
- 思路：先分析每一个丑数，设丑数为 y，则其符合这个公式 y = a·2 + b·3 + c·5. 自然而然，一开始会想到，是不是需要将 a/b/c 都求出来，但这样是陷入了误区，且看下面三个数组：
```Java
Array 1: 1x2, 2x2, 3x2, 4x2, 5x2……
Array 2: 1x3, 2x3, 3x3, 4x3, 5x3……
Array 3: 1x5, 2x5, 3x5, 4x5, 5x5 ……
```
- 从上面的数组，我们可以很明显的看到，假设数组长度无限，那么每一个数组其实都全部包含了余下的两个数组。所以可以设置三个指针，分别乘以对应的系数，然后将较小的数放入丑数数组中，并将其指针后移一位。依此类推，直到第 k 个数。举例来说：
```Java
Step 1:
Array 1: 1x2, 2x2, 3x2, 4x2, 5x2……
          ^
Array 2: 1x3, 2x3, 3x3, 4x3, 5x3……
          ^
Array 3: 1x5, 2x5, 3x5, 4x5, 5x5 ……
          ^
UglyNumber[0] = 1, UglyNumber[1] = min{1x2, 1x3, 1x5} = 2，再将 Array 1 的指针右加一位

Step 2:
Array 1: 1x2, 2x2, 3x2, 4x2, 5x2……
               ^
Array 2: 1x3, 2x3, 3x3, 4x3, 5x3……
          ^
Array 3: 1x5, 2x5, 3x5, 4x5, 5x5 ……
          ^

UglyNumber[0] = 1, UglyNumber[1] = 2，UglyNumber[2] = min{2x2, 1x3, 1x5} = 3. 
此时 Array 2 出现了最小值，因此将其放入丑数数组后，指针右移一位即可。

```





<h3 id = "1.2">周二</h3>
主题：二叉树宽度优先搜索（BST）；技巧：宽度优先、队列；题数：新题2道

#### [Leetcode 102: 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
4.28 第一遍
- 思路：使用 BFS 对树进行层间遍历。每次都用一个队列来接受root，然后将其放入答案链表即可。
- 复杂度分析：O（N） 空间复杂度：O（N）

#### [Leetcode 103: 二叉树的锯齿状层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
4.28 第一遍
- 思路：这道题和102题几乎一样，唯一的不同之处在于如果 level 为奇，就是从左往右，如果是偶数，就是从右往左。因此对 curLevel 增加一个奇偶判断就可以了
- 复杂度分析：O（N），空间复杂度：O（N）



<h3 id = "1.3">周三</h3>
主题：二叉树；技巧：递归、深度优先搜索(DFS)，广度优先搜索（BFS)，字符串处理；题数：新题5道，复习2道

#### [Leetcode 105: 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
4.29 第一遍
- 思路：回顾一下，前序遍历指的是 root --> left --> right，中序遍历指的是 left --> root --> right。根据两个遍历的特征，我们可以知道，前序遍历数组的第一个元素，即为根节点，再由这个根节点与中序遍历匹配，找到中序遍历中的根节点，则其左边就是左子树，右边就是右子树。然后再次回到前序遍历数组剩下的部分，第一个元素为右子树的根节点，以此类推。
- 由上述分析可以看出，递归非常适合这道题目。
  - 注意：找 root 节点的时候，下标应该为 p_start 而不是 0
  - 注意：helper 函数 return null 的条件应该是 preorder 数组的 start == end
  - 注意：helper 函数的输入参数中，p_end 和 i_end 都不用 -1
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

#### [Leetcode 106: 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
4.29 第一遍
- 思路：这道题和 105 题基本思路一样。不同之处在于将前序遍历换成了后序遍历。所以在找 root 的时候换一下位置，其他不变就可以了

#### [Leetcode 107: 二叉树的层序遍历II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
4.29 第一遍
- 思路：这道题和102基本一样，同样用到 BFS 来解题
- 稍微不同的地方在于，102 是从根节点往下遍历，但是这里是从叶子节点往上遍历。所以只需要将一个地方更改，即将每一层的元素插入到 ans 数组的第一个位置，就可以了，见下：

```Java
codes in 102: 
ans.get(curLevel).add(node.val);

codes in 107
ans.get(0).add(node.val);
```

#### [面试题05：替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)
4.29 第一遍
- 思路：一开始想这道题似乎很简单，后面才发现难点在于在 JAVA 中，String 被设置为不可改变的类型，所以需要额外设置一个字符串来进行操作。
- 复杂度分析：O（N），空间复杂度：O（N）

#### [面试题06：从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
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


#### 复习 [Leetcode 102: 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
4.28 第一遍，4.29 第二遍

#### 复习 [Leetcode 103: 二叉树的锯齿状层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
4.28 第一遍，4.29 第二遍




<h3 id = "1.4">周四</h3>
主题：二叉树；技巧：递归、深度优先搜索(DFS)，广度优先搜索（BFS)，字符串处理；题数：新题 道，复习 道

#### [Leetcode 22: 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
4.30 第一遍
- 思路：这道题是超哥在视频中详细讲解的。对我的启发有两点：自顶向下编程与结构化思维。
- 结构化思维：递归都是四个步骤：terminator, process logic, drill down, restore status
- 对于题目的要求，要作以下几个考虑：第一、left < n；第二、right < left，以这两个为判断递归的标准即可
- 注意：递归函数不能用 List<String>，要传入 String s，然后将 s 加到全局变量 List<String> 中



#### [Leetcode 297: 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
4.30 第一遍
- 思路一：一开始看这个题目，感觉这不就是 94 和 105 的综合吗？先将一个二叉树前序/中序遍历完成 serialize，然后用它的前序和中序遍历来重建二叉树。这个思路没有太大问题，但是忽略了一个很重要的点，那就是给定序列的元素是可能重复的！
  -例如 [3, 2, 4, 3]，这里有了重复的元素，那么用 105 的方法来重建的时候，就会出现在 inorder 数组中找不到 root 位置的情况
- 思路二：既然 DFS works bad，那么就用 BFS。按照 102 题的方式来层序遍历，要注意的点是遇到 null 就记录 null。在还原的函数中，输入的是 String，所以首先我们要将其转换为 String 数组，然后再将其转换为 Integer，同时 null 也要判断与记录
- 注意：在 serialize 函数中，因为返回的值是 String 而非 List<List<String>>，所以不再需要用 level 来控制 return 的维度
- 注意：在 serialize 函数中，因为 node.val 是 Integer，所以用一个整型 List 去接收答案会比较好
- 注意：在 deserialize 函数中，有一个小 bug 找了很久才找出来，那就是要记得在 String 数组转换为 Integer 数组的时候，使用 trim() 将空格切掉。
- **总结**：这道题的难点，不在于 serialize，而是如何重建二叉树。因为之前在 105 题中的经验不管用，所以需要用其他的方法来做。在这里我们使用了队列来保存即将访问的 root.left 和 root.right，并且根据二叉树的特征，即只有左子树和右子树，使用了两个 if 来往最终的二叉树中添加 node。并在每一个 node 之后将位置指针 curPos + 1
 - 复杂度分析：O（N）


#### 


#### 复习 [Leetcode 104：二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
4.24 第一遍，4.30 第二遍
- 思路：递归。从 root 出发，最大的深度等于 1+ 左/右 的node 最大深度。
- 复杂度分析：O（N），空间复杂度：O（1）



#### 复习 [Leetcode 111：二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
4.24 第一遍，4.30 第二遍
- 思路：一开始的时候，想着和 104 题很相似，那是不是直接将 return 的项由 Math.max 转换成 Math.min 就可以呢？明显不是。因为如果某一个子节点为 null，则这个方法就会选择这个子节点。但事实上这样算出来对于 spindly 的case，也就是 worst case，会出现明显的误判。
- 因此需要加两行判断，即如果左子节点为 null，就 return minDepth(root.left) + 1，如果右子节点为 null，则返回左子节点。
- 注意：判断左右子节点为null，return 的项要 +1. 这表示循环往下走了一层。否则循环往下走，但是 height 没有记录，就会出错。
- 复杂度分析：O(N)






<h3 id = "1.5">周五</h3>



<h3 id = "1.6">周六</h3>


<h3 id = "1.7">周日</h3>

<h2 id = "2">二、数据结构笔记</h3>



<h3 id = "2.1">1. 优先队列（堆）</h3>


<h3 id = "2.2">2. 二叉查找树</h3>



<h3 id = "2.3">3. 平衡查找树（红黑树）</h3>


<h3 id = "2.4">4. 散列表（Hashing）</h3>


<h3 id = "2.5">5. 递归</h3>



































