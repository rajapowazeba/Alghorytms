class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] maxLengths = new int[26];
        int currentLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25)) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            int index = s.charAt(i) - 'a';
            if (currentLength > maxLengths[index]) {
                maxLengths[index] = currentLength;
            }
        }
        
        int total = 0;
        for (int length : maxLengths) {
            total += length;
        }
        return total;
    }
}
