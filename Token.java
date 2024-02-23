public class Token {
    private TokenType tokenType;
    private String value;

    public Token(String value){
        this.tokenType = tokenize(value);
        this.value = value;
    }
    public Token(TokenType t){
        this.tokenType = t;
        this.value = null;
    }

    public static TokenType tokenize(String instruction){
        if(instruction.equals("return")){return TokenType._return;}
        // regex for matching any number
        else if(instruction.matches("\\d+")){return TokenType.INT_VALUE;}
        else if(instruction.equals(";")){return TokenType.SEMICOLON;}
        else {return TokenType.EXIT;}
    }

    public static TokenType tokenize(char specialChar){
        if(specialChar == ';'){return TokenType.SEMICOLON;}
        else {return TokenType.EXIT;}
    }

    public TokenType getTokenType(){
        return this.tokenType;
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object t){
        if(t.getClass() != this.getClass()){
            return false;
        }

        Token casted = (Token) t;

        if(this.getTokenType() == casted.getTokenType()){
            return true;
        }

        return false;
    }
}
