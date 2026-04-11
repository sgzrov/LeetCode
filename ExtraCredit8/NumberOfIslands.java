// LeetCode #200 - Number of Islands (Medium)
// https://leetcode.com/problems/number-of-islands/

/*
Overview: We treat the grid as a graph where each cell is a node connected to its 4 neighbors (up, down, left, right). We scan
each cell, and whenever we find land ("1"), we increment our island counter and sink the entire island by flipping all connected land
cells to "0". This ensures we never count the same island twice. The total count at the end is the answer.
 */

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    sinkIsland(grid, i, j);
                }
            }
        }

        return count;
    }

    private void sinkIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {  // Out of bounds or water — stop
            return;
        }

        grid[i][j] = '0';  // Mark as visited (sink the land)

        sinkIsland(grid, i + 1, j);  // Down
        sinkIsland(grid, i - 1, j);  // Up
        sinkIsland(grid, i, j + 1);  // Right
        sinkIsland(grid, i, j - 1);  // Left
    }
}