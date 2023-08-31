//bidirectional bfs solution
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visitedForward = new HashSet<>();
        Set<String> visitedBackward = new HashSet<>();
        Set<String> deadend = new HashSet<>();
        Set<String> forwardExpand = new HashSet<>(List.of("0000"));
        Set<String> backwardExpand = new HashSet<>(List.of(target));
        for(String s:deadends) deadend.add(s);
        visitedForward.add("0000");
        visitedBackward.add(target);
        int steps = 0;
        // if(deadend.contains("0000")) return -1;
        while(!forwardExpand.isEmpty() && !backwardExpand.isEmpty()){
            Set<String> temp = new HashSet<>();
            Set<String> tempVisited = new HashSet<>();
            if(target.equals("0000")) return 0;
            for(String f: forwardExpand){
                if(deadend.contains(f)) continue;
                for(int i=0;i<4;i++){
                    String upNext = wheelUp(i,f);
                    String downNext = wheelDown(i,f);
                    if(!visitedForward.contains(upNext) && !deadend.contains(upNext)){
                        visitedForward.add(upNext);
                        temp.add(upNext);
                    }
                    if(!visitedForward.contains(downNext) && !deadend.contains(downNext)){
                        visitedForward.add(downNext);
                        temp.add(downNext);
                    }
                    if(backwardExpand.contains(upNext) || backwardExpand.contains(downNext)) return steps + 1;
                }
            }
            if(forwardExpand.size() > backwardExpand.size()){
                forwardExpand = backwardExpand;
                backwardExpand = temp;
                tempVisited = visitedForward;
                visitedForward = visitedBackward;
                visitedBackward = tempVisited;
            }
            else{
                forwardExpand = temp;
            }
            steps++;
        }
        return -1;
    }

    public String wheelUp(int digit, String curr){
        StringBuilder sb = new StringBuilder(curr);
        char c = sb.charAt(digit);
        char next = (char)(c + 1);
        if(sb.charAt(digit) != '9') sb.setCharAt(digit, next);
        else sb.setCharAt(digit, '0');
        return sb.toString();
    }

    public String wheelDown(int digit, String curr){
        StringBuilder sb = new StringBuilder(curr);
        char c = sb.charAt(digit);
        char next = (char)(c - 1);
        if(sb.charAt(digit) != '0') sb.setCharAt(digit, next);
        else sb.setCharAt(digit, '9');
        return sb.toString();
    }
}
