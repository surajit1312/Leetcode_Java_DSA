class Solution {

    private static final Map<Integer, String> below10 = 
        Map.of(0, "", 1, "One", 2, "Two", 3, "Three", 4, "Four", 5, "Five", 6, "Six", 7, "Seven", 8, "Eight", 9, "Nine");
    
    private static final Map<Integer, String> below20 = 
        Map.of(10, "Ten", 11, "Eleven", 12, "Twelve", 13, "Thirteen", 14, "Fourteen", 15, "Fifteen", 16, "Sixteen", 17, "Seventeen", 18, "Eighteen", 19, "Nineteen");
    
    private static final Map<Integer, String> below100 = 
        Map.of(2, "Twenty", 3, "Thirty", 4, "Forty", 5, "Fifty", 6, "Sixty", 7, "Seventy", 8, "Eighty", 9, "Ninety");
        
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        } else {
            return solve(num);
        }
    }

    private String solve(int num) {
        if (num < 10) {
            return below10.get(num);
        } else if (num < 20) {
            return below20.get(num);
        } else if (num < 100) {
            return below100.get(num / 10) + (num % 10 != 0 ? " " + solve(num % 10) : "");
        } else if (num < 1000) {
            return solve(num / 100) + " Hundred" + (num % 100 != 0 ? " " + solve(num % 100) : "");
        } else if (num < 1000000) {
            return solve(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + solve(num % 1000) : "");
        } else if (num < 1000000000) {
            return solve(num / 1000000) + 
                " Million" + (num % 1000000 != 0 ? " " + solve(num % 1000000) : "");
        } else {
            return solve(num / 1000000000) + 
                " Billion" + (num % 1000000000 != 0 ? " " + solve(num % 1000000000) : "");
        }
    }
}
