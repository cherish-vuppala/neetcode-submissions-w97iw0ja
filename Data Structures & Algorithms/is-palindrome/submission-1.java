class Solution {
    public boolean isPalindrome(String s) {

        int i = 0, j = s.length()-1;

        while (i < j) {

            while (i < s.length() && !isAlphanumeric(s.charAt(i)))
                i++;
            
            while (j >= 0 && !isAlphanumeric(s.charAt(j)))
                j--;
            
            char c1 = i < s.length() ? Character.toLowerCase(s.charAt(i++)) : '0';
            char c2 = j >= 0 ? Character.toLowerCase(s.charAt(j--)) : '0';

            if (c1 != c2) return false;
        }

        return true;
        
    }

    public boolean isAlphanumeric(char ch) {
        return Character.isDigit(ch) || Character.isLetter(ch);
    }

    
}
