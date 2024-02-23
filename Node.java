public class Node {
    private Token nodeHead;

    Node(Token nodeHead,Token[] nodeInstructions){
        this.nodeHead = nodeHead;
       
    }

    Node(Token token){
        this.nodeHead = token;
    }
}
