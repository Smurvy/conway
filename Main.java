import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Lexer l = new Lexer("main.cys");
        printList(l.getTokens());
       
    }





    public static void printList(Token[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i].getTokenType() + ", ");
        }
        System.out.println();
    }

    public static void printList(Token[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j  = 0; j < arr[i].length;j++){
                System.out.print(arr[i][j].getTokenType() + ": " + arr[i][j].getValue() + ", ");
            }
            System.out.println();
            
        }
        System.out.println();
    }

    public static void printList(ArrayList<String> arr){
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i) + ", ");
        }
        System.out.println();
    }

    public static void printList(String[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
      

    

}