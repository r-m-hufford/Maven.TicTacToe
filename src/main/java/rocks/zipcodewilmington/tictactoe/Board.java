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

        //Horizontal Condition
        if (horizontalWin('X')) {
            xWins = true;
        }

        if (rightToLeftDiagonalWin('X')){
            xWins = true;
        }

        if (leftToRightDiagonalWin('X')){
            xWins = true;
        }

        return xWins;
    }


    public Boolean isInFavorOfO() {
        boolean oWins = false;
        //Vertical condition
        if (verticalWin('O')) {
            oWins = true;
        };

        //Horizontal Condition
        if (horizontalWin('O')) {
            oWins = true;
        }

        if (rightToLeftDiagonalWin('X')){
            oWins = true;
        }

        if (leftToRightDiagonalWin('X')){
            oWins = true;
        }

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
        boolean winner = false;
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][0] == a &&
                    (gameBoard[i][0]==gameBoard[i][1] && gameBoard[i][0]==gameBoard[i][2])) {
                winner = true;
            }
        }
        return winner;

    }

        public boolean verticalWin (char a){
            //Vertical condition
            boolean winner = false;
            for (int i = 0; i < gameBoard.length; i++) {
                if (gameBoard[0][i] == a &&
                        (gameBoard[0][i]==gameBoard[1][i] && gameBoard[0][i]==gameBoard[2][i])) {
                    winner = true;
                }
            }
            return winner;
    }

        public boolean rightToLeftDiagonalWin (char a){
            boolean winner = false;
            if (gameBoard[0][2] == a && gameBoard[0][2]==gameBoard[1][1] && gameBoard[0][2]==gameBoard[2][0]) {
                winner = true;}

            return winner;
        }

        public boolean leftToRightDiagonalWin (char a){
            boolean winner = false;
            if (gameBoard[0][0] == a && gameBoard[0][0]==gameBoard[1][1] && gameBoard[0][0]==gameBoard[2][2]) {
                winner = true;}

            return winner;
        }

    }
