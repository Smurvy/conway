import java.util.Arrays;

public class Parser {
    private Node[] nodeTree;

    Parser(Token[][] tokens){
        // take each token, given special keywords, create node (some words will signify the ending of node and creating of assembly)
        // for example, print. which I want to be base function
        // -> add next n tokens (determined by ending characters like {},(), or ;) to node
        // needs to be done recursively as well.
        // break down a piece of code, dictate by either a semicolon, [],{},etc.

        for(int i = 0; i < tokens.length; i++){
            for(int j = 0; j < tokens[i].length;j++){
                Token curToken = tokens[i][j];

                Generator.generate(Arrays.copyOfRange(tokens[i], i+1, TokenType.nextSpecialChar(tokens[i]) + 1));

            }
        }
    
    }

        



}


