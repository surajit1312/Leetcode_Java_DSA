class Solution {
    /**
     * TC: O(K x N), where K = length of String 'pref'
     * SC: O(1)
     */
    public int prefixCount(String[] words, String pref) {
        int n = pref.length();
        int count = 0;
        for (String word : words) {                  // TC: O(N)
            if (word.length() >= n && 
                word.startsWith(pref)) { // TC: O(K)
                count++;
            }
        }
        return count;
    }
}
