package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    // private instance variables
    private char [][]board = new char[3][3];
    private char piece;
    private int marker, count=0, player1Move, computerMove,boardCount=1, computerMoveRow, computerMoveColumn;
   
    
    /* Constructor */
    /* Initalizes the board with underscores*/
    public TicTacToe(){
	    for(int i=0; i<3; i++){
	        for (int j=0;j<3; j++){
	            board[i][j] = '_';
	        }
	    }
    }
    
    /* Methods */
    // prints the header of the program
    public void printHeader(){
    	System.out.print("-----------------------------------------\n");
    	System.out.print("Welcome to Tic Tac Toe, my Good Sir!! :) \n");	
    }
    
    // prints the tic tac toe board and the number for the cell 
    public void printBoard(){
        int entry = 1;
        System.out.print("-----------------------------------------\n");
        for(int i=0; i<3; i++){
            System.out.println();
            for (int j=0;j<3; j++){
                System.out.print(entry + "|___" + board[i][j] + "___|");
                entry++;
            }
        }
        System.out.println();
    }
   
    // determines if the game is over which is when someone wins horizontally, vertically, diagonally or if the board is filled
    public boolean gameOver(){
       if(isHorizontalWin()){
           return true;
       }
       else if(isDiagonalWin()){
           return true;
       }
       else if(isVerticalWin()){
           return true;
       }
       else if(isBoardFull()){
    	   return true;
       }
       return false; 
    }
    
    // prints the winner by determining whos turn it is when the winning move is made
    public void printWinner(){
    	if(!isPlayer1Turn()){
    		System.out.println("\n Congratulations Player 1 is Victorious!!!");
    	}
    	else{
    		System.out.println("\n Computer is Victorious!!!");
    	}
    }
    
    // checks to see if it is a horizontal win
    public boolean isHorizontalWin(){
        if((board[0][0]== 'X' || board[0][0] == 'O') && (board[0][1]== 'X' || board[0][1] == 'O') && board[0][0] == board[0][1] && (board[0][2]=='X' || board[0][2] == 'O') && board[0][1] == board[0][2]){
            printWinner();
            return true;
        }else if((board[1][0]== 'X' || board[1][0] == 'O') && (board[1][1]== 'X' || board[1][1] == 'O') && board[1][0] == board[1][1] && (board[1][2]=='X' || board[1][2] == 'O') && board[1][1] == board[1][2]){
        	printWinner();
            return true;
        }else if((board[2][0]== 'X' || board[2][0] == 'O') && (board[2][1]== 'X' || board[2][1] == 'O') && board[2][0] == board[2][1] && (board[2][2]=='X' || board[2][2] == 'O') && board[2][1] == board[2][2]){
        	printWinner();
            return true;
        }
        return false;
    }
    
    // checks to see if it is a diagonal win
    public boolean isDiagonalWin(){
        if((board[0][0]== 'X' || board[0][0] == 'O') && (board[1][1]== 'X' || board[1][1] == 'O') && board[0][0] == board[1][1] && (board[2][2]=='X' || board[2][2] == 'O') && board[1][1] == board[2][2]){
        	printWinner();
            return true;
        }else if((board[2][0]== 'X' || board[2][0] == 'O') && (board[1][1]== 'X' || board[1][1] == 'O') && board[2][0] == board[1][1] && (board[0][2]=='X' || board[0][2] == 'O') && board[1][1] == board[0][2]){
        	printWinner();
            return true;
        }
        return false;
    }
    
    // checks to see if it is a vertical win
    public boolean isVerticalWin(){
        if((board[0][0]== 'X' || board[0][0] == 'O') && (board[1][0]== 'X' || board[1][0] == 'O') && board[0][0] == board[1][0] && (board[2][0]=='X' || board[2][0] == 'O') && board[1][0] == board[2][0]){
        	printWinner();
            return true;
        }
        else if((board[0][1]== 'X' || board[0][1] == 'O') && (board[1][1]== 'X' || board[1][1] == 'O') && board[0][1] == board[1][1] && (board[2][1]=='X' || board[2][1] == 'O') && board[1][1] == board[2][1]){
        	printWinner();
            return true;
        }else if((board[0][2]== 'X' || board[0][2] == 'O') && (board[1][2]== 'X' || board[1][2] == 'O') && board[0][2] == board[1][2] && (board[2][2]=='X' || board[2][2] == 'O') && board[1][2] == board[2][2]){
        	printWinner();
            return true;
        }
        return false;
    }
    
    // checks if it is player one's turn
    public boolean isPlayer1Turn(){
        count++;
        if(count % 2 == 0){
            return false; // indicates the computers turn
        }
        return true; // indicate the player 1 turn
    }
    
    // when it is player1's turn it asks player 1 for their move on the boardand validates the move
    public int player1Turn(){
        Scanner input = new Scanner(System.in); 
        System.out.println();
        // validates player1's move 
        do{
	        System.out.println("Player1's Turn please enter a valid 1integer from 1-9: ");
	        while(!input.hasNextInt()){
	        	System.out.println("That's not a number!");
	        	input.next();
	        }
	        player1Move = input.nextInt();
        }while(player1Move < 1 || player1Move > 9);
        return player1Move;
    }
    
     //When it is the computers turn it uses a random number
