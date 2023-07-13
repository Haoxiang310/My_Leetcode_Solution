class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0, gasTank = 0, startIndex = 0;
        for(int i=0;i<gas.length;i++){
            balance += gas[i]-cost[i];
            gasTank += gas[i]-cost[i];
            if(gasTank<0){
                startIndex = i+1;
                gasTank=0;
            }
        }
        return balance<0?-1:startIndex;
    }
}
