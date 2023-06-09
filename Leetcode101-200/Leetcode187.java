class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] nums = new int[s.length()];
        for(int i=0;i<nums.length;i++){
            switch(s.charAt(i)){
                case 'A':{
                    nums[i]=0;
                    break;
                }
                case 'G':{
                    nums[i]=1;
                    break;
                }
                case 'C':{
                    nums[i]=2;
                    break;
                }
                case 'T':{
                    nums[i]=3;
                    break;
                }
            }
        }
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        int left = 0, right = 0;
        int windowHash = 0;
        int n = nums.length;
        int L = 10;
        int R = 4;
        int RL = (int)Math.pow(R,L-1);
        while(right<n){
            windowHash = windowHash*R+nums[right];
            right++;

            if(right-left==L){

                if(seen.contains(windowHash)){
                    res.add(s.substring(left,right));
                }
                else{
                    seen.add(windowHash);
                }
                windowHash = windowHash - nums[left] * RL;
                left++;
            }
        }
        return new ArrayList<>(res);

    }
}
