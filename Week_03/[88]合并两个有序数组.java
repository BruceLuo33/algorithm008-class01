//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 4.15 第一遍，4.22 第二遍，5.6 第三遍
        // 思路：双指针，一个指向 nums1 末尾，一个指向 nums2 末尾。
        // 比较两个指针指向元素的大小，将较大者放到数组末尾，依次遍历整个数组。
        // 注意：最后还需要用 arraycopy 将 nums2 数组复制到 nums1 数组中。因为当出现这种情况时：`nums1 = [0], m = 0; nums2 = [1], n = 1`，因为我们的指针是指向末尾，即 `oneEnd = m - 1`，此时就不会进入到 `while(oneEnd >= 0 && twoEnd >= 0)` 的循环，导致最终报错。
        // 复杂度：O（min（m，n）），空间复杂度：O（1）




        int oneEnd = m - 1, twoEnd = n - 1, len = m + n - 1;
        while (oneEnd >= 0 && twoEnd >= 0) {
            if (nums1[oneEnd] > nums2[twoEnd]) {
                nums1[len--] = nums1[oneEnd--];
                // oneEnd -= 1;
                // len -= 1;
            } else {
                nums1[len--] = nums2[twoEnd--];
                // len -= 1;
                // twoEnd -= 1;
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, twoEnd + 1);





        // // 4.22 codes
        // int oneEnd = m - 1, twoEnd = n - 1, endLoc = m + n - 1;
        // while (oneEnd >= 0 && twoEnd >= 0) {
        //     if (nums1[oneEnd] > nums2[twoEnd]) {
        //         nums1[endLoc] = nums1[oneEnd];
        //         oneEnd -= 1;
        //         endLoc -= 1;
        //     } else {
        //         nums1[endLoc] = nums2[twoEnd];
        //         twoEnd -= 1;
        //         endLoc -= 1;
        //     }
        // }
        // System.arraycopy(nums2, 0, nums1, 0, twoEnd + 1);


        // //4.15 codes:
        // int endOne = m - 1, endTwo = n - 1;
        // int len = m + n -1;
        // while (endOne >=0  && endTwo >= 0) {
        //     if (nums1[endOne] > nums2[endTwo]) {
        //         nums1[len] = nums1[endOne];
        //         len -= 1;
        //         endOne -= 1;
        //     } else {
        //         nums1[len] = nums2[endTwo];
        //         len -= 1;
        //         endTwo -= 1;
        //     }
        // }
        // System.arraycopy(nums2, 0, nums1, 0, endTwo + 1);
        // return;
}
//leetcode submit region end(Prohibit modification and deletion)
