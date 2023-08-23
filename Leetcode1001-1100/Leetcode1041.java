class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;
        int[] pos = new int[]{0,0};
        for(int i=0;i<instructions.length();i++){
            char c = instructions.charAt(i);
            if(c == 'G'){
                pos[0] += dir[index][0];
                pos[1] += dir[index][1];
            }
            else if(c == 'L'){
                index = (index + 3)%4;
            }
            else if(c == 'R') index = (index + 1)%4;
        }
        return pos[0] == 0 && pos[1] == 0 || (index != 0);
    }
}
