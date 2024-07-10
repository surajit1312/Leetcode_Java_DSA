class Solution {
    /**
     * Using iteration only - without using Stacks
     */
    public int minOperations(String[] logs) {
        int steps = 0;
        for (String s : logs) {
            if (s.equals("../")) {
                steps = steps > 0 ? steps - 1 : 0;
            } else if (s.equals("./")) {
                continue;
            } else {
                steps++;
            }
        }
        return steps;
    }

    /**
     * Using Stacks
     */
    // public int minOperations(String[] logs) {
    //     Stack<String> st = new Stack<String>();
    //     for (String s : logs) {
    //         if (s.equals("../")) {
    //             if (st.isEmpty()) {
    //                 continue;
    //             } else {
    //                 st.pop();
    //             }
    //         } else if (s.equals("./")) {
    //             continue;
    //         } else {
    //             st.push("folder");
    //         }
    //     }
    //     int steps = 0;
    //     while (!st.isEmpty()) {
    //         st.pop();
    //         steps++;
    //     }
    //     return steps;
    // }
}
