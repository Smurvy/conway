import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lexer {
    private Token[][] tokens;

    
    Lexer(String fileName){
        ArrayList<Token[]> temp_tokens = new ArrayList<Token[]>();
        
        BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(fileName));
                String line = reader.readLine();

                while (line != null) {
                    // split line into seperate instructions so they can be consumed as tokens
                    String[] splitLine = splitLine(line);
                    // take those idividual instructions -> tokenizie them
                    temp_tokens.add(tokenize(splitLine));



                    // read next line
                    line = reader.readLine();
                }

                reader.close();

                this.tokens = new Token[temp_tokens.size()][];
                for(int i = 0; i < temp_tokens.size();i++){
                    tokens[i] = temp_tokens.get(i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    // test{;
    public static ArrayList<String> splitWord(String word){
        ArrayList<String> arr = new ArrayList<String>();
        if(!TokenType.containsSpecialChar(word)){
            arr.add(word);
            return arr;
        }
        String recentWord = word.substring(0,TokenType.nextSpecialChar(word));
        if(recentWord.length() > 0){
            arr.add(recentWord);
        }
        
 
        String specialChar = word.substring(TokenType.nextSpecialChar(word),TokenType.nextSpecialChar(word) + 1);
        arr.add(specialChar);
        
        if(TokenType.nextSpecialChar(word) != word.length() - 1){
            // whatever is leftover
            String whateverIsLeftover = word.substring(TokenType.nextSpecialChar(word) + 1);
            arr.addAll(splitWord(whateverIsLeftover));

        }
        

        return arr;

    }
    

    private String[] splitLine(String line){
        // remove spaces from line
        String[] keywords = line.split("\s",0);
    
        
        ArrayList<String> tempTokens = new ArrayList<String>();

        
        // split semicolons (could add other things to split at:brackets?)
        // we essentially do the preliminary step of splitting at the spaces, 
        // then we can move onto splitting at brackets,semicolons,etc.
        for(int i = 0;i < keywords.length;i++){
            // Strip is redundant?
            keywords[i] = keywords[i].strip();
            
            tempTokens.addAll(splitWord(keywords[i]));
        }

        String[] lineTokens = new String[tempTokens.size()];

        for(int i = 0; i < tempTokens.size(); i++){
            lineTokens[i] = tempTokens.get(i);
        }

        
        return lineTokens;
        
    }
    
    public Token[][] getTokens(){
        return this.tokens;
    }

    public Token[] tokenize(String[] arr){
        Main.printList(arr);
        Token[] temp_tokens = new Token[arr.length];

        for(int i = 0; i < arr.length; i++){
            temp_tokens[i] = new Token(arr[i]);
        
        }
        return temp_tokens;
    }

    public Token[] tokenize(ArrayList<String> arr){
        Token[] tokens = new Token[arr.size()];

        for(int i = 0; i < arr.size(); i++){
            tokens[i] = new Token(arr.get(i));
        }

        return tokens;
    }


    public String[] splitSemicolons(String str){
        String[] arr = new String[2];
        if(str.indexOf(";") < 0){
            arr[0] = str;
            arr[1] = "";
            return arr;
        }

        arr[0] = str.substring(0,str.indexOf(";"));
        // there is probably a better way to do this
        arr[1] = ";";

        
        return arr;


    }
}
