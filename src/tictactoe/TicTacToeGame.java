package tictactoe;

public class TicTacToeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         TicTacToe game = new TicTacToe();
        game.printHeader();
        game.printBoard();
        
        // plays the tic tac toe game until the game is over
        while(!game.gameOver()){
        	// if it is player 1's turn it asks player to enter his/her move
            if(game.isPlayer1Turn()){
            	while(!game.isValidMove(game.player1Turn())){
            		// Will not continue until the user moves in a valid position
            	}
	            	game.whatPiece();
	                game.placeMarker(game.rightMove());
            }else{
            	   game.enhancedComputerMove();
	               game.whatPiece();
	               game.placeMarker(game.rightMove());
            }
            game.printBoard();
        } 
    }
    
}
