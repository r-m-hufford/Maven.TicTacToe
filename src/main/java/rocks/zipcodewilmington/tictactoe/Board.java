package rocks.zipcodewilmington.tictactoe;

import java.sql.SQLOutput;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    private final Character[][] gameBoard;

    public Board(Character[][] matrix) {

        this.gameBoard = matrix;
    }

    public Boolean isInFavorOfX() {
        boolean xWins = false;
        //Vertical condition
        if (verticalWin('X')) {
            xWins = true;
        };

        return xWins;
    }


    public Boolean isInFavorOfO() {
        boolean oWins = false;
        //Vertical condition
        int winningIndex = 0;
        for (int i = 0; i < gameBoard.length - 1; i++) {
            if (gameBoard[0][i] == 'O') {
                winningIndex = i;
            }
        }
        if (gameBoard[0][winningIndex]==gameBoard[1][winningIndex] && gameBoard[0][winningIndex]==gameBoard[2][winningIndex]) {
            oWins = true;}

        //Horizontal Condition
        for (int i = 0; i < gameBoard.length - 1; i++) {
            if (gameBoard[i][0] == 'O') {
                winningIndex = i;
            }
        }
        if (gameBoard[winningIndex][0]==gameBoard[winningIndex][1] && gameBoard[winningIndex][0]==gameBoard[winningIndex][2]) {
            oWins = true;}

        // RIGHT/LEFT Diagonal Condition

        if (gameBoard[0][2] == 'O' && gameBoard[0][2]==gameBoard[1][1] && gameBoard[0][2]==gameBoard[2][0]) {
            oWins = true;}

        // LEFT/RIGHT Diagonal Condition
        if (gameBoard[0][0] == 'O' && gameBoard[0][0]==gameBoard[1][1] && gameBoard[0][0]==gameBoard[2][2]) {
            oWins = true;}

        return oWins;
    }

    public Boolean isTie() {
        boolean isTie = false;

        if (!isInFavorOfO() && !isInFavorOfX()) {
            isTie = true;
        }
        return isTie;
    }
        public String getWinner () {
            String winner = "";
            boolean wins = isInFavorOfO();


            if (isInFavorOfO()) {
                winner = "O";
            }   else if (isInFavorOfX()) {
                winner = "X";
            }
            return winner;
        }

/////////HELPER FUNCTIONS/////////////HELPER FUNCTIONS//////////////


        public boolean horizontalWin (char a) {
            return false;
        }

        public boolean verticalWin (char a){
            //Vertical condition
            boolean winner = false;
            for (int i = 0; i < gameBoard.length - 1; i++) {
                if (gameBoard[0][i] == a &&
                        (gameBoard[0][i]==gameBoard[1][i] && gameBoard[0][i]==gameBoard[2][i])) {
                    winner = true;
                }
            }
            return winner;
    }

        public boolean diagonalWin (){
            return false;
        }
    }

//if (gameBoard[0][1] == 'O' && gameBoard[0][1]==gameBoard[1][1] && gameBoard[0][1]==gameBoard[2][1])