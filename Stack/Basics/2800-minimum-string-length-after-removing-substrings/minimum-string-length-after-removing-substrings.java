class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int minLength(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            char current = s.charAt(i);
            if (current == 'A' && !st.isEmpty() && st.peek() == 'B') {
                st.pop();
            } else if (current == 'C' && !st.isEmpty() && st.peek() == 'D') {
                st.pop();
            } else {
                st.push(current);
            }
        }
        return st.size();
    }
}
