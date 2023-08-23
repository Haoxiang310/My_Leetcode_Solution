class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx < tx && sy < ty){
            if(tx < ty){
                ty %= tx;
            }
            else tx %= ty;
        }
        if(sx == tx && sy < ty)  return (ty-sy) % tx == 0;
        if(sx < tx && sy == ty)  return (tx-sx) % ty == 0;
        return sx == tx && sy == ty;
    }
}
