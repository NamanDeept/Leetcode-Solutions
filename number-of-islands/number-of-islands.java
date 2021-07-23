class Solution {
    int []dir = new int[]{-1,0,1};
    public boolean isValid(int i, int j, char [][]grid) {
        //assume our grid contains atleast one row
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
    public void dfs(int i, int j, char [][]grid) {
       // This function marks the grid as 0 whenever it encounters 1 in the grid 
        if(!isValid(i, j, grid)) return;
        grid[i][j] = '0';
        for(int di : dir) {
            for(int dj : dir) {
                if(Math.abs(di) != Math.abs(dj)) {
                    if(isValid(i + di, j + dj, grid) && grid[i + di][j + dj] == '1') {
                        dfs(i + di, j + dj, grid);
                    }
                }
            }
        }
    } 
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0; // Base Condition for 0 row grid
        int n = grid[0].length;
        int count_islands = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j, grid);
                    count_islands++;
                }
            }
        }
        return count_islands;
    }
}