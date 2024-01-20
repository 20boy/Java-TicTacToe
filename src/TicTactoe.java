
import java.util.Scanner;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class TicTactoe {

        static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
        static ArrayList<Integer> AIPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char [][] theBoard = {{' ', '|', ' ', '|', ' '}, 
                             {'-', '+', '-', '+', '-'}, 
                             {' ', '|', ' ', '|', ' '},
                             {'-', '+', '-', '+', '-'},
                             {' ', '|', ' ', '|', ' '} 
        
        };
        printGameBoard(theBoard);
        
        while(true){
        Scanner input  = new Scanner(System.in);
        out.print("Please enter your placement (1-9) \n");
        int playerputting  = input.nextInt();
        while(playerPositions.contains(playerputting) || AIPositions.contains(playerputting)) {
            out.println("Position is Taken! Enter a correct Position");
            playerputting = input.nextInt();
        }
        
        placePiece(theBoard, playerputting, "player");
        
        String Result = checkWinner();
        
        if(Result.length() > 0){
          out.println(Result);
          break;
        }
        
        Random rand = new Random();
        int AIputting = rand.nextInt(9) + 1;
        while(playerPositions.contains(AIputting) || AIPositions.contains(AIputting)) {
            AIputting = rand.nextInt(9) + 1;
        }
        placePiece(theBoard, AIputting, "AI");
        printGameBoard(theBoard);
        
         Result = checkWinner();
        if(Result.length() > 0){
          out.println(Result);
          break;
        }
        
        }
        
       
        
       
        
    }
    public static void printGameBoard (char [][] theBoard) {
         for(char[] row : theBoard){
           for (char c : row) {
               System.out.print(c);
           }
           System.out.println();
            
        }
    }
    
    public static void placePiece (char [][]theBoard, int put, String user){
        char  symbol = ' ';
        
        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(put);
        } else if(user.equals("AI")) {
            symbol = '0';
            AIPositions.add(put);
        }
                
                
        
        switch(put){
           case 1:
               theBoard[0][0] = symbol;
               break;
           case 2:
               theBoard[0][2] = symbol;
               break;
           case 3:
               theBoard[0][4] = symbol;
               break;
           case 4:
               theBoard[2][0] = symbol;
               break; 
           case 5:
               theBoard[2][2] = symbol;
               break;
           case 6:
               theBoard[2][4] = symbol;
               break;
           case 7:
               theBoard[4][0] = symbol;
               break;
           case 8:
               theBoard[4][2] = symbol;
               break;
           case 9:
               theBoard[4][4] = symbol;
               break;  
           default:
               break;  
       }
    
}
    
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List middleCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List crossBoard1 = Arrays.asList(1,5,9);
        List crossBoard2 = Arrays.asList(7,5,3);
        
        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(middleCol);
        winningConditions.add(rightCol);
        winningConditions.add(crossBoard1);
        winningConditions.add(crossBoard2);
        
        for(List l: winningConditions) {
            if(playerPositions.containsAll(l)){
                return "You won me but I made a mistake! Wanna Play again..?";
            } else if(AIPositions.containsAll(l)){
                return "AIII HONNE hehe😎";
            } else if (playerPositions.size() + AIPositions.size() == 9){
                return "SHIT! It's a Tie";
            }
        }
        
        return "";
        
    }
}
    

