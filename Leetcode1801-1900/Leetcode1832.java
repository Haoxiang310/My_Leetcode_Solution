class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        for(int i=0;i<sentence.length();i++){
            char c = sentence.charAt(i);
            freq[c-'a']++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i] == 0) return false;
        }
        return true;
    }
}
