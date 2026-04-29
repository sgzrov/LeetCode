// LeetCode #75 - Sort Colors (Medium)
// https://leetcode.com/problems/sort-colors/

/*
Overview: We're given an array of only 0s, 1s, and 2s and need to sort it in-place in one pass. We use an algorithm wjhere low marks where 0s end,
high marks where 2s begin, and mid scans through. If nums[mid] is 0, swap with low and advance both
(the swapped-in value came from the already-scanned middle, so it's a 1). If nums[mid] is 2, swap with high and decrease high, but don't
advance mid since the swapped-in value is unexamined. If nums[mid] is 1, just advance mid. Stop when mid passes high.
Each element is examined at most once.
 */

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;  // Everything before low is 0
        int mid = 0;   // Current scanner position
        int high = nums.length - 1;  // Everything after high is 2

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);  // Send 0 to the left section
                low++;
                mid++;  // Advance (already processed)
            } else if (nums[mid] == 2) {
                swap(nums, mid, high); // Send 2 to the right secointn
                high--;
            } else {
                mid++;  // 1 is already in the correct middle section
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}