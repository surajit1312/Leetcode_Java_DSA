class Solution {
    /**
     * Using Multi-source BFS approach
     *
     * TC: O(M x N)
     * SC: O(M x N)
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {     // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (grid[i][j] == 1) {
                    // fresh oranges
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    // rotten oranges so add it in Queue for Multi-source BFS
                    queue.offer(new int[] { i, j });
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }
        int time = 0;
        // starting the multi-source BFS from multiple sources i.e. rotten oranges cells
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll(); // coordinates of rotten orange
                int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
                for (int[] direction : directions) {
                    int effRow = current[0] + direction[0];
                    int effCol = current[1] + direction[1];
                    if (effRow >= 0 && effRow < m &&
                        effCol >= 0 && effCol < n &&
                        grid[effRow][effCol] == 1) {
                        // it is going to be rotten
                        queue.offer(new int[] { effRow, effCol });
                        // marking the grid visited
                        grid[effRow][effCol] = 2;
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        // as in the last loop when q becomes empty 1 extra unit gets added
        return freshOranges == 0 ? time - 1 : -1;
    }
}
