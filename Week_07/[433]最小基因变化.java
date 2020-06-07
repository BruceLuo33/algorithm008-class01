//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.13 第一遍，5.21 第二遍，6.4 第三遍
 - 思路：这道题的思路其实和 127 题单词接龙非常一致。这道题要求的是从 start 到 end 经过了几次变化。那么就可以理解为假设每一步仅变化一个基因，变化到目标基因需要几步。整个代码在 127 的思路上稍微改改就行了。
 - 注意：bank 是 String 数组，不好判断是否包含某一个字符串，因此将其转为 set 然后再用 contains() 方法
 - 注意：最终返回 count 而不是 count + 1。
 */

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> allGene = new HashSet<>(Arrays.asList(bank));
        if (!allGene.contains(end) || bank.length == 0) return -1;
        int count = 0;
        allGene.add(start);
        Queue<String> queueOne = new LinkedList<>();
        Queue<String> queueTwo = new LinkedList<>();
        Set<String> visitedOne = new HashSet<>();
        Set<String> visitedTwo = new HashSet<>();
        queueOne.offer(start);
        queueTwo.offer(end);
        visitedOne.add(start);
        visitedTwo.add(end);
        char[] geneType = new char[]{'A', 'C', 'G', 'T'};
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
                String cur = queueOne.poll();
                char[] old = cur.toCharArray();
                for (int i = 0; i < old.length; i++) {
                    char save = old[i];
                    for (char c : geneType) {
                        old[i] = c;
                        String newString = new String(old);
                        if (visitedOne.contains(newString)) continue;
                        if (visitedTwo.contains(newString)) return count;
                        if (allGene.contains(newString)) {
                            queueOne.offer(newString);
                            visitedOne.add(newString);
                        }
                    }
                    old[i] = save;
                }
            }
        }
        return -1;
    }



class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end) || bank.length == 0) return -1;
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[bank.length];
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += 1;
            while (size > 0) {
                String tmp = queue.poll();
                size -= 1;
                for (int i = 0; i < bank.length; i++) {
                    if (isVisited[i]) continue;
                    if (!canChange(tmp, bank[i])) continue;
                    if (bank[i].equals(end)) {
                        return count;
                    }
                    isVisited[i] = true;
                    queue.offer(bank[i]);
                }
            }
        }
        return -1;
    }

    private boolean canChange(String one, String two) {
        int count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                count += 1;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
