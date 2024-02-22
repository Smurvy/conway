public enum TokenType {
    // add any keywords here
    _return,
    INT_VALUE,
    SEMICOLON,
    OPEN_BRACE,
    CLOSE_BRACE,
    OPEN_PARENTHESES,
    CLOSE_PARENTHESES,
    EXIT;

    // if there is a special character associated, then add it here
    // don't forget to add an else statement to tokenize function in the token class
    public static final char[] specialChars = {
        ';',
        '{',
        '}',
        '(',
        ')'
    };

    public static boolean containsSpecialChar(String word){
        for(int i = 0; i < specialChars.length;i++){
            if(word.contains(String.valueOf(specialChars[i]))){
                return true;
            }
        }
        return false;
    }

    public static int nextSpecialChar(String word){
        for(int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            for(int j = 0; j < specialChars.length;j++){
                if(curChar == specialChars[j]){
                    return i;
                }
            }
        }

        return -1;
    }
}
