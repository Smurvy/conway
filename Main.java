import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("main.cys"));
			String line = reader.readLine();

			while (line != null) {
                // right now you have to put spaces between semicolons, this is stupid
                String[] keywords = line.split("\s",0);
                //printList(keywords);

                Token[] tokenized = tokenize(keywords);

                printList(tokenized);

				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void printList(Token[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i].getTokenType() + ", ");
        }
        System.out.println();
    }
      
    public static Token[] tokenize(String[] arr){
        Token[] tokens = new Token[arr.length];

        for(int i = 0; i < arr.length; i++){
            tokens[i] = new Token(arr[i]);
        }

        return tokens;
    }
}