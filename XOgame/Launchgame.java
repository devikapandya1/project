import java.util.*;

public class Launchgame{
    public static void main(String args[]){
       TicTacToe t= new TicTacToe();
       t.dispboard();
       HumanPlayer p1= new HumanPlayer("Bob",'x');
       //HumanPlayer p2= new HumanPlayer("Devika",'o');
       AiPlayer p2 = new AiPlayer("TAI", 'o');

       Player cp;
       cp = p1;

    while(true){
        System.out.println(cp.name + " turn");
        cp.makeMove();
        TicTacToe.dispboard();
 
        if(TicTacToe.checkColwin()|| TicTacToe.checkRowwin() || TicTacToe.checkDiagwin()){
         System.out.println(cp.name +" has won");
         break;
        } else if(t.checkDraw()){
            System.out.println("game is a draw");
        }
        else{
             if(cp == p1){
                 cp = p2;
 
             }else{
                 cp = p1;
             }
        }

    }
       
    //    t.placeMark(0, 0,'x');
    //    t.placeMark(1, 0,'o');
    //    t.placeMark(0, 1,'x');
    //    t.placeMark(1, 1,'o');
    //    t.placeMark(0, 2,'x');
    //    t.dispboard();
    //    System.out.println(t.checkColwin());
    //    System.out.println(t.checkRowwin());
    //    System.out.println(t.checkDiagwin());
       
       
       
    }

       
}

class TicTacToe{
    static char board[][];

    public  TicTacToe(){
        board = new char [3][3];
        initBoard();

    }
    void initBoard(){
        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                board[i][j] = ' ';

            }
        }
    }
    static void dispboard(){

        System.out.println("-------------");
        for(int i = 0; i<board.length; i++){
            System.out.print("| ");
            for(int j =0; j<board[i].length; j++){
               System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    static void placeMark(int row, int col, char mark){
      if(row >= 0 && row<=2 && col>=0 && col <=2){
        board[row][col] = mark;
      }  
      else{
        System.out.println("invalid poition");
      }
    }
    static boolean checkColwin(){
        for(int j=0; j<=2; j++){
            if(  board[0][j]  != ' '  && board[0][j]== board[1][j] && 
                board[1][j]== board[2][j]){
                
                    return true;
            }
           
        }
        return false;
    }
    static boolean checkRowwin(){
        for(int i=0; i<=2; i++){
            if(board[i][0] !=' ' &&  board[i][0]== board[i][1] && 
                board[i][1]== board[i][2]){
                
                    return true;
            }
           
        }
        return false;
    }
    static boolean checkDiagwin(){
        if( board[0][0] != ' ' &&  board[0][0]== board[1][1] &&
            board[1][1] == board[2][2]|| 
            board[0][0] != ' ' && board[0][0]== board[1][1] && 
                    board[1][2]== board[2][2]){
                        return true;
        }
        else{
            return false;
        }
       
    }
    static boolean checkDraw(){
        for(int i =0; i<=2; i++){
            for(int j =0; j<=2; j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }
}
abstract class Player{
    String name;
    char mark;
    abstract void makeMove();

    boolean isValidmove(int row, int col){
        if(row>=0 && row <=2 &&
            col >=0 && col <=2){
                if(TicTacToe.board[row][col]== ' '){
                    return true;
                }
            }
        return false;
    }
}



class HumanPlayer extends Player{
   


    HumanPlayer(String name, char mark){
        this.name= name;
        this.mark = mark;

    }

    void makeMove(){
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        do{
            System.out.println("enter the row and col");
            row = sc.nextInt();
            col = sc.nextInt();
        }while(! isValidmove(row, col));

        TicTacToe.placeMark(row, col, mark);


    }

    // boolean isValidmove(int row, int col){
    //     if(row>=0 && row <=2 &&
    //         col >=0 && col <=2){
    //             if(TicTacToe.board[row][col]== ' '){
    //                 return true;
    //             }
    //         }
    //     return false;
    // }
}

class AiPlayer extends Player{

    AiPlayer(String name, char mark){
        this.name= name;
        this.mark = mark;

    }

    void makeMove(){
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        do{
            Random r = new Random();
            row=  r.nextInt(3);
            col = r.nextInt(3);
        }while(! isValidmove(row, col));

        TicTacToe.placeMark(row, col, mark);


    }

    // boolean isValidmove(int row, int col){
    //     if(row>=0 && row <=2 &&
    //         col >=0 && col <=2){
    //             if(TicTacToe.board[row][col]== ' '){
    //                 return true;
    //             }
    //         }
    //     return false;
    // }
}
