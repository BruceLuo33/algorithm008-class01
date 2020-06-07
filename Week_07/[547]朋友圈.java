//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.2 第一遍，6.4 第二遍
 - 思路一：dfs。类似于岛屿数量题的思路
 1. 因为有 n 名学生，所以 isVisted 数组就可以设置为 n 的大小，它代表的是某一个人是否属于某一个朋友圈；
 2. 具体而言，我们从第一个人出发，通过 dfs helper 函数，找到所有与他相连接的人，直到找不到为止，然后 count++；
 3. 找所有相连的人的方式，类似于不仅仅有很多个岛屿，而且每个岛屿下面还有隧道相连，所以一旦遇到值为 1 且之前没有访问过的人，那么我们立即跳到它那里，以它为起点再次出发去寻找，实现方式就是对 dfs 的再调用
 复杂度分析：O(N^2)
 - 思路二：Union-Find 算法。算法4 第一章1.5节出现过的算法，也是 cs61b 中 lab 题要实现的算法之一。
 1. 创建 class UF，API 为：UF，union，find，count
 2. 核心在于 union 和 find。先说简单的 find，其目的就是不停的找 `if (x == parent[x])`，如果否，则将 x = parent[x]`，不断上移，直到找到最终的 root；
 3. 然后是 union，如果简单的讲 A 加到 B 上，就有可能造成性能不佳，原本是树状结构，变成了链表数组的形式，因此需要先判定两个 root 所在的树，谁的 size 更大，将小的树加到大树上，同时记得要更新 size，count 和 parent。
 复杂度分析：O（N^2）
 */

class Solution {
    // Solution Two: Weighted Union-Find
    public int findCircleNum(int[][] M) {
        if(M == null) return 0;
        int n = M.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    class UF {
        private int count;
        private int[] size;
        private int[] parent;

        public UF(int n) {
            parent = new int[n];
            this.count = n;
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int one, int two) {
            int rootOne = find(one);
            int rootTwo = find(two);
            if (rootOne == rootTwo) {
                return;
            }
            // return;
            if (size[rootOne] > size[rootTwo]) {
                parent[rootTwo] = rootOne;
                size[rootOne] += size[rootTwo];
            } else {
                parent[rootOne] = rootTwo;
                size[rootTwo] += size[rootOne];
            }
            count--;
        }

        public int find(int one) {
            while (parent[one] != one) {
                parent[one] = parent[parent[one]];
                one = parent[one];
            }
            return one;
        }

        public boolean isConnected(int one, int two) {
            int rootOne = find(one);
            int rootTwo = find(two);
            return rootOne == rootTwo;
        }

        public int count() {
            return count;
        }



    }



    // Solution One: DFS
    // public int findCircleNum(int[][] M) {
    //     if (M == null) return 0;
    //     int n = M.length;
    //     int count = 0;
    //     boolean[] isVisited = new boolean[n];
    //     for (int i = 0; i < n; i++) {
    //         if (!isVisited[i]) {
    //             dfs(M, isVisited, i);
    //             count += 1;
    //         }
    //     }
    //     return count;
    // }
    // private void dfs(int[][] M, boolean[] isVisited, int row) {
    //     for (int j = 0; j < M[0].length; j++) {
    //         if (M[row][j] == 1 && !isVisited[j]) {
    //             isVisited[j] = true;
    //             dfs(M, isVisited, j);
    //         }
    //     }

    // }
}
//leetcode submit region end(Prohibit modification and deletion)