//    public int computerTurn(){
//        System.out.println();
//        System.out.println("Computer's Turn: ");
//        Random rn = new Random();
//        computerMove = rn.nextInt(9) + 1;
//       
//        while(!isValidMove(computerMove)){ // will not allow the computer to move in a position that is not valid
//        	computerMove = rn.nextInt(9) + 1;
//        }
//        return computerMove;
//    }
    
    // determines what piece to put on the board by determining if it is player1's turn or not
    public char whatPiece(){
    	// if it is player 1's turn then place an X
        if(!isPlayer1Turn()){ 
            piece = 'X';
        }
        else{
        	// place an O if it is computers turn
            piece = 'O'; 
        }
        return piece;
    }
    
    public int rightMove(){
    	  if (isPlayer1Turn()){ 
              marker = player1Move;
          }
          else{
              marker = computerMove;
          }
    	return marker;
    }
   
    // places a marker (X or O) on the board
    public void placeMarker(int marker){
    				// determines the piece to put on the board by whos turn it is
                    // puts the marker according to the position they choose on the board
                    marker--;
                    int row = marker/3;
                    int col = marker % 3;
                    board[row][col] = piece;
                          
    }
    
    // validates the move and checks if there is a piece in that position already
    public boolean isValidMove(int marker){
                    switch(marker){
                        case 1:
                            if(board[0][0] == 'X' || board[0][0] == 'O'){
                                return false;
                            }
                            break;
                            
                        case 2:
                            if(board[0][1] == 'X' || board[0][1] == 'O'){
                                return false;
                            }
                            break; 
                        case 3:
                            if(board[0][2] == 'X' || board[0][2] == 'O'){
                                return false;
                            }
                            break;
                        case 4:
                            if(board[1][0] == 'X' || board[1][0] == 'O'){
                                return false;
                            }
                            break;
                        case 5:
                            if(board[1][1] == 'X' || board[1][1] == 'O'){
                                return false;
                            }
                            break;
                        case 6:
                            if(board[1][2] == 'X' || board[1][2] == 'O'){
                                return false;
                            }
                            break;
                        case 7:
                            if(board[2][0] == 'X' || board[2][0] == 'O'){
                                return false;
                            }
                            break;
                        case 8:
                            if(board[2][1] == 'X' || board[2][1] == 'O'){
                                return false;
                            }
                            break;
                        case 9:
                            if(board[2][2] == 'X' || board[2][2] == 'O'){
                                return false;
                            }
                            break;    
                    }
                    return true;
    }
    
    // determines weather the board is full or not
    public boolean isBoardFull(){
        for(int i=0; i<3; i++){
            for (int j=0;j<3; j++){
                if(board[i][j] == '_'){
                    return false;
                }
            }
        }
        System.out.println("\nGame is a tie!!!");
        return true;
    }
    
    
   public void enhancedComputerMove(){
	   int goodMove;
	   System.out.println();
	   System.out.println("Computer's Turn: ");
	   Random rn = new Random();
       computerMove = rn.nextInt(9) + 1;
       while(!isValidMove(computerMove)){ // will not allow the computer to move in a position that is not valid
       	computerMove = rn.nextInt(9) + 1;
       }
       
	   // checks to see if the winnning move can be made in any row
	   for(int i=0; i<3; i++){
		   int countO=0, countEmpty=0;
		   for (int j = 0; j < 3; j++) {
			   // row 1
			   if(board[i][j] == 'O'){
				   countO++;
			   }else if(board[i][j] == '_'){
				   countEmpty++;
				   computerMoveRow = i;
				   computerMoveColumn = j;
				   
			   }
			}
		   if(countO == 2 && countEmpty == 1){
			   // place position here
			   computerMove = converToPos(computerMoveRow, computerMoveColumn);
			   placeMarker(computerMove);
		   }
	   }
	   
	   // checks to see if the winning move can be made in any column
	   for(int i=0; i<3; i++){
		   int countO=0, countEmpty=0;
		    // row 1
			   if(board[i][i] == 'O'){
				   countO++;
			   }else if(board[i][i] == '_'){
				   countEmpty++;
				   computerMoveRow = i;
				   computerMoveColumn = i;
			   if(countO == 2 && countEmpty == 1){
					   // place position here
					   computerMove = converToPos(computerMoveRow, computerMoveColumn);
					   placeMarker(computerMove);
		      }
		}
	      		   
		   
		 // checks to see if the winning move can be made in the first diagonal from left to right
		 for(int i1=0; i1<3; i1++){
			   int count1=0, countEmpty1=0;
				   // row 1
				   if(board[i1][2-i1] == 'O'){
					   count1++;
				   }else if(board[i1][2-i1] == '_'){
					   countEmpty1++;
					   computerMoveRow = i1;
					   computerMoveColumn = 2-i1;
				   }  
		   if(count1 == 2 && countEmpty1 == 1){
			   // place position here
			   computerMove = converToPos(computerMoveRow, computerMoveColumn);
			   placeMarker(computerMove);
		   		}
		   
		 }
		 
	   }
	   
	   // checks the see if the winning move can be made in the second diagonal from right to left
	   for(int i=0; i<3; i++){
		   int countO=0, countEmpty=0;
		   for (int j = 0; j < 3; j++) {
			   // row 1
			   if(board[j][i] == 'O'){
				   countO++;
			   }else if(board[j][i] == '_'){
				   countEmpty++;
				   computerMoveRow = j;
				   computerMoveColumn = i;
			   }
		   }
		}
	   
	   
   }
   
   public int converToPos(int row, int col){
	   return row*3 + col + 1; 
   }
   
}
