public class Token {
    private TokenType tokenType;
    private String value;

    public Token(String value){
        this.tokenType = tokenize(value);

        this.value = value;
    }

    public TokenType tokenize(String instruction){
        if(instruction.equals("return")){return TokenType._return;}
        // regex for matching any number
        else if(instruction.matches("\\d+")){return TokenType.INT_VALUE;}
        else if(instruction.matches(";")){return TokenType.SEMICOLON;}
        else {return TokenType.EXIT;}
    }

    public TokenType getTokenType(){
        return this.tokenType;
    }

    public String getValue(){
        return this.value;
    }
}
