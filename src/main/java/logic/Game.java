package logic;

import logic.pieces.Pawn;
import ui.UI;
import util.GameColor;

public class Game {

    public Board board;
    public UI uiBoard;
    public Game() {
        this.board = new Board();
        this.uiBoard = new UI(board);
    }

    public static void main(String[] args) {
        Game game = new Game();
        Field field = game.board.fields[2][2];
        Field field2 = game.board.fields[3][2];
        field.setPiece(new Pawn(GameColor.Black, game.board.fields, field));
        field2.setPiece(new Pawn(GameColor.White, game.board.fields, field2));
        game.uiBoard.update();
    }
}
